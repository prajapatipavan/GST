package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.GstCategoryEntity;
import com.Entity.UserEntity;
import com.Repositry.UserRepositry;

@Service
public class Userservice {
	
	
	@Autowired
	UserRepositry userRepo;
	
	
	public UserEntity saveuser(UserEntity user) {
		
		   return  userRepo.save(user);
	}
	
	
	public UserEntity  findUserByEmail(String email) {
		
		return userRepo.findByEmail(email);
	}
	
	
	 
	
	
	 public List<UserEntity> listUsers(UserEntity loggedUser) {
	        List<UserEntity> allActiveUsers = userRepo.findByActiveTrue();
	        
	        return allActiveUsers.stream()
	                .filter(user -> !user.getUserId().equals(loggedUser.getUserId()))
	                .collect(Collectors.toList());
	    }
	
	
	public UserEntity deleteuser(Integer userId) {
	    UserEntity user = userRepo.findById(userId).orElse(null);
	   
	    return user;
	}
	
	public void saveUser(UserEntity user) {
	    userRepo.save(user);
	}
	
	public List<UserEntity> Listuser(){
		
		return userRepo.findByActiveTrue();
	}

}
