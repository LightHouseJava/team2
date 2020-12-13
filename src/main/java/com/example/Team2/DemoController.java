package com.example.Team2;

import java.security.PublicKey;
import java.util.HashMap;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	HashMap<String, String> db = new HashMap<String, String>();

	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmission(@RequestParam("UserName") String username, @RequestParam("password") String password){
		if (db.containsKey(username)) {
			if (db.get(username).equals(password)) {
				return "home_T2";
			} else {
				return "failed_page";
			}
		} else {
			return "failed_page";
		}

	}

	@RequestMapping("/sign_up")
	public String signup(){
		return"sign_up";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String signSubmission(@RequestParam("Account Number") String userName,@RequestParam("PassWord") String password) {
		db.put(userName, password);
		return "login";
	}
}