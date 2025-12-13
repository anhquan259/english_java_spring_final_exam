package WebThiTA.controller;

import WebThiTA.dto.BaiThiDTO;
import WebThiTA.dto.CauHoiDTO;
import WebThiTA.model.BaiThi;
import WebThiTA.model.CauHoi;
import WebThiTA.model.Diem;
import WebThiTA.model.User;
import WebThiTA.reponsitory.BaiThiRepo;
import WebThiTA.reponsitory.CauHoiRepo;
import WebThiTA.reponsitory.DiemRepo;
import WebThiTA.reponsitory.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("")
public class ThiController {
    @Autowired
    private CauHoiRepo cauHoiRepo;
    @Autowired
    private BaiThiRepo baiThiRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DiemRepo diemRepo;

    @RequestMapping("/listbaithi")
    public String baithi(Model model, HttpServletRequest request) {
        //authen
        HttpSession ss = request.getSession();
        if (ss.getAttribute("username") == null)
            return "redirect:/login";

        List<BaiThi> listBaiThi = baiThiRepo.findAll();
        model.addAttribute("listBaiThi", listBaiThi);
        return "ListBaiThi";

    }

    @Transactional
    @RequestMapping("/thi/{examId}")
    public ModelAndView loadCauHoiThi(ModelMap model, @PathVariable("examId") Long examId, HttpServletRequest request) {
        //authen
        HttpSession ss = request.getSession();
        if (ss.getAttribute("username") == null)
            return new ModelAndView("redirect:/login", model);

        //lấy câu hỏi thi
        BaiThi baiThi = baiThiRepo.getById(examId);
        BaiThiDTO baiThiDTO = new BaiThiDTO();
        BeanUtils.copyProperties(baiThi, baiThiDTO);
        List<CauHoi> listCauHoi = new ArrayList<>(baiThi.getListQuestion());
        ArrayList<CauHoiDTO> listCauHoiDTO = new ArrayList<>();
        Long index = (long) 1;

        for (CauHoi cauhoi : listCauHoi) {
            CauHoiDTO cauHoiDTO = new CauHoiDTO();
            BeanUtils.copyProperties(cauhoi, cauHoiDTO);
            cauHoiDTO.setIndex(index);
            cauHoiDTO.setCauTraLoi(String.valueOf(index));
            index += 1;
            listCauHoiDTO.add(cauHoiDTO);
            baiThiDTO.setListCauHoi(listCauHoiDTO);
        }
        model.addAttribute("baiThi", baiThiDTO);

        int sLCauDung = 0;
        model.addAttribute("sLCauDung", sLCauDung);

        return new ModelAndView("Thi", model);
    }

    @RequestMapping("/thi/nopbai")
    public String nopbai(Model model, HttpServletRequest request, @ModelAttribute("baiThi") BaiThiDTO baiThi) {
        //authen
        HttpSession ss = request.getSession();
        if (ss.getAttribute("username") == null)
            return "redirect:/login";

        int dem = 0;
        for (CauHoiDTO cauHoi : baiThi.getListCauHoi()) {
            if (cauHoi.getCauTraLoi() != null && cauHoi.getCauTraLoi().equals(cauHoi.getCorrectanswer())) {
                dem += 1;
            }
        }

        int slcauhoi = baiThi.getListCauHoi().size();
        double point = dem * 10.0 / slcauhoi;

        String username = (String) ss.getAttribute("username");
        Optional<Diem> diemopt = diemRepo.find2(username, baiThi.getExamId());
        System.out.println(diemopt.isEmpty());

        if (!diemopt.isEmpty()) {
            Diem diem = diemopt.get();
            diem.setPoint(point);
            diem.setTestDay((new Date()).toString());
            BaiThi baiThi2 = new BaiThi();
            baiThi2.setExamId(baiThi.getExamId());
            diem.setExam(baiThi2);
            Optional<User> user = userRepo.findByUsername(username);
            diem.setUser(user.get());
            diemRepo.save(diem);
        } else {
            Diem diem = new Diem();
            diem.setPoint(point);
            diem.setTestDay((new Date()).toString());

            BaiThi baiThi2 = new BaiThi();
            baiThi2.setExamId(baiThi.getExamId());
            diem.setExam(baiThi2);

            Optional<User> user = userRepo.findByUsername(username);
            diem.setUser(user.get());
            diemRepo.save(diem);
        }

        List<Diem> listdiem = diemRepo.findByUsername(username);
        double diemtb = 0;

        for (Diem d : listdiem) {
            diemtb += d.getPoint();
        }
        diemtb /= listdiem.size();

        Optional<User> u = userRepo.findByUsername(username);
        u.get().setDiemTB(diemtb);
        userRepo.save(u.get());

        List<BaiThi> listBaiThi = baiThiRepo.findAll();
        model.addAttribute("listBaiThi", listBaiThi);

        return "redirect:/listbaithi";
    }

    @RequestMapping("/thi/add")
    public String thiNew(Model model, HttpServletRequest request) {
        //authen
        HttpSession ss = request.getSession();
        if (ss.getAttribute("username") == null)
            return "redirect:/login";
        //lấy bai thi
        model.addAttribute("baiThi", new BaiThiDTO());
        return "ThiNew";
    }

    @Transactional
    @RequestMapping("/thi/edit/{id}")
    public String thiEdit(@PathVariable Long id,Model model, HttpServletRequest request) {
        //authen
        HttpSession ss = request.getSession();
        BaiThi baiThi = baiThiRepo.findById(id).get();;

        if (ss.getAttribute("username") == null)
            return "redirect:/login";
        //lấy bai thi
        model.addAttribute("baiThi", convertToDTO(baiThi));
        return "ThiEdit";
    }
    @PostMapping("/thi/edit-exam/{id}")
    public String updateExam(@PathVariable Long id,@ModelAttribute BaiThiDTO baiThiDTO) {
        BaiThi entity = toEntity(baiThiDTO);
        entity.setExamId(id);
        baiThiRepo.save(entity);
        return "redirect:/listbaithi";
    }

    @RequestMapping("/thi/add-exam")
    public String thiAddExam(Model model, HttpServletRequest request, @ModelAttribute("baiThi") BaiThiDTO baiThi) {
        BaiThi baiThiSave = new BaiThi();
        convertBaiThiDTOToBaiThi(baiThi, baiThiSave);
        try {
            baiThiRepo.save(baiThiSave);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/listbaithi";
    }

    private void convertBaiThiDTOToBaiThi(BaiThiDTO baiThiDTO, BaiThi baiThi) {
        baiThi.setContent(baiThiDTO.getContent());
        baiThi.setExamName(baiThiDTO.getExamName());
        baiThi.setExamTime(baiThiDTO.getExamTime());
        Set<CauHoi> cauHoiSet = new HashSet<>();
        if (baiThiDTO.getListCauHoi() != null || baiThiDTO.getListCauHoi().size() > 0) {
            for (CauHoiDTO cauHoiDTO : baiThiDTO.getListCauHoi()) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setExam(baiThi);
                cauHoi.setCorrectanswer(cauHoiDTO.getCorrectanswer());
                cauHoi.setOption1(cauHoiDTO.getOption1());
                cauHoi.setOption2(cauHoiDTO.getOption2());
                cauHoi.setOption3(cauHoiDTO.getOption3());
                cauHoi.setOption4(cauHoiDTO.getOption4());
                cauHoi.setQuestion(cauHoiDTO.getQuestion());
                cauHoiSet.add(cauHoi);
            }
        }

        baiThi.setListQuestion(cauHoiSet);
    }
    public BaiThiDTO convertToDTO(BaiThi entity) {
        BaiThiDTO dto = new BaiThiDTO();
        dto.setExamId(entity.getExamId());
        dto.setExamName(entity.getExamName());
        dto.setContent(entity.getContent());
        dto.setExamTime(entity.getExamTime());
        if (entity.getListQuestion() != null) {
            ArrayList<CauHoiDTO> list = new ArrayList<>();

            for (CauHoi q : entity.getListQuestion()) { long index = 0;
                CauHoiDTO qdto = new CauHoiDTO();
                qdto.setQuestionId(q.getQuestionId());
                qdto.setQuestion(q.getQuestion());
                qdto.setOption1(q.getOption1());
                qdto.setOption2(q.getOption2());
                qdto.setOption3(q.getOption3());
                qdto.setOption4(q.getOption4());
                qdto.setCorrectanswer(q.getCorrectanswer());
                qdto.setExam(entity);
                qdto.setIndex(index++);
                list.add(qdto);
            }

            dto.setListCauHoi(list);
            dto.setNumberOfQuestions(list.size());
        }
        return dto;
    }

    public BaiThi toEntity(BaiThiDTO dto) {
        BaiThi entity = new BaiThi();
        entity.setExamId(dto.getExamId());
        entity.setExamName(dto.getExamName());
        entity.setContent(dto.getContent());
        entity.setExamTime(dto.getExamTime());

        Set<CauHoi> questions = new HashSet<>();

        if (dto.getListCauHoi() != null) {
            for (CauHoiDTO qdto : dto.getListCauHoi()) {
                CauHoi q = new CauHoi();
                q.setQuestionId(qdto.getQuestionId()); // null = thêm mới
                q.setQuestion(qdto.getQuestion());
                q.setOption1(qdto.getOption1());
                q.setOption2(qdto.getOption2());
                q.setOption3(qdto.getOption3());
                q.setOption4(qdto.getOption4());
                q.setCorrectanswer(qdto.getCorrectanswer());

                q.setExam(entity); // ⭐ QUAN TRỌNG
                questions.add(q);
            }
        }

        entity.setListQuestion(questions);
        return entity;
    }

}
