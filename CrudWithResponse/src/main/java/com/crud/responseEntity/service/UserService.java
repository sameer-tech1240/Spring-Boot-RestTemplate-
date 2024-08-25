package com.crud.responseEntity.service;

import java.util.List;
import java.util.Optional;

import com.crud.responseEntity.entity.User;

public interface UserService {
	
	List<User> getAllUsers();
	
    Optional<User> getUserById(Long id);
    
    User createUser(User user);
    
    Optional<User> updateUser(Long id, User user);

    boolean deleteUser(Long id);
}