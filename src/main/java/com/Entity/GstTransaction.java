package com.Entity;
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
	
	private Double amount;
	
	private String gstNumber;
	
	private String date;
	
	private String totalAmount;
	
	private String gstAmount;
	
	private Boolean active = true;
}

