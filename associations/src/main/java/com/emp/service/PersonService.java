package com.emp.service;

import java.util.List;

import com.emp.modal.HostelData;
import com.emp.modal.HostelDetail;
import com.emp.modal.Person;
import com.emp.modal.Post;
import com.emp.modal.PostData;
import com.emp.modal.ResposeData;

public interface PersonService {

	public ResposeData<Person> addPerson(Person person);

	public ResposeData<Person> addJSON(String person);
	public ResposeData<List<HostelDetail>> addHostel(HostelData person);

	public ResposeData<Post> addPosts(PostData posts);
}
