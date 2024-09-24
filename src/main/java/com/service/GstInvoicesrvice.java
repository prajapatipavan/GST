package com.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.GstInvoicEntity;
import com.Entity.GstTransaction;
import com.Entity.UserEntity;
import com.Repositry.GstInvoiceRepositry;
import com.dto.GstInvoicdto;
import com.dto.GstTransactiondto;
import com.dto.Userdto;
import com.factory.RepositoryFactory;

@Service
public class GstInvoicesrvice {
	
	@Autowired
	RepositoryFactory factoryrepo;
	
  public GstInvoicEntity addinvoice(GstInvoicdto invoice) {
		
	        GstInvoicEntity gstInvoic =invoiceDtoToInvoiceEntity(invoice);
	                    
	      
		return factoryrepo.getGstinvoicerepo().save(gstInvoic);
	}
  
  
	
	  public Userdto userDeatails(@RequestParam("userId") Integer userId) {
	  
	  UserEntity user = factoryrepo.getUserRepo().findById(userId).get();
	  
	  return userToUserdto(user);
	  
	  }
	  
	
	  public List<GstTransactiondto> transactionDetails(@RequestParam("transactionId") Integer transactionId) {
		    

		    List<GstTransaction> transactions = factoryrepo.getGstTransaction().findByUser_UserId(transactionId);
		    
		
		    List<GstTransactiondto> transactionDtos = transactions.stream()
		                                                          .map(this::TransactionToTransactiondto) // Assuming this method does the conversion
		                                                          .collect(Collectors.toList());
		    
		   
		    return transactionDtos;
		}

	  
	  public List<GstInvoicdto> listInvoice(){
		  
		   List<GstInvoicEntity> gstInvoice = factoryrepo.getGstinvoicerepo().findAll();
		   
		           List<GstInvoicdto> collect = gstInvoice.stream().map(this::invoiceEntityToGstInvoicdto).collect(Collectors.toList());
		           
		   
		   return collect;
	  }
	 
	  
	
	  
	  
	  
	public GstInvoicEntity invoiceDtoToInvoiceEntity(GstInvoicdto gstinvoicedto) {
		
		  return  this.factoryrepo.getModelmapper().map(gstinvoicedto,GstInvoicEntity.class);
		
	}  
	
	public GstInvoicdto invoiceEntityToGstInvoicdto(GstInvoicEntity gstinvoiceentity) {
		
		  return  this.factoryrepo.getModelmapper().map(gstinvoiceentity,GstInvoicdto.class);
		
	}  
	  
  
  public UserEntity userdtoToUserEntity(Userdto userdto) {
      return this.factoryrepo.getModelmapper().map(userdto, UserEntity.class);
  }

  public Userdto userToUserdto(UserEntity userEntity) {
      return this.factoryrepo.getModelmapper().map(userEntity, Userdto.class);
  }
  
  public GstTransactiondto TransactionToTransactiondto(GstTransaction gsttransaction) {

		GstTransactiondto gsttransactiondto = factoryrepo.getModelmapper().map(gsttransaction, GstTransactiondto.class);

		return gsttransactiondto;

	}
  
  public GstTransaction TransactionDtoToTransactionEntity(GstTransactiondto gsttransactiondto) {

		GstTransaction gsttransaction = factoryrepo.getModelmapper().map(gsttransactiondto, GstTransaction.class);

		return gsttransaction;
	}





}
