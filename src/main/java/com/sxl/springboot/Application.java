package com.sxl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

import com.sxl.springboot.controller.MainController;

@SpringBootApplication
@Configuration
public class Application extends SpringBootServletInitializer
{

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}