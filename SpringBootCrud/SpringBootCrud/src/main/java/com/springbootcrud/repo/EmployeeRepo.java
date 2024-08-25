package com.springbootcrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootcrud.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
