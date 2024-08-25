package com.crud.responseEntity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.responseEntity.entity.User;
import com.crud.responseEntity.exception.ErrorResponse;
import com.crud.responseEntity.exception.ResourceNotFoundException;
import com.crud.responseEntity.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	@PostMapping("/save")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		userService.createUser(user);
		new ResponseEntity<>(HttpStatus.CREATED);
		return ResponseEntity.ok().body("User Created Successfully...");

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
		userService.updateUser(id, user)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		return ResponseEntity.ok().body("User updated successfully...");
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<?>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		Optional<User> user = userService.getUserById(id);
		if (user.isPresent()) {
			new ResponseEntity<>(HttpStatus.OK);
			return ResponseEntity.ok().body(user.get());

		} else {
			return new ResponseEntity<>(new ErrorResponse("User not found with id: " + id, 404), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		boolean deleted = userService.deleteUser(id);
		if (deleted) {
			new ResponseEntity<>(HttpStatus.ACCEPTED);
			return ResponseEntity.ok().body("User deleted successfully...");
		} else {
			return new ResponseEntity<>(new ErrorResponse("User not found with id: " + id, 404), HttpStatus.NOT_FOUND);
		}
	}
}