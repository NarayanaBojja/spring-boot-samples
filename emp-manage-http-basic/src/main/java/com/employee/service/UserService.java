package com.employee.service;

import com.employee.modal.ResposeData;
import com.employee.modal.User;
import com.employee.modal.UserData;

public interface UserService {

	public ResposeData<User> addAdmin(UserData userData);

}
