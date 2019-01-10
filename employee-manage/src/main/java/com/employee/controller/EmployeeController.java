package com.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/employee")
	public Employee getEmployee() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Narayana");
		employee.setMarried(false);
		return employee;
	}

}
