package com.sxl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.model.School;
import com.sxl.springboot.service.SchoolService;

@SpringBootApplication
@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolService service;
	
	@RequestMapping("/getSchoolInfo")
	public BaseModelResult<School> getSchool(@RequestBody Integer school_id){		
		return service.getSchoolInfo(school_id);
	}
}
