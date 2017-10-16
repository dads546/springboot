package com.sxl.springboot.service;

import java.util.List;

import com.sxl.springboot.model.News;

public interface newsService {

	List<News> getSchoolNews(int school_id);

}
