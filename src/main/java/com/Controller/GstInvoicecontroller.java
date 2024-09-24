package com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.GstInvoicEntity;
import com.Entity.GstTransaction;
import com.dto.GstInvoicdto;
import com.dto.GstTransactiondto;
import com.dto.Userdto;
import com.factory.RepositoryFactory;
import com.factory.ServiceFactory;

import jakarta.servlet.http.HttpSession;


@Controller
public class GstInvoicecontroller{
	
	 @Autowired
	 ServiceFactory servicefactory;
	 
	 @Autowired
	 RepositoryFactory repositoryFactory;
	
	@GetMapping("addgstinvoice")
	public String Addgstrate(Integer userId,Model model,Integer transactionId,HttpSession session,Userdto userdto) {
		
		  Userdto user = servicefactory.getGstinvoiceservice().userDeatails(userId);
		  
		  model.addAttribute("userd",user);
		
		 
		 
		  
		 List<Userdto>  userlogin = servicefactory.getUserservice().listuserlogin(userdto);
		 
		 model.addAttribute("userlogin",userlogin);
		 
		 Userdto loggedInUser = (Userdto) session.getAttribute("logginuser");
			if (loggedInUser == null) {
				return "redirect:/login";
			}

			List<GstTransactiondto> transactions = servicefactory.getUserservice().listTransactionLoginUser(loggedInUser);

			
			model.addAttribute("gstTransactionList", transactions);

			
			    System.out.println(transactions.get(0).getTotalAmount());
	
			
			double totalAmount = transactions.stream()
				    .mapToDouble(transaction -> {
				        try {
				            return Double.parseDouble(transaction.getTotalAmount()); 
				        } catch (NumberFormatException e) {
				           
				            return 0.0; 
				        }
				    })
				    .sum();
			
			
			model.addAttribute("totalAmount",totalAmount );
			
			return "AddgstInvoice";

	}
	@PostMapping("createInvoice")
	public String createGSTinvoice(@ModelAttribute GstInvoicdto invoiceDto, HttpSession session,GstInvoicEntity invoice) {
	    // Create a new GstInvoice entity
	   
                  
	 

	    // Save the invoice using the service layer
	    servicefactory.getGstinvoiceservice().addinvoice(invoiceDto);

	    // Get the logged-in user from the session
	    Userdto loggedInUser = (Userdto) session.getAttribute("logginuser");

	    // Redirect to the invoice page
	    return "redirect:/addgstinvoice?userId=" + loggedInUser.getUserId();
	}

	
   @GetMapping("listinvoice")
   public String listinvoice(Model model) {
	   
	      List<GstInvoicdto> invoice  =servicefactory.getGstinvoiceservice().listInvoice();
	      model.addAttribute("listinvoice", invoice);
	   
	   return "ListInvoice";
	   
   }
	
	
	
}
