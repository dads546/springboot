package com.sxl.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sxl.springboot.model.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {

	@Query("update school set deleted = 1 where school.id = ?1")
	void delSchool(int school_id);


}
