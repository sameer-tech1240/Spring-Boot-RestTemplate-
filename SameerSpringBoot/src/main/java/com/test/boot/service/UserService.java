package com.test.boot.service;

import java.util.List;

import com.test.boot.entity.User;

public interface UserService {
	User saveUser(User user);

	User updateUser(User user);

	User findUserById(Integer id);

	String deleteUser(Integer id);

	List<User> findAllUser();

}
