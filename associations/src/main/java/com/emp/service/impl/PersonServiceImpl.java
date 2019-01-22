package com.emp.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.modal.HostelData;
import com.emp.modal.HostelDetail;
import com.emp.modal.HostelDetailData;
import com.emp.modal.HostelOwner;
import com.emp.modal.HostelOwnerData;
import com.emp.modal.Person;
import com.emp.modal.PersonDetails;
import com.emp.modal.Post;
import com.emp.modal.PostData;
import com.emp.modal.ResposeData;
import com.emp.modal.Tag;
import com.emp.modal.TagData;
import com.emp.repository.HostelDetailRepository;
import com.emp.repository.HostelOwnerRepository;
import com.emp.repository.PersonRepository;
import com.emp.repository.PostRepository;
import com.emp.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private HostelDetailRepository hostelDetailRepository;
	@Autowired
	private HostelOwnerRepository hostelOwnerRepository;
	@Autowired
	private PostRepository postRepository;

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

	@Override
	public ResposeData<List<HostelDetail>> addHostel(HostelData hostel) {
		ResposeData<List<HostelDetail>> response = new ResposeData<>();

		try {
			HostelOwner hostelOwner = new HostelOwner();
			HostelOwnerData hostelOwnerData = hostel.getHostelOwnerData();
			hostelOwner.setName(hostelOwnerData.getName());
			hostelOwner.setMobile(hostelOwnerData.getMobile());
			HostelOwner hostelOwnerSaved = hostelOwnerRepository.save(hostelOwner);
			List<HostelDetailData> list = hostel.getHostelDetailDataList();
			List<HostelDetail> hostelList = new ArrayList<>();

			for (HostelDetailData hostelDetailData : list) {
				HostelDetail hostelDetail = new HostelDetail();
				hostelDetail.setHostelName(hostelDetailData.getHostelName());
				hostelDetail.setHostelOwner(hostelOwnerSaved);
			//	hostelDetailRepository.save(hostelDetail);
				hostelList.add(hostelDetail);
			}
			List<HostelDetail> dbList = hostelDetailRepository.saveAll(hostelList);

			response.setStatus(200);
			response.setMessage("All Hostel details are saved sucessfully");
			response.setData(dbList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public ResposeData<Post> addPosts(PostData posts) {
		ResposeData<Post> response = new ResposeData<>();
		try {

			Set<TagData> set = posts.getTags();
			Set<Tag> tagSet = new HashSet<>();

			for (TagData tagData : set) {
				Tag tag = new Tag();
				tag.setName(tagData.getName());
				tagSet.add(tag);
			}
			Post post = new Post();
			post.setDescription(posts.getDescription());
			post.setTags(tagSet);
			Post postSaved = postRepository.save(post);
			response.setStatus(200);
			response.setMessage("All Hostel details are saved sucessfully");
			response.setData(postSaved);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
