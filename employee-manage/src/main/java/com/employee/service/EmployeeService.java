package com.employee.service;

import java.util.List;

import com.employee.modal.Employee;
import com.employee.modal.ResposeData;

public interface EmployeeService {

	public ResposeData<Employee> addEmployee(Employee employee);

	public ResposeData<Employee> getByFullName(String fullName);

	public ResposeData<List<Employee>> getAllEmployees();

	public ResposeData<Employee> updateEmployee(Employee employee);

	public ResposeData<Employee> deleteEmployee(int id);

}
