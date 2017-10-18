package com.sxl.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sxl.springboot.model.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {

	@Transactional
	@Modifying
	@Query("update School s set deleted = 1 where s.id = ?1")
	void delSchool(int school_id);

	
	List<School> findByNameIn(List<String> school_names);

	@Query("select new com.sxl.springboot.model.School(s.name,s.intro,s.urls,s.address,s.area,s.level) from School s where s.id = ?1")
	School findSchoolById(Integer school_id);


}
