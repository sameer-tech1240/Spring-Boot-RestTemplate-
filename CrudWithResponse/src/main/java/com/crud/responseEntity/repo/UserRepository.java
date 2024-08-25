package com.crud.responseEntity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.responseEntity.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}