package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.RoleEntity;
import com.Entity.UserEntity;
import com.Repositry.RoleRepositry;

@Service
public class RoleServie {
	
	  @Autowired
	  RoleRepositry rolerepo; 
	  
	  
	    public List<RoleEntity> listofrole() {
	    	
	    	 
               return  rolerepo.findAll();
	    }
	  
	  
	   public RoleEntity saverole(RoleEntity user) {
		   
		   return rolerepo.save(user);
	   }
	   
	   public RoleEntity getRoleById(Integer roleId) {
	        return rolerepo.findByroleId(roleId);
	    }
}
