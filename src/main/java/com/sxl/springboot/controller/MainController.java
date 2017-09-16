package com.sxl.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.model.School;
import com.sxl.springboot.model.User;
import com.sxl.springboot.service.MainService;
import com.sxl.springboot.service.SchoolService;

@RestController
@SpringBootApplication
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private MainService mainService;
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping("/login")
	public BaseModelResult<User> goLogin(@RequestBody String username,String password) {		
		return mainService.login(username, password);
	}
	
	@RequestMapping("/index")
	public BaseModelResult<List<School>> index(){
		
		return schoolService.getAllSchool();
	}
	
}
