package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.modal.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByPhone(long phone);

	@Query("From Employee where name =:fullName")
	Employee getByFullName(@Param("fullName") String name);

}
