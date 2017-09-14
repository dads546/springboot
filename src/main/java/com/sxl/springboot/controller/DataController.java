package com.sxl.springboot.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxl.springboot.model.User;

@RestController
@SpringBootApplication
@RequestMapping("/data")
public class DataController {
	
	@RequestMapping("/")
	public String hello() {
		return "test";
	}
}
