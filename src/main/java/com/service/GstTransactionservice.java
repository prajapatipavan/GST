package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.Entity.GstTransaction;

import com.Repositry.GstTransactionReositry;
import com.factory.RepositoryFactory;

@Service
public class GstTransactionservice {
	
	@Autowired
	RepositoryFactory factoryrepo;

	public GstTransaction createtransaction(GstTransaction transaction) {

		return factoryrepo.getGstTransaction().save(transaction);
	}

	public List<GstTransaction> ListTransaction() {

		return factoryrepo.getGstTransaction().findByUserActiveTrue();
	}
	
	
	public List<GstTransaction> ListdisactiveTransaction() {

		return factoryrepo.getGstTransaction().findAll();
	}

	public GstTransaction deleteTransaction(Integer transactionId) {

		GstTransaction trasaction = factoryrepo.getGstTransaction().findById(transactionId).orElse(null);

		return trasaction;
	}

	public void savedeletetransacion(GstTransaction gsttransaction) {

		factoryrepo.getGstTransaction().save(gsttransaction);
	}
	
	public List<GstTransaction> listfilterTransaction(Integer userId) {
	    return  factoryrepo.getGstTransaction().findByUser_UserId(userId);
	}
	
	public GstTransaction  deleteTransactions(Integer transactionId) {
		
		       GstTransaction gst = new GstTransaction();
		
		             GstTransaction transaction  = factoryrepo.getGstTransaction().findById(transactionId).get();
		             
		                if (transaction!=null) {
		                	
		                	transaction.setActive(false);
		                	factoryrepo.getGstTransaction().save(gst);
							
						}
		             
		             return transaction;
		
	}


}
