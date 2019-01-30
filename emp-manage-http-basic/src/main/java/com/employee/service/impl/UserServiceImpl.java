package com.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.modal.ResposeData;
import com.employee.modal.Role;
import com.employee.modal.User;
import com.employee.modal.UserData;
import com.employee.repository.RoleRepository;
import com.employee.repository.UserRepository;
import com.employee.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public ResposeData<User> addAdmin(UserData userData) {

		ResposeData<User> response = new ResposeData<>();
		try {
			User user = new User();
			user.setName(userData.getName());
			user.setPhone(userData.getPhone());
			user.setActive(userData.isActive());
			user.setPassword(bCryptPasswordEncoder.encode(userData.getPassword()));
			List<Integer> roleIdList = userData.getRoleIdList();
			List<Role> rolesList = roleRepository.findAllById(roleIdList);
			user.setRoles(rolesList);
			User userSaved = userRepository.save(user);
			response.setStatus(201);
			response.setMessage("User has been created successfully");
			response.setData(userSaved);
		} catch (Exception e) {
			throw e;
		}

		return response;
	}

}
