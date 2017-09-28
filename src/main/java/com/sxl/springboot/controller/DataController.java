package com.sxl.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.model.School;
import com.sxl.springboot.model.Sight;
import com.sxl.springboot.service.SchoolService;
import com.sxl.springboot.service.SightService;

@RestController
@SpringBootApplication
@RequestMapping("/data")
public class DataController {
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private SightService sightService;

}
