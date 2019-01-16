package com.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.modal.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
