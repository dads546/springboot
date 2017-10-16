package com.sxl.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
