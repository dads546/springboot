package com.sxl.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sxl.springboot.model.Sight;

public interface SightRepository extends JpaRepository<Sight, Integer> {

	@Query("update sight set deleted = 1 where sight.id =  ?1")
	void delSight(int sight_id);

}
