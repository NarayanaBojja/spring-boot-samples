package com.employee.service;

import com.employee.modal.Employee;
import com.employee.modal.ResposeData;

public interface EmployeeService {

	public ResposeData<Employee> addEmployee(Employee employee);
} 
