package com.sxl.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.springboot.dao.UserRepository;
import com.sxl.springboot.model.User;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private UserRepository dao;
	public User login(String username,String password) {
		// TODO Auto-generated method stub
		return dao.findByUsernameAndPassword(username, password);
	}
}
