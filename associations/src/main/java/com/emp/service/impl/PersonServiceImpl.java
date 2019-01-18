package com.emp.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.modal.Person;
import com.emp.modal.PersonDetails;
import com.emp.modal.ResposeData;
import com.emp.repository.PersonRepository;
import com.emp.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public ResposeData<Person> addPerson(Person person) {
		ResposeData<Person> response = new ResposeData<>();
		try {
			Person personSaved = personRepository.save(person);
			response.setStatus(201);
			response.setMessage("Person Created successfully");
			response.setData(personSaved);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public ResposeData<Person> addJSON(String person) {
		ResposeData<Person> response = new ResposeData<>();

		try {

			JSONObject object = new JSONObject(person);
			JSONObject personDetailsJSON = object.getJSONObject("personDetails");
			
			PersonDetails personDetails = new PersonDetails();
			personDetails.setMobile(personDetailsJSON.getLong("mobile"));
			personDetails.setEmail(personDetailsJSON.getString("email"));
			personDetails.setAddress(personDetailsJSON.getString("adrdress"));
	
			Person personObj = new Person();
			personObj.setAge(object.getInt("age"));
			personObj.setFullName(object.getString("fullName"));
			personObj.setPersonDetails(personDetails);
			
			Person personSaved = personRepository.save(personObj);
			response.setStatus(201);
			response.setMessage("Person Created successfully");
			response.setData(personSaved);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
