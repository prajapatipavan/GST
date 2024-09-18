package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Entity.GstRateEntity;
import com.Entity.GstTransaction;
import com.service.GstRateService;

import jakarta.servlet.http.HttpSession;

@Controller
public class GstRateController {
	
	@Autowired
	GstRateService gstrateservice;
	
	@GetMapping("addgstrate")
	public String Addgstrate() {
		
		return "AddGstRate";
	}

	@PostMapping("createGSTRate")
	public String createGSTrate(GstRateEntity gstrate) {
		
		gstrateservice.addrate(gstrate);
		
		return "redirect:/addgstrate";
	}
	
	
	@GetMapping("listrate")
	public String listgstrate(Model model) {
	 List<GstRateEntity> gstrate= gstrateservice.Listgstrate();
	  model.addAttribute("gstrate",gstrate);
		return "ListRate";
	}
	
	
	@GetMapping("deleterates")
	public String deleteRates(@RequestParam("rateId") Integer rateId, HttpSession session,
	        RedirectAttributes redirectAttributes) {

	    GstRateEntity gstrateentity = gstrateservice.getGstRateById(rateId);

	    if (gstrateentity != null) {
	        gstrateentity.setActive(false);
	        gstrateservice.saveGstRate(gstrateentity);
	    }

	    return "redirect:/listrate";
	}

}
