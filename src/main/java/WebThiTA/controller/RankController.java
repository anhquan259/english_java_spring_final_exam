package WebThiTA.controller;

import WebThiTA.model.User;
import WebThiTA.reponsitory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;

@Controller
@RequestMapping("/rank")
public class RankController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping("")
    public ModelAndView rankGet(ModelMap model, HttpServletRequest request) {
        //auth
        HttpSession ss = request.getSession();
        String username = (String) ss.getAttribute("username");
        if (username == null)
            return new ModelAndView("redirect:/login", model);
        // get list user with role = 1
        ArrayList<User> list = (ArrayList<User>) userRepo.findAllWithRole1Sorted();

        ArrayList<Long> rank = new ArrayList<>();

        Long r = (long) 0;
        for (User i : list) {
            rank.add(r++);
        }

        model.addAttribute("list", list);
        model.addAttribute("rank", rank);
        return new ModelAndView("rank", model);
    }
}
