package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Entity.GstRateEntity;
import com.Repositry.GstRateRepositry;
import com.dto.GstRatedto;
import com.factory.RepositoryFactory;

@Service
public class GstRateService {
	
	@Autowired
	RepositoryFactory factoryrepo;
	
	public GstRateEntity addrate(GstRatedto rate) {
        // Convert the incoming DTO to the entity type for persistence
        GstRateEntity gstrate = RatedtoToRateEntity(rate);
        
        // Get the repository using a getter method
        GstRateRepositry gstraterepo = factoryrepo.getGstraterepo();
        
        // Save the GST rate entity to the database and return the saved DTO
        return gstraterepo.save(gstrate);
    } 
    
   public List<GstRatedto> Listgstrate(){
		
	   GstRateRepositry gstraterepo = factoryrepo.getGstraterepo();
	   
	         List<GstRateEntity> gstrateentity = gstraterepo.findByActiveTrue();
	         
	        return gstrateentity.stream().map(this::RateEntityToRatedto).collect(Collectors.toList());
	   
	}
  
  public GstRatedto getGstRateById(Integer rateId) {
	  
	    GstRateRepositry gstraterepo = factoryrepo.getGstraterepo();
	       
	                    GstRateEntity gstrate =gstraterepo.findById(rateId).orElse(null);
	    
	    return RateEntityToRatedto(gstrate);
	}

	
  public void saveGstRate(GstRatedto gstratedto) {
	  
	       GstRateEntity gstrate = RatedtoToRateEntity(gstratedto);
	  
	       GstRateRepositry gstraterepo = factoryrepo.getGstraterepo();
	  
	          gstraterepo.save(gstrate);
	}
  
  
  public GstRateEntity RatedtoToRateEntity(GstRatedto gstratedto) {
	 
	      GstRateEntity gstrateEntity = factoryrepo.getModelmapper().map(gstratedto,GstRateEntity.class);  
	      
	      return gstrateEntity;
	  
  }
  
  public GstRatedto RateEntityToRatedto(GstRateEntity gstrateentity) {
		 
       GstRatedto gstRatedto = factoryrepo.getModelmapper().map(gstrateentity,GstRatedto.class);  
      
      return gstRatedto;
  
}

}
