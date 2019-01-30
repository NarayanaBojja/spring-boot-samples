package com.employee.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.modal.ResposeData;
import com.employee.modal.User;
import com.employee.modal.UserData;
import com.employee.service.UserService;

@RestController
public class UserController {
	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private UserService userService;

	@PostMapping("/addAdmin")
	public ResposeData<User> addAdmin(@RequestBody UserData userData) {
		ResposeData<User> response = null;
		try {
			response = userService.addAdmin(userData);

		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage("User has been created successfully");
			response.setData(null);
			LOGGER.error("Error in adding Admin object", e);
		}

		return response;

	}
}
