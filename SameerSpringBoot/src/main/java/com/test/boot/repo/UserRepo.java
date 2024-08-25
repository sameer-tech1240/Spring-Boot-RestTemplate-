package com.test.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.boot.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
