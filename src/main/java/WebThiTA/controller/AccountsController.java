package WebThiTA.controller;

import WebThiTA.model.User;
import WebThiTA.reponsitory.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class AccountsController {
    private final String NOT_LOGIN = "redirect:/login";
    @Autowired
    UserRepo userRepo;
    @GetMapping("")
    public String listUsers(Model model,HttpServletRequest request) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return  checkLogin(request) ?"AccountList":NOT_LOGIN; // Đường dẫn tới file Thymeleaf
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model,HttpServletRequest request) {
        model.addAttribute("user", new User());
        return checkLogin(request)?"Account":NOT_LOGIN;
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model,HttpServletRequest request) {
        Optional<User> userOptional = userRepo.findById(id);
        User user = userOptional.orElse(new User());
        model.addAttribute("user", user);
        return checkLogin(request)?"Account":NOT_LOGIN;
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id,HttpServletRequest request) {
        userRepo.deleteById(id);
        return checkLogin(request)?"redirect:/user":NOT_LOGIN;
    }
    private boolean checkLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer roleObject = (Integer) session.getAttribute("role");
        return roleObject != null && roleObject == 2;
    }
}
