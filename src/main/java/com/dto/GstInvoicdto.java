package com.dto;






import com.Entity.UserEntity;

import jakarta.persistence.Column;

import lombok.Data;

@Data
public class GstInvoicdto {

	
	private Integer invoiceId;

	
	private UserEntity user;

	@Column(name = "invoice_number")
	private String invoiceNumber;

	@Column(name = "issue_date")
	private String issueDate;

	@Column(name = "due_date")
	private String dueDate;
	
	
	private double totalAmount;
	

	private Boolean active = true;

	
}
