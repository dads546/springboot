package com.sxl.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sxl.springboot.model.News;

public interface NewsRepository extends JpaRepository<News,Integer>{

	@Query("select n from News n where school_id = ?1")
	List<News> getSChoolNews(int school_id);

}
