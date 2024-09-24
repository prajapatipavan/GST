package com.Controller;

import java.util.List;
import com.factory.*;

import org.aspectj.weaver.tools.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Entity.CustomerEntity;
import com.Entity.GstCategoryEntity;

import com.Entity.GstTransaction;
import com.Entity.UserEntity;
import com.Repositry.CustomerRepositry;
import com.dto.Customerdto;
import com.dto.GstCategorydto;
import com.dto.GstRatedto;
import com.dto.GstTransactiondto;
import com.dto.Productdto;
import com.dto.Userdto;

import jakarta.servlet.http.HttpSession;

@Controller
public class GstTransactioncontroller  {

	      
	 @Autowired
	 ServiceFactory servicefactory;
	 
	

	@GetMapping("/addgstTransaction")
	public String addGstTransaction(Model model, HttpSession session) {

		List<GstRatedto> gstrates =servicefactory.getGstrate().Listgstrate();
		model.addAttribute("gstrates", gstrates);
		
		 List<Productdto> listproduct = servicefactory.getProductService().listproduct();
	        model.addAttribute("listproduct",listproduct);
	             
		List<GstCategorydto> gstCategories =servicefactory.getGstcatagory().listCategory();
		model.addAttribute("gstCategories", gstCategories);

		Userdto user = (Userdto) session.getAttribute("logginuser");

		if (user != null) {

			    List<Userdto>  puser   = servicefactory.getUserservice().listuserlogin(user);
			model.addAttribute("puser", puser);
		} else {

			return "redirect:/login";
		}

		return "AddGstTransaction";
	}

	
	@PostMapping("createTransaction")
	public String createGSTtransaction(GstTransactiondto gsttransaction, HttpSession session, Customerdto customerdto, Model model) {
	    
	    Userdto user = (Userdto) session.getAttribute("logginuser");
	    UserEntity userEntity = servicefactory.getUserservice().userdtoToUserEntity(user);
	    
	    customerdto.setUser(userEntity);
	    
	    // Find existing customer by email
	    CustomerEntity existingCustomer = servicefactory.getGsttransactionservice()
	            .findCustomerByEmail(customerdto.getEmail());
	    
	    // Initialize a new customer entity
	    CustomerEntity customerEntity;

	    if (existingCustomer != null) {
	        // Retrieve existing customer details
	        customerdto.setCustomerName(existingCustomer.getCustomerName());
	        customerdto.setContactNumber(existingCustomer.getContactNumber());
	        customerdto.setAddress(existingCustomer.getAddress());
	        customerdto.setGstNumber(existingCustomer.getGstNumber());
	        customerdto.setEmail(existingCustomer.getEmail());
	        
	        // Find all transactions for the existing customer
	        List<GstTransaction> transactions = servicefactory.getGsttransactionservice().findTransactionsByCustomer(existingCustomer);
	        
	        // Deactivate all previous transactions
	        for (GstTransaction transaction : transactions) {
	            transaction.setActive(false); // Set previous transactions to inactive
	            servicefactory.getGsttransactionservice().saveTransaction(transaction); // Save the change
	        }
	        
	        // Set the existing customer as inactive
	        existingCustomer.setActive(false);
	        customerEntity = existingCustomer; // Use the existing customer entity for the new transaction
	        gsttransaction.setCustomer(existingCustomer); // Set the customer for the new transaction
	    } else {
	        // If customer does not exist, create a new customer
	        Customerdto savedCustomer = servicefactory.getGsttransactions().savecustomer(customerdto);
	        customerEntity = servicefactory.getGsttransactionservice().customerdtoTOCustomerEntity(savedCustomer);
	        gsttransaction.setCustomer(customerEntity); // Set the customer for the new transaction
	    }

	    // Create and save the new transaction
	    GstTransactiondto transactionDto = servicefactory.getGsttransactions().createTransaction(gsttransaction);
	    GstTransaction transactionEntity = servicefactory.getGsttransactionservice().TransactionDtoToTransactionEntity(transactionDto);
	    GstTransaction savedTransaction = servicefactory.getGsttransactionservice().saveTransaction(transactionEntity);
	    
	    // Link the saved transaction to the customer entity
	    customerEntity.setTransaction(savedTransaction);
	    servicefactory.getGsttransactions().saveCustomerEntity(customerEntity); // Save the updated customer entity

	    return "redirect:/addgstTransaction"; // Redirect after successful transaction creation
	}


	@GetMapping("listTransaction")
	public String listTransaction(Model model) {
		
		List<UserEntity> puser =servicefactory.getUserservice().Listuser();
		model.addAttribute("puser", puser);
		
		
		List<GstTransactiondto> gsttansaction =servicefactory.getGsttransactions().ListTransaction();
		
		double totalAmount = gsttansaction.stream()
			    .mapToDouble(transaction -> {
			        String amountStr = transaction.getTotalAmount();
			        
			        if (amountStr == null || amountStr.trim().isEmpty()) {
			            return 0.0;
			        }
			        try {
			            return Double.parseDouble(amountStr);
			        } catch (NumberFormatException e) {
			            // Handle any unexpected format, returning 0.0 for this case
			            return 0.0;
			        }
			    })
			    .sum();
		
		model.addAttribute("gsttansaction", gsttansaction);
		
		 String formattedTotalAmount = String.format("%.2f",totalAmount);
		
		model.addAttribute("totalAmount", formattedTotalAmount);
		return "ListTransaction";
	}

	@GetMapping("listTransactionLoginUser")
	public String listTransactionLoginUser(Model model, HttpSession session) {
		Userdto loggedInUser = (Userdto) session.getAttribute("logginuser");

		if (loggedInUser == null) {

			return "redirect:/login";
		}

		    List<GstTransactiondto>  transactions  =  servicefactory.getUserservice().listTransactionLoginUser(loggedInUser); 
		
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

	  
	    double totalAmount = gstFilterTransaction .stream()
			    .mapToDouble(transaction -> {
			        String amountStr = transaction.getTotalAmount();
			        
			        if (amountStr == null || amountStr.trim().isEmpty()) {
			            return 0.0;
			        }
			        try {
			            return Double.parseDouble(amountStr);
			        } catch (NumberFormatException e) {
			            // Handle any unexpected format, returning 0.0 for this case
			            return 0.0;
			        }
			    })
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
