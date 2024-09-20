package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.GstInvoicEntity;
import com.Entity.UserEntity;
import com.Repositry.GstInvoiceRepositry;
import com.dto.Userdto;
import com.factory.RepositoryFactory;

@Service
public class GstInvoicesrvice {
	
	@Autowired
	RepositoryFactory factoryrepo;
	
  public GstInvoicEntity addinvoice(GstInvoicEntity invoice) {
		
		return factoryrepo.getGstinvoicerepo().save(invoice);
	}
  
  
  public Userdto userDeatails(@RequestParam("userId") Integer userId) {
	  
	         UserEntity user  =  factoryrepo.getUserRepo().findById(userId).get();
	         
	         return userToUserdto(user);
	  
  }
	
  
  public UserEntity userdtoToUserEntity(Userdto userdto) {
      return this.factoryrepo.getModelmapper().map(userdto, UserEntity.class);
  }

  public Userdto userToUserdto(UserEntity userEntity) {
      return this.factoryrepo.getModelmapper().map(userEntity, Userdto.class);
  }

}
