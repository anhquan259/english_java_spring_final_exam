package WebThiTA.controller;

import WebThiTA.model.User;
import WebThiTA.reponsitory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

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

    @GetMapping("")
    public ModelAndView profileGet(ModelMap model, HttpServletRequest request) {
        //auth
        HttpSession ss = request.getSession();
        String username = (String) ss.getAttribute("username");
        if (username == null)
            return new ModelAndView("redirect:/login", model);
        // get profile
        List<User> list = userRepo.findAll();
        User user = null;
        for (User i : list) {
            if (i.getUsername().equals(username)) {
                user = i;
            }
        }
        model.addAttribute("user", user);
        return new ModelAndView("profile", model);
    }

    @RequestMapping("/edit")
    public ModelAndView profilePost(ModelMap model, HttpServletRequest request) {
        HttpSession ss = request.getSession();
        String username = (String) ss.getAttribute("username");
        if (username == null)
            return new ModelAndView("redirect:/login", model);
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        String newPass = request.getParameter("newpass");
        String Repass = request.getParameter("repass");
        // get profile
        List<User> list = userRepo.findAll();
        User user = null;
        for (User i : list) {
            if (i.getUsername().equals(username)) {
                user = i;
            }
        }
        if (user.getPassword().equals(getSHAHash(password)) && Repass.equals(newPass)) {
            user.setPassword(getSHAHash(newPass));
            user.setFullname(fullname);
        }
        userRepo.save(user);
        model.addAttribute("user", user);
        return new ModelAndView("profile", model);
    }
}
