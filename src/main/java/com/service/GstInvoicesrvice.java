package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Entity.GstInvoicEntity;
import com.Repositry.GstInvoiceRepositry;

@Service
public class GstInvoicesrvice {
	
	@Autowired
	GstInvoiceRepositry gstinvoicerepo;
	
  public GstInvoicEntity addinvoice(GstInvoicEntity invoice) {
		
		return gstinvoicerepo.save(invoice);
	}
	

}
