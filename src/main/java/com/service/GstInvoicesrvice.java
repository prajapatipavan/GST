package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Entity.GstInvoicEntity;
import com.Repositry.GstInvoiceRepositry;
import com.factory.RepositoryFactory;

@Service
public class GstInvoicesrvice {
	
	@Autowired
	RepositoryFactory factoryrepo;
	
  public GstInvoicEntity addinvoice(GstInvoicEntity invoice) {
		
		return factoryrepo.getGstinvoicerepo().save(invoice);
	}
	

}
