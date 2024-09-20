package com.factory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.Repositry.GstTransactionReositry;
import com.Repositry.UserRepositry;
import com.service.GstCategoryService;
import com.service.GstInvoicesrvice;
import com.service.GstRateService;
import com.service.GstTransactionservice;
import com.service.RoleServie;
import com.service.Userservice;

import lombok.Getter;

@Component
@Getter
public class ServiceFactory {

	@Autowired
	private GstTransactionservice gsttransactions;

	@Autowired
	private GstTransactionReositry gstTransactionRepo;

	@Autowired
	private GstRateService gstrate;

	@Autowired
	private GstCategoryService gstcatagory;

	@Autowired
	private Userservice userservice;

	@Autowired
	GstInvoicesrvice gstinvoiceservice;

	@Autowired
	private UserRepositry userrepo;

	@Autowired
	GstTransactionservice gsttransactionservice;
	
	 @Autowired
	 RoleServie roleservice;
	 
		@Autowired
		BCryptPasswordEncoder passencode;

		
}
