package com.employee.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.modal.Employee;
import com.employee.modal.ResposeData;
import com.employee.modal.User;
import com.employee.modal.UserData;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger LOGGER = LogManager.getLogger();
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public ResposeData<Employee> addEmployee(@RequestBody Employee employee) {
		ResposeData<Employee> res = null;
		try {
			res = employeeService.addEmployee(employee);

		} catch (Exception e) {
			LOGGER.error("Error in saving Employee object", e);
		}
		return res;
	}

	@GetMapping("/get/{fullName}")
	public ResposeData<Employee> getByFullName(@PathVariable String fullName) {
		ResposeData<Employee> res = null;
		try {
			res = employeeService.getByFullName(fullName);

		} catch (Exception e) {
			LOGGER.error("Error in getting Employee by fullName", e);
		}
		return res;

	}

	@GetMapping("/all")
	public ResposeData<List<Employee>> getAllEmployees() {
		ResposeData<List<Employee>> res = null;
		try {
			res = employeeService.getAllEmployees();

		} catch (Exception e) {
			LOGGER.error("Error in getting all Employees", e);
		}
		return res;
	}

	@PutMapping("/update")
	public ResposeData<Employee> updateEmployee(@RequestBody Employee employee) {
		ResposeData<Employee> res = null;
		try {
			res = employeeService.updateEmployee(employee);

		} catch (Exception e) {
			LOGGER.error("Error in updating Employee object", e);
		}
		return res;

	}

	@DeleteMapping("/delete")
	public ResposeData<Employee> deleteEmployee(@RequestParam("id") int id) {
		ResposeData<Employee> res = null;
		try {
			res = employeeService.deleteEmployee(id);
		} catch (Exception e) {
			LOGGER.error("Error in deleting Employee object", e);
		}
		return res;
	}

	

}
