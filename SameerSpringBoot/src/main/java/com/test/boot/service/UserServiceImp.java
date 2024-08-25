package com.test.boot.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.test.boot.entity.User;
import com.test.boot.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
	private final UserRepo repo;

	@Override
	public User saveUser(User user) {
		if (Objects.isNull(user))
			return null;
		else
			return repo.save(user);
	}

	@Override
	public User updateUser(User user) {
				return repo.save(user);
	}

	@Override
	public User findUserById(Integer id) {
		User findById = repo.findById(id).get();
		return findById;
	}

	@Override
	public String deleteUser(Integer id) {
		repo.deleteById(id);
		return "User deeted successfully.....";
	}

	@Override
	public List<User> findAllUser() {
		return repo.findAll();
	}

}
