package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Entity.GstCategoryEntity;
import com.Entity.GstInvoicEntity;
import com.service.GstInvoicesrvice;

@Controller
public class GstInvoicecontroller{
	
	@Autowired
	GstInvoicesrvice gstinvoiceservice;
	
	@GetMapping("addgstinvoice")
	public String Addgstrate() {
		
		return "AddGstRate";
	}

	
	@PostMapping("createInvoice")
	public String createGSTinvoice(GstInvoicEntity invoice) {
		
		gstinvoiceservice.addinvoice(invoice);
		
		return "redirect:/addgstinvoice";
	}
}
