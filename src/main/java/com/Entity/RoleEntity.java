package com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Role")
@Setter
@Getter
@Data
public class RoleEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer roleId;
	  private String roleName;
	  
	  
	  

}
