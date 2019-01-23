package com.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.modal.Employee;

@RestController
public class EmpController {

	@GetMapping("/employee")
	public Employee getEmployee() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Spring Boot");
		emp.setPhone(1234567);
		return emp;
	}
}
