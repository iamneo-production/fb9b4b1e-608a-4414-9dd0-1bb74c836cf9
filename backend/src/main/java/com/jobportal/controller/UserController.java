package com.jobportal.controller;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jobportal.DAO.UserDAO;
import com.jobportal.pojo.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	@Autowired
	UserDAO userdao;
	
	@PostMapping("/register.htm")
	public String Signup(HttpServletRequest request,  @ModelAttribute("user") User user, BindingResult result) throws Exception {

		//userdao= new UserDAO();
		user.setEmail(request.getParameter("email"));
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("pwd"));
		userdao.register(user);

		return "login";
	}
	@PostMapping("/login.htm")
	public String LogIn(HttpServletRequest request,  @ModelAttribute("user") User user, BindingResult result) throws Exception {
		HttpSession session = request.getSession();
		//userdao= new UserDAO();
		user.setEmail(request.getParameter("userName"));
		User u=userdao.getUserByName(request.getParameter("userName"));
		if(u==null || u.getEmail().trim().length()==0 || u.getPassword().trim().length()==0||
			request.getParameter("password").trim().length()==0||request.getParameter("userName").trim().length()==0 ||
					!u.getPassword().equals(request.getParameter("password"))
				)
		{
			return "errorLogin";
		}
		if(u.getPassword().equals(request.getParameter("password"))) {
			session.setAttribute("user", u);
			return "home";
		}


		return "login";
	}
	
	@RequestMapping("/logout.htm")
	public String LogOut(HttpServletRequest request,  @ModelAttribute("user") User user, BindingResult result) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}
	
	
}
