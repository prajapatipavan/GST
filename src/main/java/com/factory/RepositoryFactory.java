package com.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Repositry.GstInvoiceRepositry;
import com.Repositry.GstRateRepositry;
import com.Repositry.GstTransactionReositry;
import com.Repositry.GstcatagoryRepositry;
import com.Repositry.RoleRepositry;
import com.Repositry.UserRepositry;

import lombok.Getter;

@Component
@Getter
public class RepositoryFactory {

	@Autowired
	private GstTransactionReositry gstTransaction;

	@Autowired
	private GstcatagoryRepositry gstcatrepo;

	@Autowired
	private GstInvoiceRepositry gstinvoicerepo;

	@Autowired
	private GstRateRepositry gstraterepo;

	@Autowired
	private RoleRepositry rolerepo;

	@Autowired
	private UserRepositry userRepo;
}
