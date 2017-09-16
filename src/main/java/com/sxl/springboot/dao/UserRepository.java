package com.sxl.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxl.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsernameAndPassword(String username,String password);	
}
