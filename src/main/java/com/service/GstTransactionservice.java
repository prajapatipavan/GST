package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.CustomerEntity;
import com.Entity.GstTransaction;
import com.Entity.UserEntity;
import com.Repositry.CustomerRepositry;
import com.Repositry.GstTransactionReositry;
import com.dto.Customerdto;
import com.dto.GstTransactiondto;
import com.dto.Userdto;
import com.factory.RepositoryFactory;

import jakarta.servlet.http.HttpSession;

@Service
public class GstTransactionservice {

	@Autowired
	RepositoryFactory factoryrepo;

	public GstTransactiondto createTransaction(GstTransactiondto transaction) {
		
		               
		GstTransaction gstTransaction = TransactionDtoToTransactionEntity(transaction);
		
		 
		
		
		GstTransactionReositry gsttransactionrepo = factoryrepo.getGstTransaction();
		GstTransaction savetransaction = gsttransactionrepo.save(gstTransaction);

		return TransactionToTransactiondto(savetransaction);
	}
	
	
	public Customerdto  savecustomer(Customerdto customer) {
		
		    CustomerEntity customerentity  = customerdtoTOCustomerEntity(customer);
		    
		 CustomerRepositry  customerRepositry   = factoryrepo.getCustomerRepositry();
		 
		    CustomerEntity save = customerRepositry.save(customerentity);
		        
		   return customerentityTOCustomerdto(save);
		
	}
	

	public List<GstTransactiondto> ListTransaction() {
		GstTransactionReositry gsttransactionrepo = factoryrepo.getGstTransaction();
		List<GstTransaction> gstTransaction = gsttransactionrepo.findByUserActiveTrue();

		return gstTransaction.stream().map(this::TransactionToTransactiondto).collect(Collectors.toList());

	}

	public List<GstTransactiondto> listdisactiveTransaction() {
		GstTransactionReositry gsttransactionrepo = factoryrepo.getGstTransaction();
		List<GstTransaction> gstTransaction = gsttransactionrepo.findAll();

		return gstTransaction.stream().map(this::TransactionToTransactiondto).collect(Collectors.toList());
	}

	public GstTransactiondto deleteTransaction(Integer transactionId) {
		GstTransactionReositry gsttransactionrepo = factoryrepo.getGstTransaction();
		GstTransaction trasaction = gsttransactionrepo.findById(transactionId).orElse(null);

		return TransactionToTransactiondto(trasaction);
	}

	public void saveDeleteTransacion(GstTransactiondto gsttransaction) {
		GstTransactionReositry gsttransactionrepo = factoryrepo.getGstTransaction();
		GstTransaction gstTransaction = TransactionDtoToTransactionEntity(gsttransaction);

		gsttransactionrepo.save(gstTransaction);
	}

	public List<GstTransactiondto> listFilterTransaction(Integer userId) {
		GstTransactionReositry gsttransactionrepo = factoryrepo.getGstTransaction();
		List<GstTransaction> gstTransaction = gsttransactionrepo.findByUser_UserId(userId);

		return gstTransaction.stream().map(this::TransactionToTransactiondto).collect(Collectors.toList());
	}

	public GstTransactiondto deleteTransactions(Integer transactionId) {

		GstTransaction gst = new GstTransaction();

		GstTransaction transaction = factoryrepo.getGstTransaction().findById(transactionId).get();

		if (transaction != null) {

			transaction.setActive(false);
			factoryrepo.getGstTransaction().save(gst);

		}

		return TransactionToTransactiondto(transaction);

	}

	
	
	 

	public GstTransaction TransactionDtoToTransactionEntity(GstTransactiondto gsttransactiondto) {

		GstTransaction gsttransaction = factoryrepo.getModelmapper().map(gsttransactiondto, GstTransaction.class);

		return gsttransaction;
	}

	public GstTransactiondto TransactionToTransactiondto(GstTransaction gsttransaction) {

		GstTransactiondto gsttransactiondto = factoryrepo.getModelmapper().map(gsttransaction, GstTransactiondto.class);

		return gsttransactiondto;

	}
	
	
	             public  CustomerEntity customerdtoTOCustomerEntity (Customerdto customerdto) {
	
		           CustomerEntity map = factoryrepo.getModelmapper().map(customerdto,CustomerEntity.class);	
		           
		           return map;
	}
	                 
	                 

	               public  Customerdto customerentityTOCustomerdto (CustomerEntity customer) {
	
		           Customerdto map = factoryrepo.getModelmapper().map(customer,Customerdto.class);	
		           
		           return map;
	}


	               public CustomerEntity updateCustomer(CustomerEntity customer) {
	            	    return factoryrepo.getCustomerRepositry().save(customer);
	            	}

	               public GstTransaction saveTransaction(GstTransaction transaction) {
	            	    return factoryrepo.getGstTransaction().save(transaction);
	            	}
	               
	               public CustomerEntity saveCustomerEntity(CustomerEntity customerEntity) {
	                
	                   return factoryrepo.getCustomerRepositry().save(customerEntity);
	               }

	               public CustomerEntity findCustomerByEmail(String email) {
	            	    List<CustomerEntity> customers = factoryrepo.getCustomerRepositry().findByEmail(email);
	            	    return customers.isEmpty() ? null : customers.get(0); // Return the first one or null if not found
	            	}


	               public List<GstTransaction> findTransactionsByCustomer(CustomerEntity customer) {
	                   return factoryrepo.getGstTransaction().findByCustomer(customer);
	               }

	

}
