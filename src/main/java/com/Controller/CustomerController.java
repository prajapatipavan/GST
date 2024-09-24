package com.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.CustomerEntity;
import com.Entity.UserEntity;
import com.dto.Userdto;
import com.factory.ServiceFactory;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
	
	  @Autowired
	  ServiceFactory servicefactory;
	
	      @GetMapping("listcustomer")
	      public String listCustomer(HttpSession session,Model model) {
	    	  
	    	          Userdto  logginuser =(Userdto) session.getAttribute("logginuser");
	    	          
	    	          UserEntity userdtoToUserEntity = servicefactory.getUserservice().userdtoToUserEntity(logginuser);
	    	  
	    	       List<CustomerEntity> listcustomers = servicefactory.getCustomerservice().listcustomer(userdtoToUserEntity.getUserId());
	    	       model.addAttribute("listcustomers", listcustomers);
	    	         
	    	         return "listcustomer";
	    	  
	      }
	      
	      
	      @GetMapping("customertrasaction")
	      public String customertrasaction(@RequestParam("email") String email,Model model,HttpSession session) {
	    	  
	    	             List<CustomerEntity> customerIdbasetransaction = servicefactory.getCustomerservice().customerIdbasetransaction(email);
	    	              model.addAttribute("customertransaction", customerIdbasetransaction);
	    	              
	    	            
	    	              
	    	              List<CustomerEntity> customers = servicefactory.getCustomerservice().customer(email);

	    	              if (!customers.isEmpty()) {
	    	                  CustomerEntity customer = customers.get(0); // Assuming the first customer is valid
	    	                  model.addAttribute("customer", customer);
	    	              }
	    	           
	    	             
	    	              
	   	    	       
	    	              
	    	              Date aa = new Date();
	    	              SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    	              String formattedDate = dateFormat.format(aa);
	    	              
	    	                String replace = formattedDate.replace("-", "");
	    	                
	    	              
	    	              
	    	                   int random = (int) (Math.random()*10);
	    	                   
	    	                   String invoice = "inv"+replace+random;
	    	                   System.out.println(invoice);
	    	                   
	    	                   model.addAttribute("invoiceNumber", invoice);
	    	                   model.addAttribute("invoicedate", formattedDate);
	    	              
	    	  
	    	  return "viewcustomertransaction";
	      }

}
