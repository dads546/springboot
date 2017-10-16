package com.sxl.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sxl.springboot.model.Sight;

public interface SightRepository extends JpaRepository<Sight, Integer> {

	@Query("update Sight s set deleted = 1 where s.id =  ?1")
	void delSight(int sight_id);

	
	@Query("select s from Sight s where school_id = ?1")
	List<Sight> findSightBySchool(int schoolId);

}
