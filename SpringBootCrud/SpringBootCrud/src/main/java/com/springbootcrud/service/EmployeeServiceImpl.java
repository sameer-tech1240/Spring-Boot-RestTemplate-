package com.springbootcrud.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.springbootcrud.entity.Employee;
import com.springbootcrud.repo.EmployeeRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepo repo;

	@Override
	public Employee saveEmployee(Employee employee) {
		if (Objects.isNull(employee))
			return null;

		return repo.save(employee);
	}

	@Override
	public Employee updatEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public Employee getSingleEmployee(Integer id) {
		
		return repo.findById(id).get();
		
	}

	@Override
	public List<Employee> getAllEmployee() {
	
		return repo.findAll();
	}

	@Override
	
	public String deleteEmployee(Integer id) {
		
		repo.deleteById(id);
		return "";
	}

}
