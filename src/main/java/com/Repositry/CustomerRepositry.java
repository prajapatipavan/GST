package com.Repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Entity.CustomerEntity;
import com.Entity.GstTransaction;
import com.dto.Customerdto;

public interface CustomerRepositry extends JpaRepository<CustomerEntity, Integer> {



	List<CustomerEntity> findByUserUserId(Integer userId);

	List<CustomerEntity> findByEmail(String email);

	List<CustomerEntity> findByCustomerId(Integer CustomerId);

	List<CustomerEntity> findCustomerByEmail(String email);


	
	

	


}
