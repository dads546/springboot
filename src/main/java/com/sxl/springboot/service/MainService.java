package com.sxl.springboot.service;

import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.model.User;

public interface MainService {
	public BaseModelResult<User> login(String username,String password);
}
