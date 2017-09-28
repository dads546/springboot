package com.sxl.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.model.Sight;
import com.sxl.springboot.service.SightService;

@SpringBootApplication
@RestController
@RequestMapping("/sight")
public class SightController {

	@Autowired
	private SightService sightService;
	
	@RequestMapping("/addSight")
	private BaseModelResult<Integer> addSight(@RequestBody Sight sight){
		return sightService.addSight(sight);
	}
	
	@RequestMapping("/getSight")
	public BaseModelResult<List<Sight>> getSightOfSchool(int schoolId){		
		return sightService.getSchoolSight(schoolId);
	}
	
	@RequestMapping("/getAllSight")
	public BaseModelResult<List<Sight>> getAllSightOf(){		
		return sightService.getAllSights();
	}
	
	@RequestMapping("/delSight")
	public int delSchool(int sight_id) {
		return sightService.delSight(sight_id);
	}
}
