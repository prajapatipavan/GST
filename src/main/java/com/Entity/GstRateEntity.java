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
@Table(name = "gstrate")
@Getter
@Setter
@Data
public class GstRateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rateId;
	private  Double rate;
	private Double effactiveRate;
	private String description;
	private Boolean active = true;

}
