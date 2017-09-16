package com.sxl.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.dao.SightRepository;
import com.sxl.springboot.model.Sight;

public class SightServiceImpl implements SightService{
	@Autowired
	private SightRepository dao;

	public BaseModelResult<Integer> addSight(Sight sight) {
		try {
			dao.save(sight);
		}catch(Exception e) {
			
		}
		return null;
	}

	
}
