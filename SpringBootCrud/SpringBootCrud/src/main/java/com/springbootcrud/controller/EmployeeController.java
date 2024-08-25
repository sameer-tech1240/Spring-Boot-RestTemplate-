package com.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.springbootcrud.entity.Employee;
import com.springbootcrud.service.EmployeeService;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("save")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		 Employee saveEmployee = service.saveEmployee(employee);
		 return new ResponseEntity<>(saveEmployee , HttpStatus.CREATED);

	}

	@PutMapping("update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updatEmployee(employee);
	}

	@GetMapping("getById/{id}")
	public Employee getSingleEmployee(@PathVariable Integer id) {
		return service.getSingleEmployee(id);

	}

	@GetMapping("getAll")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}

	@DeleteMapping("delete/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		service.deleteEmployee(id);
		return "Employee deleted successfully.....";

	}

}
