package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.modal.Employee;
import com.employee.modal.ResposeData;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger LOGGER = LogManager.getLogger();
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResposeData<Employee> addEmployee(Employee employee) {
		ResposeData<Employee> response = new ResposeData<>();
		try {
			Employee employeeExists = employeeRepository.findByPhone(employee.getPhone());

			if (employeeExists != null) {
				response.setStatus(409);
				response.setMessage("Employee already exists");
				response.setData(null);
				LOGGER.info("Employee already exists");
			} else {
				Employee savedEmployee = employeeRepository.save(employee);
				response.setStatus(201);
				response.setMessage("Employee is created successfully");
				response.setData(savedEmployee);
				LOGGER.info("Employee is created success fully");
			}

		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage("Error in saving Employee object");
			response.setData(null);
			throw e;
		}

		return response;
	}

	@Override
	public ResposeData<Employee> getByFullName(String fullName) {
		ResposeData<Employee> response = new ResposeData<>();
		try {
			Employee employeeExists = employeeRepository.getByFullName(fullName);
			if (employeeExists != null) {
				response.setStatus(200);
				response.setMessage("Getting Employee by full name is successful");
				response.setData(employeeExists);
				LOGGER.info("Getting Employee by full name is successful");

			} else {
				response.setStatus(204);
				response.setMessage("Employee is not found");
				response.setData(null);
				LOGGER.info("Employee is not found by the fullName");
			}

		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage("Error in Getting Employee by full name");
			response.setData(null);
			throw e;
		}

		return response;
	}

	@Override
	public ResposeData<List<Employee>> getAllEmployees() {
		ResposeData<List<Employee>> response = new ResposeData<>();
		try {
			List<Employee> allEmps = employeeRepository.findAll();
			response.setStatus(200);
			response.setMessage("Getting All Employees is successful");
			response.setData(allEmps);
			LOGGER.info("Getting All Employees is successful");

		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage("Error in Getting Employee by full name");
			response.setData(null);
			throw e;
		}

		return response;
	}

	@Override
	public ResposeData<Employee> updateEmployee(Employee employee) {
		ResposeData<Employee> response = new ResposeData<>();
		Employee employeeExists = null;
		try {
			Optional<Employee> empOptional = employeeRepository.findById(employee.getId());
			if (empOptional.isPresent()) {
				employeeExists = empOptional.get();
			}
			if (employeeExists != null) {
				Employee savedEmployee = employeeRepository.save(employee);
				response.setStatus(200);
				response.setMessage("Employee is updated successfully");
				response.setData(savedEmployee);
				LOGGER.info("Employee is updated success fully");

			} else {
				response.setStatus(204);
				response.setMessage("Employee is not found");
				response.setData(null);
				LOGGER.info("Employee is not found by Id");
			}

		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage("Error in updating Employee object");
			response.setData(null);
			throw e;
		}

		return response;
	}

	@Override
	public ResposeData<Employee> deleteEmployee(int id) {
		ResposeData<Employee> response = new ResposeData<>();
		Employee employeeExists = null;
		try {
			Optional<Employee> empOptional = employeeRepository.findById(id);
			if (empOptional.isPresent()) {
				employeeExists = empOptional.get();
			}
			if (employeeExists != null) {
				employeeRepository.deleteById(id);
				response.setStatus(200);
				response.setMessage("Employee is deleted successfully");
				response.setData(null);
				LOGGER.info("Employee is deleted success fully");
			} else {
				response.setStatus(204);
				response.setMessage("Employee is not found");
				response.setData(null);
				LOGGER.info("Employee is not found by Id");
			}
		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage("Error in deleting Employee object");
			response.setData(null);
			throw e;
		}

		return response;
	}

}
