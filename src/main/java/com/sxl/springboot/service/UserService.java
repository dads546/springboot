package com.sxl.springboot.service;

import java.util.List;

import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.model.User;

public interface UserService {

	List<User> listUsers();

	BaseModelResult<User> getUser(Integer id);

	BaseModelResult<Integer> editUser(User user);
	

}
