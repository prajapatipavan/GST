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
import com.factory.RepositoryFactory;

@Service
public class GstRateService {
	
	@Autowired
	RepositoryFactory factoryrepo;
	
  public GstRateEntity addrate(GstRateEntity rate) {
		
		return factoryrepo.getGstraterepo().save(rate);
	}
  
    
  public List<GstRateEntity> Listgstrate(){
		
	  return factoryrepo.getGstraterepo().findByActiveTrue();
	}
  
  public GstRateEntity getGstRateById(Integer rateId) {
	    return factoryrepo.getGstraterepo().findById(rateId).orElse(null);
	}

	
  public void saveGstRate(GstRateEntity gstrate) {
	  factoryrepo.getGstraterepo().save(gstrate);
	}

}
