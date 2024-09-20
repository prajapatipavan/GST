package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.UserEntity;
import com.dto.Userdto;
import com.factory.RepositoryFactory;

@Service
public class Userservice {

    @Autowired
    RepositoryFactory factoryrepo;

   
    public Userdto saveUser(Userdto userdto) {
        UserEntity userEntity = userdtoToUserEntity(userdto); 
        UserEntity savedUser = factoryrepo.getUserRepo().save(userEntity); 
        return userToUserdto(savedUser); 
    }

    
    public Userdto findUserByEmail(String email) {
        UserEntity userEntity = factoryrepo.getUserRepo().findByEmail(email);
        return userToUserdto(userEntity); 
    }


    public List<Userdto> listUsers(Userdto loggedUserDto) {
        UserEntity loggedUserEntity = userdtoToUserEntity(loggedUserDto); 
        List<UserEntity> allActiveUsers = factoryrepo.getUserRepo().findByActiveTrue();

        return allActiveUsers.stream()
                .filter(user -> !user.getUserId().equals(loggedUserEntity.getUserId()))
                .map(this::userToUserdto) 
                .collect(Collectors.toList());
    }

 
    public Userdto deleteUser(Integer userId) {
        UserEntity userEntity = factoryrepo.getUserRepo().findById(userId).orElse(null);

        if (userEntity != null) {
            factoryrepo.getUserRepo().delete(userEntity);
        }

        return userToUserdto(userEntity);
    }

   
    public List<Userdto> listAllActiveUsers() {
        List<UserEntity> activeUsers = factoryrepo.getUserRepo().findByActiveTrue();
        return activeUsers.stream()
                .map(this::userToUserdto) 
                .collect(Collectors.toList());
    }
    
    
    public List<UserEntity> Listuser() {

		return factoryrepo.getUserRepo().findByActiveTrue();
	}

   
    public UserEntity userdtoToUserEntity(Userdto userdto) {
        return this.factoryrepo.getModelmapper().map(userdto, UserEntity.class);
    }

    public Userdto userToUserdto(UserEntity userEntity) {
        return this.factoryrepo.getModelmapper().map(userEntity, Userdto.class);
    }


	
}
