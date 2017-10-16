package com.sxl.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxl.springboot.model.News;
import com.sxl.springboot.service.newsService;

@RestController
@SpringBootApplication
@RequestMapping("/news")
public class newsController {

	@Autowired
	private newsService service;
	
	
	@RequestMapping("/getSchoolNews")
	public List<News> getSchoolNews(@RequestBody Integer school_id){
		return service.getSchoolNews(school_id);	
	}
}
