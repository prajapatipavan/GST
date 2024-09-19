package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.Entity.GstInvoicEntity;
import com.factory.ServiceFactory;


@Controller
public class GstInvoicecontroller{
	
	 @Autowired
	 ServiceFactory servicefactory;
	
	@GetMapping("addgstinvoice")
	public String Addgstrate() {
		
		return "AddGstRate";
	}

	
	@PostMapping("createInvoice")
	public String createGSTinvoice(GstInvoicEntity invoice) {
		
		servicefactory.getGstinvoiceservice().addinvoice(invoice);
		
		return "redirect:/addgstinvoice";
	}
}
