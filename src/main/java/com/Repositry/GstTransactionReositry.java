package com.Repositry;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Entity.CustomerEntity;
import com.Entity.GstTransaction;
import com.Entity.UserEntity;
import com.dto.GstTransactiondto;
import com.dto.Userdto;

public interface GstTransactionReositry extends JpaRepository<GstTransaction,Integer>{

	List<GstTransaction> findBytransactionId(Integer transactionId);
	
	
	List<GstTransaction> findByUser(UserEntity user);
	
	
	List<GstTransaction> findByActiveTrue();
	

	List<GstTransaction> findByUser_UserId(Integer userId);
	
	
	@Query(value = "SELECT t.* " +
            "FROM gst_transaction t " +
            "JOIN user u ON u.user_id = t.user_user_id " +
            "WHERE u.active = true AND t.active = true", 
    nativeQuery = true)
	
	List<GstTransaction> findByUserActiveTrue();


	List<GstTransaction> findByCustomer(CustomerEntity customer);


	


	

}
