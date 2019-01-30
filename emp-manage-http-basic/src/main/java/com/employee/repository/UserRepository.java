package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.modal.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByPhone(String phone);
}
