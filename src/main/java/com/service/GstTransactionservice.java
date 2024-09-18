package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.Entity.GstTransaction;

import com.Repositry.GstTransactionReositry;

@Service
public class GstTransactionservice {
	
	@Autowired
	GstTransactionReositry gstTransaction;

	public GstTransaction createtransaction(GstTransaction transaction) {

		return gstTransaction.save(transaction);
	}

	public List<GstTransaction> ListTransaction() {

		return gstTransaction.findByUserActiveTrue();
	}
	
	
	public List<GstTransaction> ListdisactiveTransaction() {

		return gstTransaction.findAll();
	}

	public GstTransaction deleteTransaction(Integer transactionId) {

		GstTransaction trasaction = gstTransaction.findById(transactionId).orElse(null);

		return trasaction;
	}

	public void savedeletetransacion(GstTransaction gsttransaction) {

		gstTransaction.save(gsttransaction);
	}
	
	public List<GstTransaction> listfilterTransaction(Integer userId) {
	    return gstTransaction.findByUser_UserId(userId);
	}


}
