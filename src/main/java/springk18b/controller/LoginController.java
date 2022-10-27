package springk18b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import springk18b.model.Login;

@Controller
public class LoginController {

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@ModelAttribute("login")
	public Login setLogin() {
		return new Login();
	}
	/**
	 * Save User login form
	 * 
	 * @param login
	 * @param model
	 * @return
	 */
	@GetMapping("/showLogin")
	public String showForm() {
		return "login";
	}

	@PostMapping("/saveLogin")
	public  ModelAndView saveUser(@ModelAttribute("login") Login login, Model model) {
		 
		ModelAndView modelAndView = new ModelAndView();
		if (login.getUsername().equals("admin") && login.getPassword().equals("admin")) {
			modelAndView.setViewName("login-success");
			modelAndView.addObject("message", "Login success!!!");
			modelAndView.addObject("user", login);
			
		} else {
			modelAndView.setViewName("login");
			modelAndView.addObject("message", "Login fail!!");
		}
		return  modelAndView;
	}
}
