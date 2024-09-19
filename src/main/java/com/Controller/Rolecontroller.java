package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Entity.RoleEntity;
import com.factory.ServiceFactory;
import com.service.RoleServie;



@Controller
public class Rolecontroller  {
	
	 @Autowired
	 ServiceFactory servicefactory;
	
	@GetMapping("/role")
	public String rolecreate(Model model) {
		
		
		  
		  
		   
		System.out.println("role jsp open");
		return "roles";
	}
	
	
	@PostMapping("saverole")
	public String saverole(RedirectAttributes redirectAttributes,RoleEntity role) {
		
		servicefactory.getRoleservice().saverole(role);  
		
		redirectAttributes.addFlashAttribute("roleaddmsg","ROLE ADD SUCESSFULLY!!");
		
		return "redirect:/role";
	}

}
