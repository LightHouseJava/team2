package com.example.Team2;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView; 

@Controller
public class DemoController {
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView checkLogin(@RequestParam("username") String username, @RequestParam("password") String password, @ModelAttribute User user) {
		ModelAndView mav = new ModelAndView();
		if (username.equals("admin") && password.equals("123456")) {
		    mav.setViewName("home");
		    mav.addObject("user123", user);
		}else {
			mav.addObject("errorMessage", "Wrong username or password");
			mav.setViewName("failed_page");
		}
		
		return mav;
		
	}}