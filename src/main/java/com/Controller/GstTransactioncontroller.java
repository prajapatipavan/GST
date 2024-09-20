package com.Controller;

import java.util.List;
import com.factory.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Entity.GstCategoryEntity;

import com.Entity.GstTransaction;
import com.Entity.UserEntity;
import com.dto.GstCategorydto;
import com.dto.GstRatedto;
import com.dto.GstTransactiondto;


import jakarta.servlet.http.HttpSession;

@Controller
public class GstTransactioncontroller  {

	      
	 @Autowired
	 ServiceFactory servicefactory;

	@GetMapping("/addgstTransaction")
	public String addGstTransaction(Model model, HttpSession session) {

		List<GstRatedto> gstrates =servicefactory.getGstrate().Listgstrate();
		model.addAttribute("gstrates", gstrates);
		
	             
		List<GstCategorydto> gstCategories =servicefactory.getGstcatagory().listCategory();
		model.addAttribute("gstCategories", gstCategories);

		UserEntity user = (UserEntity) session.getAttribute("logginuser");

		if (user != null) {

			List<UserEntity> puser = (List<UserEntity>) servicefactory.getUserrepo().findByuserId(user.getUserId());
			model.addAttribute("puser", puser);
		} else {

			return "redirect:/login";
		}

		return "AddGstTransaction";
	}

	@PostMapping("createTransaction")
	public String createGSTtransaction(GstTransactiondto gsttransaction, HttpSession session) {

		servicefactory.getGsttransactions().createTransaction(gsttransaction);

		return "redirect:/addgstTransaction";
	}

	@GetMapping("listTransaction")
	public String listTransaction(Model model) {
		
		List<UserEntity> puser =servicefactory.getUserservice().Listuser();
		model.addAttribute("puser", puser);
		
		
		List<GstTransactiondto> gsttansaction =servicefactory.getGsttransactions().ListTransaction();
		
		 double totalAmount = gsttansaction.stream()
			        .mapToDouble(transaction -> {
			         
			                return Double.parseDouble(transaction.getTotalAmount());
			           
			        })
			        .sum();
		
		model.addAttribute("gsttansaction", gsttansaction);
		
		 String formattedTotalAmount = String.format("%.2f", totalAmount);
		
		model.addAttribute("totalAmount", formattedTotalAmount);
		return "ListTransaction";
	}

	@GetMapping("listTransactionLoginUser")
	public String listTransactionLoginUser(Model model, HttpSession session) {
		UserEntity loggedInUser = (UserEntity) session.getAttribute("logginuser");

		if (loggedInUser == null) {

			return "redirect:/login";
		}

		List<GstTransaction> transactions =servicefactory.getGstTransactionRepo().findByUser(loggedInUser);

		model.addAttribute("gstTransactionList", transactions);
		return "ListTransactionLoginuser";
	}

	@GetMapping("deletetransaction")
	public String deletetransaction(@RequestParam("transactionId") Integer transactionId, HttpSession session,
			RedirectAttributes redirectAttributes) {

		GstTransactiondto gsttransaction =servicefactory.getGsttransactions().deleteTransaction(transactionId);

		if (gsttransaction != null) {

			gsttransaction.setActive(false);
			servicefactory.getGsttransactions().saveDeleteTransacion(gsttransaction);

		}

		return "redirect:/listTransaction";
	}
	
	
	@GetMapping("viewtransaction")
	public String viewtransaction(@RequestParam("userId") Integer userId, Model model) {

	    
	    List<GstTransactiondto> gstFilterTransaction = servicefactory.getGsttransactions()
	            .listFilterTransaction(userId).stream().filter(GstTransactiondto::getActive).toList();
	            

	    model.addAttribute("gstfiltertransaction", gstFilterTransaction);
	    model.addAttribute("selectedUserId", userId);

	   
	    UserEntity puser = (UserEntity) servicefactory.getUserrepo().findById(userId).orElse(null);
	    model.addAttribute("puser", puser);

	  
	    double totalAmount = gstFilterTransaction.stream()
	            .mapToDouble(transaction -> Double.parseDouble(transaction.getTotalAmount()))
	            .sum();

	    String formattedTotalAmount = String.format("%.2f", totalAmount);
	    model.addAttribute("totalAmount", formattedTotalAmount);
	    
	    
	    List<UserEntity> pusers =servicefactory.getUserservice().Listuser();
		model.addAttribute("pusers", pusers);

	    
	    return "viewtransaction";
	}

	@GetMapping("deletetransactions")
	public String deletetransactions(@RequestParam("transactionId") Integer transactionId,@RequestParam("userId") Integer userId) {
		
		     servicefactory.getGsttransactionservice().deleteTransactions(transactionId);
		       
		  return "redirect:/viewtransaction?userId="+userId;
	}

}
