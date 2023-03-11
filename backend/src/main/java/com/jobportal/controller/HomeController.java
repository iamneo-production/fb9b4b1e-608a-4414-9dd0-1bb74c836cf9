package com.jobportal.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String Home(){
		return "index";
	}
	
	@GetMapping("/login.htm")
	public ModelAndView Login(){
		return new ModelAndView("login");
	}
	
	@GetMapping("/signup.htm")
	public ModelAndView Signup(){
		return new ModelAndView("register");
	}
	

}

