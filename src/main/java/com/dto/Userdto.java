package com.dto;

import java.util.ArrayList;
import java.util.List;

import com.Entity.GstTransaction;
import com.Entity.RoleEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Data
public class Userdto {
	
	private Integer userId;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private Boolean active = true;
	
	    
   private GstTransaction gsttrasaction;
	
	private RoleEntity role;


	

}


    