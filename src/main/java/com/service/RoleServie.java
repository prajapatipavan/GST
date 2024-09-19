package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.RoleEntity;
import com.Entity.UserEntity;
import com.Repositry.RoleRepositry;
import com.factory.RepositoryFactory;

@Service
public class RoleServie {
	
	@Autowired
	RepositoryFactory factoryrepo;
	  
	  
	    public List<RoleEntity> listofrole() {
	    	
	    	 
               return factoryrepo.getRolerepo().findAll();
	    }
	  
	  
	   public RoleEntity saverole(RoleEntity user) {
		   
		   return factoryrepo.getRolerepo().save(user);
	   }
	   
	   public RoleEntity getRoleById(Integer roleId) {
	        return factoryrepo.getRolerepo().findByroleId(roleId);
	    }
}
