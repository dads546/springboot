package com.sxl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxl.springboot.model.User;
import com.sxl.springboot.service.MainService;

@RestController
@SpringBootApplication
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private MainService service;
	@RequestMapping("/login")
	public User hello(String username,String password) {
		return service.login(username,password);
	}
}
