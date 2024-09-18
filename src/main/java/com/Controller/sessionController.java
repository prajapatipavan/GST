package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Entity.GstTransaction;
import com.Entity.UserEntity;
import com.service.Userservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class sessionController {

	@Autowired
	Userservice userservice;
	
	@Autowired
	BCryptPasswordEncoder passencode;

	@GetMapping("login")
	public String login() {

		return "login";
	}

	@PostMapping("Authenticate")
	public String Authenticate(HttpSession session, UserEntity user,HttpServletResponse response) {
		

		UserEntity loggeduser = userservice.findUserByEmail(user.getEmail());
		 
	     Boolean passwordlogg = passencode.matches(user.getPassword(),loggeduser.getPassword());    
	
	               
		session.setAttribute("logginuser", loggeduser);
		 session.setAttribute("userRole", loggeduser.getRole().getRoleName());

		

		if (loggeduser == null || passwordlogg==false || loggeduser.getActive()==false) {

			return "login";

		} else if (loggeduser.getRole().getRoleId() == 1) {
			session.setAttribute("logginuser", loggeduser);
		
			 return "Admin";

		} else if (loggeduser.getRole().getRoleId() == 2) {
			session.setAttribute("logginuser", loggeduser);
			return "Office";
		}

		else {

			return "login";
		}

	}
	
	
	@GetMapping("admindashbord")
	public String admindashbord() {
		
		return "Admin";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session,HttpServletResponse response) {
		
		 session.invalidate();
		
		
		return "redirect:/login";
	}

}
