package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.GstTransaction;
import com.factory.ServiceFactory;
import com.service.GstTransactionservice;

@Controller
public class aboutcontroller {
	
    
	 @Autowired
	 ServiceFactory servicefactory;
	
	@GetMapping("about")
	public String about() {
		
		return "about";
	}
	
	
	
	@GetMapping("disactivatetransactionlist")
	public String disactivatetransactionlist(Model model) {
		
        List<GstTransaction>	gstdisactiveTransaction	 =servicefactory.getGsttransactionservice().ListdisactiveTransaction();
		model.addAttribute("distransaction", gstdisactiveTransaction);                 
		
		return "disactivatelist/disactivatetransactionlist";
	}
	
	@GetMapping("activatetransation")
	public String activatetransation(@RequestParam("transactionId") Integer transactionId, Model model) {
		
		GstTransaction gsttransaction = servicefactory.getGsttransactionservice().deleteTransaction(transactionId);

		if (gsttransaction != null) {

			gsttransaction.setActive(true);
			servicefactory.getGsttransactionservice().savedeletetransacion(gsttransaction);

		}
		
		return "redirect:/disactivatetransactionlist";
	}
	
	
	@GetMapping("disactivateuserlist")
	public String disactivateuserlist(Model model) {
		
        List<GstTransaction>	gstdisactiveTransaction	 = servicefactory.getGsttransactionservice().ListdisactiveTransaction();
		model.addAttribute("distransaction", gstdisactiveTransaction);                 
		
		return "disactivatelist/disactivatetransactionlist";
	}
	
}
