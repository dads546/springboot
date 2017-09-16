package com.sxl.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxl.springboot.model.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {


}
