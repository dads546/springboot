package com.sxl.springboot.controller;

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
	private BaseModelResult<Integer> addSight(@RequestBody Sight sight){
		return sightService.addSight(sight);
	}
}
