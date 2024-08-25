package com.springbootcrud.service;

import java.util.List;

import com.springbootcrud.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);

	Employee updatEmployee(Employee employee);

	Employee getSingleEmployee(Integer id);

	List<Employee> getAllEmployee();

	String deleteEmployee(Integer id);

}
