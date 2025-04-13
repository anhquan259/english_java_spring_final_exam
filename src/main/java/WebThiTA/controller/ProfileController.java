package WebThiTA.controller;

import WebThiTA.dto.UserDTO;
import WebThiTA.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private UserService userService;

    @Transactional
    @GetMapping("")
    public ModelAndView profileGet(ModelMap model, HttpServletRequest request) {
        //auth
        HttpSession ss = request.getSession();
        String username = (String) ss.getAttribute("username");

        if (username == null)
            return new ModelAndView("redirect:/login", model);

        // get user profile
        UserDTO user = userService.getUserProfile(username);
        if (user == null) {
            return new ModelAndView("redirect:/login", model);
        }

        model.addAttribute("user", user);
        return new ModelAndView("profile", model);
    }

    @Transactional
    @PostMapping("/edit")
    public ModelAndView profilePost(ModelMap model, HttpServletRequest request) {
        HttpSession ss = request.getSession();
        String username = (String) ss.getAttribute("username");

        if (username == null) {
            model.addAttribute("message", "Vui lòng đăng nhập lại!");
            return new ModelAndView("redirect:/login", model);
        }

        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        String newPass = request.getParameter("newpass");
        String rePass = request.getParameter("repass");

        logger.info("Starting update User profile");
        String message = userService.updateUserProfile(username, fullname, password, newPass, rePass);

        model.addAttribute("message", message);
        return new ModelAndView("profile", model);
    }
}
