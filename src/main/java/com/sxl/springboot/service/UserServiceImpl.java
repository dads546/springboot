package com.sxl.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.dao.UserRepository;
import com.sxl.springboot.model.User;
@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository dao;
	
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public BaseModelResult<User> getUser(Integer id) {
		BaseModelResult<User> result = new BaseModelResult<User>();
		result.setData(dao.findOne(id));
		System.out.println(dao.findOne(id).getUsername());
		return result;
	}

	public BaseModelResult<Integer> editUser(User user) {
		BaseModelResult<Integer> result = new BaseModelResult<Integer>();
		try{
			dao.saveAndFlush(user);
			result.setData(1);
		}catch(Exception e) {
			result.setData(0);
		}
		
		return result;
	}

}
