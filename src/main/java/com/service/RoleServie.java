package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.RoleEntity;
import com.dto.Roledto;
import com.factory.RepositoryFactory;

@Service
public class RoleServie {
	
	@Autowired
	RepositoryFactory factoryrepo;
	  
	  
	    public List<Roledto> listofrole() {
	    	
	    	 
             List<RoleEntity> roleentity  = factoryrepo.getRolerepo().findAll();
             
             return roleentity.stream().map(this:: roleEntityToRoleDto).collect(Collectors.toList());
	    }
	  
	  
	   public RoleEntity saveRole(Roledto user) {
		   
		         RoleEntity users = roleDtoToRoleEntity(user);    
		   
		   return factoryrepo.getRolerepo().save(users);
	   }
	   
	   public Roledto getRoleById(Integer roleId) {
	        RoleEntity roleentity = factoryrepo.getRolerepo().findByroleId(roleId);
	        return roleEntityToRoleDto(roleentity);
	    }
	   
	   
	   public RoleEntity  roleDtoToRoleEntity(Roledto roledto) {
		   
		       RoleEntity roleentity = factoryrepo.getModelmapper().map(roledto,RoleEntity.class);
		       
		       return roleentity;
	   }
	   
	   public Roledto  roleEntityToRoleDto(RoleEntity roleEntity) {
		   
	       Roledto roledto = factoryrepo.getModelmapper().map(roleEntity,Roledto.class);
	       
	       return roledto;
   }
	   
}
