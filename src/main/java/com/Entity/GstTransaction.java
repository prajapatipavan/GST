package com.Entity;
import java.util.List;

import com.dto.Customerdto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name ="gstTransaction")
@Getter
@Setter
@Data
 public class GstTransaction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer transactionId;
	
	@ManyToOne
	private UserEntity user;
	
	@ManyToOne
	private GstRateEntity gstrate;

	
	@ManyToOne
	private GstCategoryEntity gstcatagory;
	
	@ManyToOne
	private CustomerEntity  customer;
	
	@ManyToMany
	private List<ProductEntity> products;
	
	private Double amount;
	
	private String gstNumber;
	
	private String date;
	
	private String totalAmount;
	
	private String gstAmount;
	
	private Boolean active = true;
	
	 
}

