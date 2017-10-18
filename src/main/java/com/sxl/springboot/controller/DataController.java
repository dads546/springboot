package com.sxl.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.model.School;
import com.sxl.springboot.model.Sight;
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
	
	@RequestMapping("/getUserById")
	@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
	public BaseModelResult<User> getUserById(Integer id){
		return userService.getUser(id);
	}
	
	@RequestMapping("/listSchool")
	public BaseModelResult<List<School>> listSchool(){
		return schoolService.getAllSchool();
	}

	@RequestMapping("/getSchoolById")
	public BaseModelResult<School> getSchoolById(Integer id){
		return schoolService.getSchoolInfo(id);
	}
	
	@RequestMapping("/editUser")
	public BaseModelResult<Integer> editUser(User user){
		return userService.editUser(user);
	}
	
	@RequestMapping("/editSchool")
	public BaseModelResult<Integer> editSchool(@RequestBody School school){
		return schoolService.editSchool(school);
	}
	
	@RequestMapping("/getSchoolSights")
	public BaseModelResult<List<Sight>> getSightOfSchool(int schoolId){		
		return sightService.getSchoolSight(schoolId);
	}
}
