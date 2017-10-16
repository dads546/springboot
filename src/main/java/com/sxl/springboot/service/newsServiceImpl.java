package com.sxl.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.springboot.dao.NewsRepository;
import com.sxl.springboot.model.News;

@Service
public class newsServiceImpl implements newsService{
	@Autowired
	private NewsRepository dao;

	public List<News> getSchoolNews(int school_id) {
		// TODO Auto-generated method stub
		return dao.getSChoolNews(school_id);
	}

}
