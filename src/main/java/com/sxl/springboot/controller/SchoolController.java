package com.sxl.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.model.School;
import com.sxl.springboot.service.SchoolService;

@SpringBootApplication
@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolService service;
	
	
	@RequestMapping("/getSchoolAround")
	public List<School> schoolAround(@RequestBody String schoolNames) {
		List<String> school_names = new ArrayList<String>();
		school_names = JSONArray.parseArray(schoolNames, String.class);
		String paramSchool = school_names.toString();
		paramSchool =paramSchool.substring(1, paramSchool.length()-1);
		System.out.println(paramSchool);
		return service.getAroundSchools(school_names);
	}
	
	
	@RequestMapping("/getSchoolList")
	public BaseModelResult<List<School>> schoolList() {
		return service.getAllSchool();
	}
	
	@RequestMapping("/getSchoolInfo")
	public BaseModelResult<School> getSchool(@RequestBody Integer school_id){		
		return service.getSchoolInfo(school_id);
	}
	
	@RequestMapping("/editSchool")
	public int updateSchool(@RequestBody School school) {
		try {
			service.addOrUpdateSchool(school);
		}catch(Exception e) {
			return 0;
		}
		return 1;
	}
	
	@RequestMapping("/delSchool")
	public int delSchool(int school_id) {
		return service.delSchool(school_id);
	}
}
