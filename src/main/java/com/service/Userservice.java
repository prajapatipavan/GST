package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.GstCategoryEntity;
import com.Entity.UserEntity;
import com.Repositry.UserRepositry;
import com.factory.RepositoryFactory;

@Service
public class Userservice {

	@Autowired
	RepositoryFactory factoryrepo;

	public UserEntity saveuser(UserEntity user) {

		return factoryrepo.getUserRepo().save(user);
	}

	public UserEntity findUserByEmail(String email) {

		return factoryrepo.getUserRepo().findByEmail(email);
	}

	public List<UserEntity> listUsers(UserEntity loggedUser) {
		List<UserEntity> allActiveUsers = factoryrepo.getUserRepo().findByActiveTrue();

		return allActiveUsers.stream().filter(user -> !user.getUserId().equals(loggedUser.getUserId()))
				.collect(Collectors.toList());
	}

	public UserEntity deleteuser(Integer userId) {
		UserEntity user = factoryrepo.getUserRepo().findById(userId).orElse(null);

		return user;
	}

	public void saveUser(UserEntity user) {
		factoryrepo.getUserRepo().save(user);
	}

	public List<UserEntity> Listuser() {

		return factoryrepo.getUserRepo().findByActiveTrue();
	}

	
}
