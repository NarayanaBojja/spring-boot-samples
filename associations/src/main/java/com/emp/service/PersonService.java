package com.emp.service;

import com.emp.modal.Person;
import com.emp.modal.ResposeData;

public interface PersonService {

	public ResposeData<Person> addPerson(Person person);

	public ResposeData<Person> addJSON(String person);
	
}
