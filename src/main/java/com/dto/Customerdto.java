package com.dto;


import com.Entity.GstTransaction;
import com.Entity.UserEntity;

import lombok.Data;


@Data
public class Customerdto {

   
    private Integer customerId;
    private String customerName;
    private String contactNumber;
    private String email;
    private String gstNumber;
    private String address;
    
    private UserEntity user;
    
    private GstTransaction transaction;
    
    
    private boolean active=true;
   
}
