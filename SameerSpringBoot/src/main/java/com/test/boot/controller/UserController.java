package com.test.boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.boot.entity.User;
import com.test.boot.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService serviceImp;

	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		return serviceImp.saveUser(user);
	}

	@PutMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User user) {
		return serviceImp.updateUser(user);

	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		serviceImp.deleteUser(id);
		return "User deleted successflly.....";

	}

	@GetMapping("/findById/{id}")
	public User findById(@PathVariable("id") Integer id) {
		
		return serviceImp.findUserById(id);

	}

	@GetMapping("/findAllUser")
	public List<User> findAllUser() {
		return serviceImp.findAllUser();
	}

}
