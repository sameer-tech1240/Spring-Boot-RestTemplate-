package com.crud.responseEntity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.responseEntity.entity.User;
import com.crud.responseEntity.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> updateUser(Long id, User user) {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {
			user.setId(id);
			return Optional.of(userRepository.save(user));
		}
		return Optional.empty();
	}

	@Override
	public boolean deleteUser(Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
