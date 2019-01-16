package com.employee.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.modal.Employee;
import com.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger LOGGER = LogManager.getLogger();
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee Savedemployee = null;
		try {
			Savedemployee = employeeRepository.save(employee);
			LOGGER.info("Employee is saved success fully");
		} catch (Exception e) {
			LOGGER.error("Error in saving Employee object", e);
		}

		return Savedemployee;
	}

}
