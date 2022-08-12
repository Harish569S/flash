package com.mindtree.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mindtree.employee.entity.Employee;
import com.mindtree.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/new")
	public String hello() {
		return "Hello im employee";
	}

	@GetMapping
	public String hello1() {
		return restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/new", String.class);
	}
	@PostMapping()
	public Employee addEmployee(Employee emp) {
		
		return employeeService.addEmp(emp);
	}
}
