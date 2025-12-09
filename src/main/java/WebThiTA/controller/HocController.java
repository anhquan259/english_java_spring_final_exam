package WebThiTA.controller;


import WebThiTA.dto.KhoaHocDTO.BaiHocDTO;
import WebThiTA.dto.KhoaHocDTO.LessonDTO;
import WebThiTA.dto.KhoaHocDTO.LevelDTO;
import WebThiTA.model.BaiHoc;
import WebThiTA.model.Lesson;
import WebThiTA.model.Level;
import WebThiTA.reponsitory.BaiHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("")
public class HocController {

    @Autowired
    private BaiHocRepo baiHocRepo;

    @RequestMapping("/khoahoc")
    public String baithi(Model model, HttpServletRequest request) {
        //authen
        HttpSession ss = request.getSession();
        if (ss.getAttribute("username") == null)
            return new String("redirect:/login");
        //lấy bai thi
        List<BaiHoc> listBaiHoc = baiHocRepo.findAllWithLevelAndLesson();
        List<LevelDTO> allLevelDTOs = convertToDTO(listBaiHoc);
        model.addAttribute("allLevels", allLevelDTOs);
        return "KhoaHoc";

    }

    @RequestMapping("/khoahoc/{lessonId}")
    public String baithi(Model model, HttpServletRequest request, @PathVariable("lessonId") Long lessonId) {
        //authen
        HttpSession ss = request.getSession();
        if (ss.getAttribute("username") == null)
            return new String("redirect:/login");
        //lấy bai thi
        System.out.println(lessonId);
        Optional<BaiHoc> baiHoc = baiHocRepo.findById(lessonId);
        model.addAttribute("baiHoc", baiHoc.get());
        return "BaiHoc";

    }

    @RequestMapping("/khoahoc/add")
    public String baiHoc(Model model, HttpServletRequest request) {
        //authen
        HttpSession ss = request.getSession();
        if (ss.getAttribute("username") == null)
            return new String("redirect:/login");
        //lấy bai thi
        List<BaiHoc> listBaiHoc = baiHocRepo.findAll();
        model.addAttribute("baiHoc", new BaiHoc());
        return "BaiHocAdd";
    }

    @PostMapping("/khoahoc/add-lesson")
    public String addLesson(@ModelAttribute("baiHoc") BaiHoc baiHoc) {
        // Lưu bài học vào cơ sở dữ liệu
        baiHocRepo.save(baiHoc);
        return "redirect:/khoahoc"; // Điều hướng sau khi thêm thành công
    }

    public List<LevelDTO> convertToDTO(List<BaiHoc> baiHocs) {
        Map<Long, LevelDTO> levelMap = new LinkedHashMap<>();

        for (BaiHoc bh : baiHocs) {
            // Load dữ liệu tránh lazy
            Long levelId = bh.getLevel().getLevelId();
            String levelName = bh.getLevel().getName();
            Long lessonId = bh.getLesson().getLessonId();
            String lessonTitle = bh.getLesson().getName();

            // Lấy hoặc tạo LevelDTO
            LevelDTO levelDTO = levelMap.computeIfAbsent(levelId, id -> new LevelDTO(levelId, levelName));

            // Lấy hoặc tạo LessonDTO
            LessonDTO lessonDTO = levelDTO.getLessons().stream()
                    .filter(l -> l.getLessonId().equals(lessonId))
                    .findFirst()
                    .orElseGet(() -> {
                        LessonDTO l = new LessonDTO(lessonId, lessonTitle);
                        levelDTO.getLessons().add(l);
                        return l;
                    });

            // Thêm BaiHocDTO
            BaiHocDTO bhDTO = new BaiHocDTO(bh.getUnitId(), bh.getTitle());
            lessonDTO.getBaiHocs().add(bhDTO);
        }
        return new ArrayList<>(levelMap.values());
    }
}
