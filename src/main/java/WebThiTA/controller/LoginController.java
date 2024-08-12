package WebThiTA.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import WebThiTA.model.User;
import WebThiTA.reponsitory.UserRepo;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserRepo userRepo;
	@RequestMapping("")
    public ModelAndView loginGet(ModelMap model, HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("username")!=null)
			return new ModelAndView( "redirect:/", model);
		return new ModelAndView( "login", model);
	}
	@PostMapping("/authen")
	public ModelAndView loginPost(ModelMap model, HttpServletRequest request) {
		String email=request.getParameter("email");
		String password=getSHAHash(request.getParameter("password"));
		List<User> users=userRepo.findAll();
		for(User i:users) {
            if(i.getUsername().equals(email)&&i.getPassword().equals(password)) {
                HttpSession ss= request.getSession();
                ss.setAttribute("username", email);
                return new ModelAndView( "redirect:/", model);
            }
        }
        model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
        return new ModelAndView( "redirect:/login", model);
	}
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
}
