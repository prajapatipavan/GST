package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.GstCategoryEntity;
import com.Entity.GstInvoicEntity;
import com.Entity.GstRateEntity;
import com.Entity.GstTransaction;
import com.Repositry.GstInvoiceRepositry;
import com.Repositry.GstRateRepositry;

@Service
public class GstRateService {
	
	@Autowired
	GstRateRepositry gstraterepo;;
	
  public GstRateEntity addrate(GstRateEntity rate) {
		
		return gstraterepo.save(rate);
	}
  
    
  public List<GstRateEntity> Listgstrate(){
		
	  return gstraterepo.findByActiveTrue();
	}
  
  public GstRateEntity getGstRateById(Integer rateId) {
	    return gstraterepo.findById(rateId).orElse(null);
	}

	
  public void saveGstRate(GstRateEntity gstrate) {
	    gstraterepo.save(gstrate);
	}

}
