package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.modal.HostelData;
import com.emp.modal.HostelDetail;
import com.emp.modal.Person;
import com.emp.modal.Post;
import com.emp.modal.PostData;
import com.emp.modal.ResposeData;
import com.emp.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping("/addperson")
	public ResposeData<Person> addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}

	@PostMapping("/addJSON")
	public ResposeData<Person> addJSON(@RequestBody String person) {
		return personService.addJSON(person);
	}

	@PostMapping("/onetomany")
	public ResposeData<List<HostelDetail>> addHostel(@RequestBody HostelData hostel) {
		return personService.addHostel(hostel);
	}

	@PostMapping("/manytomany")
	public ResposeData<Post> addPosts(@RequestBody PostData posts) {
		return personService.addPosts(posts);
	}

}
