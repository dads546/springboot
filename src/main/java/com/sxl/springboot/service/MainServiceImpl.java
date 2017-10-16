package com.sxl.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.springboot.Enum.ErrorCode;
import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.dao.UserRepository;
import com.sxl.springboot.model.User;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private UserRepository dao;
	
	public BaseModelResult<User> login(String username,String password) {
		BaseModelResult<User>  result = new BaseModelResult<User>();
		User user = dao.findByUsernameAndPassword(username, password);
		if(user == null) {
			result.setErrorCode(ErrorCode.ERRORUSERINFO);
		}else {
			result.setData(user);
			result.setErrorCode(ErrorCode.SUCCESS);
		}
		return result;
	}
}
