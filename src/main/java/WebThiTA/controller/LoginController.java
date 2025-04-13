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
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {
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
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    @RequestMapping("")
    public ModelAndView loginGet(ModelMap model, HttpServletRequest request) {
        HttpSession ss = request.getSession();
        if (ss.getAttribute("username") != null)
            return new ModelAndView("redirect:/", model);
        return new ModelAndView("login", model);
    }

    @PostMapping("/authen")
    public ModelAndView loginPost(ModelMap model, HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String hashedPassword = getSHAHash(password);

        Optional<User> userOptional = userRepo.findByUsername(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            System.out.println("DEBUG: Mật khẩu đã hash: " + hashedPassword);
            System.out.println("DEBUG: Mật khẩu trong DB: " + user.getPassword());

            if (user.getPassword().equals(hashedPassword)) {
                HttpSession ss = request.getSession();
                ss.setAttribute("username", email);
                ss.setAttribute("role", user.getRole() + "");
                return new ModelAndView("redirect:/", model);
            }
        }

        model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
        return new ModelAndView("redirect:/login", model);
    }
}
