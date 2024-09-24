package com.dto;

import lombok.Data;

@Data
public class Productdto {
	
private Integer productId;
	
	private String productName;
	
	private double productprize;
	
    private String productDescription;
	
	private String category;
	
	private Integer stockQuantity;
	
	private double rate;
	
	
	private Boolean active = true;
	
	private String date;

}
