package com.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.UserEntity;

public interface UserRepositry extends JpaRepository<UserEntity,Integer>{

	UserEntity findByEmail(String email);

	List<UserEntity> findByuserId(Integer userId);

	 

	List<UserEntity> findByActiveTrue();





}
