package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.CustomerEntity;
import com.dto.Customerdto;
import com.factory.RepositoryFactory;

@Service
public class CustomerService {
	
	@Autowired
	RepositoryFactory repofactory;
	
	  
	    public List<CustomerEntity> listcustomer(Integer userId) {
	    	
	    	           
	          return repofactory.getCustomerRepositry().findByUserUserId(userId);
	                
	           
	    }
	    
	    
	    public List<CustomerEntity> customerIdbasetransaction(String email){
	    	
	    	 return repofactory.getCustomerRepositry().findByEmail(email);
	    }
	    
	    public List<CustomerEntity> customer(String email){
	    	
	    	 return repofactory.getCustomerRepositry().findCustomerByEmail(email);
	    }

}
