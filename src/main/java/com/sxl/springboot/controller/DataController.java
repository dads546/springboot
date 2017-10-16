package com.sxl.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.model.User;
import com.sxl.springboot.service.SchoolService;
import com.sxl.springboot.service.SightService;
import com.sxl.springboot.service.UserService;

@RestController
@SpringBootApplication
@RequestMapping("/data")
public class DataController {
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SightService sightService;
	
	@RequestMapping("/listUser")
	public BaseModelResult<List<User>> listUser(){
		BaseModelResult<List<User>> result = new BaseModelResult<List<User>>();
		result.setData(userService.listUsers());
		return result;
	}

}
