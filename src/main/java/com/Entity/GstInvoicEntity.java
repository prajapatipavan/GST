package com.Entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="gst_invoice")
@Data
public class GstInvoicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer invoiceId;
	
	@ManyToOne
	private UserEntity user;

	@Column(name = "invoice_number")
	private String invoiceNumber;

	@Column(name = "issue_date")
	private String issueDate;

	@Column(name = "due_date")
	private String dueDate;
	
	private double totalAmount;

	private Boolean active=true;
}
