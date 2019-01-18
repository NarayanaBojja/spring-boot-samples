package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.modal.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
