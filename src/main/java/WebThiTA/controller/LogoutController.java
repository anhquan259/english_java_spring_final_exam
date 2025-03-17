package WebThiTA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @RequestMapping("")
    public String logout(ModelMap model, HttpServletRequest request) {
        HttpSession ss = request.getSession();
        if (ss.getAttribute("username") == null) {
            return "redirect:/login";
        }
        ss.removeAttribute("username");
        return "redirect:/login";
    }
}
