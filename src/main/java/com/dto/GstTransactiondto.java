package com.dto;
import java.util.List;

import com.Entity.CustomerEntity;
import com.Entity.GstCategoryEntity;
import com.Entity.GstRateEntity;
import com.Entity.ProductEntity;
import com.Entity.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Data
 public class GstTransactiondto {
	
	
    private Integer transactionId;
	
	@ManyToOne
	private UserEntity user;
	
	@ManyToOne
	private GstRateEntity gstrate;
	
	@ManyToOne
	private GstCategoryEntity gstcatagory;
	
	
	private List<ProductEntity> products;
	
	private Double amount;
	
	private String gstNumber;
	
	private String date;
	
	private String totalAmount;
	
	private String gstAmount;
	
	private CustomerEntity  customer;
	
	private Boolean active = true;
}

