package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.Entity.GstInvoicEntity;
import com.dto.Userdto;
import com.factory.ServiceFactory;


@Controller
public class GstInvoicecontroller{
	
	 @Autowired
	 ServiceFactory servicefactory;
	
	@GetMapping("addgstinvoice")
	public String Addgstrate(Integer userId,Model model) {
		
		    Userdto user  = servicefactory.getGstinvoiceservice().userDeatails(userId);
		    model.addAttribute("userd",user);
		
		return "AddgstInvoice";
	}

	
	@PostMapping("createInvoice")
	public String createGSTinvoice(GstInvoicEntity invoice) {
		
		servicefactory.getGstinvoiceservice().addinvoice(invoice);
		
		return "redirect:/addgstinvoice";
	}
	
	
	
}
