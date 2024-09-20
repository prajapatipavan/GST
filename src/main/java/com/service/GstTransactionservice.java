package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;
import com.Entity.GstTransaction;
import com.Repositry.GstTransactionReositry;
import com.dto.GstTransactiondto;
import com.factory.RepositoryFactory;

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

	public List<GstTransactiondto> ListTransaction() {
		GstTransactionReositry gsttransactionrepo = factoryrepo.getGstTransaction();
		List<GstTransaction> gstTransaction = gsttransactionrepo.findByUserActiveTrue();

		return gstTransaction.stream().map(this::TransactionToTransactiondto).collect(Collectors.toList());

	}

	public List<GstTransactiondto> listdisactiveTransaction() {
		GstTransactionReositry gsttransactionrepo = factoryrepo.getGstTransaction();
		List<GstTransaction> gstTransaction =gsttransactionrepo.findAll();

		return  gstTransaction.stream().map(this::TransactionToTransactiondto).collect(Collectors.toList());
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
		List<GstTransaction>  gstTransaction = gsttransactionrepo.findByUser_UserId(userId);
		
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
	
	
	/*
	 * public GstTransactiondto findGstTransactionBytrasactionId() {
	 * 
	 * GstTransaction gsttransaction =
	 * factoryrepo.getGstTransaction().findGstTransactionBytrasactionId();
	 * 
	 * return TransactionToTransactiondto(gsttransaction); }
	 */

	public GstTransaction TransactionDtoToTransactionEntity(GstTransactiondto gsttransactiondto) {

		GstTransaction gsttransaction = factoryrepo.getModelmapper().map(gsttransactiondto, GstTransaction.class);

		return gsttransaction;
	}

	public GstTransactiondto TransactionToTransactiondto(GstTransaction gsttransaction) {

		GstTransactiondto gsttransactiondto = factoryrepo.getModelmapper().map(gsttransaction, GstTransactiondto.class);

		return gsttransactiondto;

	}



}
