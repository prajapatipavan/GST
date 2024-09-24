package com.dto;

import lombok.Data;

@Data
public class UserTransactionDto {

    private Userdto user;                  
    private GstTransactiondto gstTransaction;  
   
    public UserTransactionDto(Userdto user, GstTransactiondto gstTransaction) {
        this.user = user;
        this.gstTransaction = gstTransaction;
    }

}