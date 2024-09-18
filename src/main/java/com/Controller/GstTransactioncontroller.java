package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Entity.GstCategoryEntity;
import com.Entity.GstRateEntity;
import com.Entity.GstTransaction;
import com.Entity.UserEntity;
import com.Repositry.GstTransactionReositry;
import com.Repositry.UserRepositry;
import com.service.GstCategoryService;
import com.service.GstRateService;
import com.service.GstTransactionservice;
import com.service.Userservice;

import jakarta.servlet.http.HttpSession;

@Controller
public class GstTransactioncontroller {

	@Autowired
	GstTransactionservice gsttransactions;
	@Autowired
	GstTransactionReositry gstTransactionRepo;

	@Autowired
	GstRateService gstrate;

	@Autowired
	GstCategoryService gstcatagory;
	
	@Autowired
	Userservice userservice;


	@Autowired
	UserRepositry userrepo;

	@GetMapping("/addgstTransaction")
	public String addGstTransaction(Model model, HttpSession session) {

		List<GstRateEntity> gstrates = gstrate.Listgstrate();
		model.addAttribute("gstrates", gstrates);

		List<GstCategoryEntity> gstCategories = gstcatagory.Listcategory();
		model.addAttribute("gstCategories", gstCategories);

		UserEntity user = (UserEntity) session.getAttribute("logginuser");

		if (user != null) {

			List<UserEntity> puser = (List<UserEntity>) userrepo.findByuserId(user.getUserId());
			model.addAttribute("puser", puser);
		} else {

			return "redirect:/login";
		}

		return "AddGstTransaction";
	}

	@PostMapping("createTransaction")
	public String createGSTtransaction(GstTransaction gsttransaction, HttpSession session) {

		gsttransactions.createtransaction(gsttransaction);

		return "redirect:/addgstTransaction";
	}

	@GetMapping("listTransaction")
	public String listTransaction(Model model) {
		
		List<UserEntity> puser = userservice.Listuser();
		model.addAttribute("puser", puser);
		
		
		List<GstTransaction> gsttansaction = gsttransactions.ListTransaction();
		
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

		List<GstTransaction> transactions = gstTransactionRepo.findByUser(loggedInUser);

		model.addAttribute("gstTransactionList", transactions);
		return "ListTransactionLoginuser";
	}

	@GetMapping("deletetransaction")
	public String deletetransaction(@RequestParam("transactionId") Integer transactionId, HttpSession session,
			RedirectAttributes redirectAttributes) {

		GstTransaction gsttransaction = gsttransactions.deleteTransaction(transactionId);

		if (gsttransaction != null) {

			gsttransaction.setActive(false);
			gsttransactions.savedeletetransacion(gsttransaction);

		}

		return "redirect:/listTransaction";
	}
	
	
	@GetMapping("viewtransaction")
	public String viewtransaction(@RequestParam("userId") Integer userId,Model model) {
		
	             List<GstTransaction> gstfiltertransaction    =	gsttransactions.listfilterTransaction(userId); 
	             model.addAttribute("gstfiltertransaction", gstfiltertransaction);
	             model.addAttribute("selectedUserId", userId);
	             
	               UserEntity puser =  (UserEntity) userrepo.findById(userId).get();
	 			   model.addAttribute("puser", puser);                                       
	             
	 			   
	 			  double totalAmount = gstfiltertransaction.stream()
	 				        .mapToDouble(transaction -> {
	 				         
	 				                return Double.parseDouble(transaction.getTotalAmount());
	 				           
	 				        })
	 				        .sum();
	 			  
	 			 String formattedTotalAmount = String.format("%.2f", totalAmount);
	 			
	 			model.addAttribute("totalAmount", formattedTotalAmount);
		
		return "viewtransaction";
	}

}
