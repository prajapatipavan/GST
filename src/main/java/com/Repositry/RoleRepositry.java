package com.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.RoleEntity;
import com.Entity.UserEntity;

public interface RoleRepositry extends JpaRepository<RoleEntity,Integer>{

	RoleEntity findByroleId(Integer roleId);

	RoleEntity findByRoleId(Integer roleId);



}
