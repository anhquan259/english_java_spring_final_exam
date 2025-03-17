package WebThiTA.controller;

import WebThiTA.model.User;
import WebThiTA.reponsitory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserRepo userRepo;

    public static String getSHAHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            return convertByteToHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertByteToHex(byte[] data) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    @RequestMapping("")
    public ModelAndView registerGet(ModelMap model, HttpServletRequest request) {
        HttpSession ss = request.getSession();
        if (ss.getAttribute("username") != null)
            return new ModelAndView("redirect:/", model);
        return new ModelAndView("register", model);
    }

    @PostMapping("/authen")
    public ModelAndView loginPost(ModelMap model, HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String repass = request.getParameter("repassword");
        List<User> list = userRepo.findAll();
        boolean ok = true;
        for (User i : list) {
            if (i.getUsername().equals(email) || !repass.equals(password)) {
                ok = false;
                break;
            }
        }
        if (list.size() == 0 && repass.equals(password) || ok && repass.equals(password)) {
            User dto = new User(email, getSHAHash(repass), fullname);
            userRepo.save(dto);
            HttpSession ss = request.getSession();
            ss.setAttribute("username", email);
            return new ModelAndView("redirect:/", model);
        }
        model.addAttribute("message", "Email đã tồn tại hoặc xác nhận mật khẩu không khớp");
        return new ModelAndView("redirect:/register", model);
    }
}
