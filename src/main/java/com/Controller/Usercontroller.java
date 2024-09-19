package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Entity.RoleEntity;
import com.Entity.UserEntity;
import com.Repositry.RoleRepositry;
import com.factory.ServiceFactory;
import com.service.Mailservice;
import com.service.RoleServie;
import com.service.Userservice;

import jakarta.servlet.http.HttpSession;

@Controller
public class Usercontroller {
	
	 @Autowired
	 ServiceFactory servicefactory;
	
	@Autowired
	Mailservice mailservice;
	
	@GetMapping("Adduser")
	public String createUser(Model model) {
		
		
		 List<RoleEntity> listrole =servicefactory.getRoleservice().listofrole();
		  model.addAttribute("listrole", listrole); 
		return "user";
	}

	
	@PostMapping("saveuser")
	public String saveuser(UserEntity user,RedirectAttributes redirectAttributes,RoleEntity role) {
		
	redirectAttributes.addFlashAttribute("addusermsg", "User Add Sucessfully!!!");
	
	 String plaintext =user.getPassword();
     String encodepass =servicefactory.getPassencode().encode(plaintext);
     
     user.setPassword(encodepass);
     
		/* mailservice.sendmessagemail(user.getEmail(),user.getUsername(),plaintext); */
		 
	    servicefactory.getUserservice().saveuser(user);
		
		return "redirect:/Adduser";
	}
	
	@GetMapping("listuser")
	public String listuser(Model model,UserEntity user,HttpSession session) {
		 UserEntity loggeduser = (UserEntity) session.getAttribute("logginuser");
		
		   List<UserEntity> listuser =servicefactory.getUserservice().listUsers(loggeduser);
		   model.addAttribute("listuser",listuser);
		
		return "Listuser";
	}
	
	@GetMapping("deleteuser")
	public String deleteuser(@RequestParam("userId") Integer userId, HttpSession session, RedirectAttributes redirectAttributes) {
	    
	    System.out.println(userId);
	    
	    
	    UserEntity loggeduser = (UserEntity) session.getAttribute("logginuser");

	    System.out.println(loggeduser.getUserId());
	    
	   
	    if (loggeduser.getUserId().equals(userId)) {
	      
	        redirectAttributes.addFlashAttribute("error", "You cannot delete yourself!");
	        return "redirect:/listuser";
	    }
	    
	    
	                  UserEntity  deleteduser =servicefactory.getUserservice().deleteuser(userId);
	                  
	                  if(deleteduser !=null) {
	                	  
	                	  
	                	       deleteduser.setActive(false);
	                	       servicefactory.getUserservice().saveuser(deleteduser);
	                  }
	    
	    return "redirect:/listuser";
	}
	
}
