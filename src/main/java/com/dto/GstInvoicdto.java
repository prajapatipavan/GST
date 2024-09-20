package com.dto;

import com.Entity.GstTransaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gst_invoice")
public class GstInvoicdto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "transaction_id")
	private GstTransaction transaction;

	@Column(name = "invoice_number")
	private String invoiceNumber;

	@Column(name = "issue_date")
	private String issueDate;

	@Column(name = "due_date")
	private String dueDate;

	private Boolean active = true;
}
