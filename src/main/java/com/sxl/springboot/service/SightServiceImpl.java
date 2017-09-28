package com.sxl.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.springboot.Enum.ErrorCode;
import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.dao.SightRepository;
import com.sxl.springboot.model.Sight;

@Service
public class SightServiceImpl implements SightService{
	@Autowired
	private SightRepository dao;

	public BaseModelResult<Integer> addSight(Sight sight) {
		BaseModelResult<Integer> result = new BaseModelResult<Integer>();
		try {
			dao.save(sight);
		}catch(Exception e) {
			result.setErrorCode(ErrorCode.FAILED);
			return result;
		}
		result.setData(1);
		return result;
	}

	public BaseModelResult<List<Sight>> getSchoolSight(int schoolId) {
		BaseModelResult<List<Sight>> result = new BaseModelResult<List<Sight>>();
		result.setData(dao.findAll());
		return result;
	}

	public BaseModelResult<List<Sight>> getAllSights() {
		BaseModelResult<List<Sight>> result = new BaseModelResult<List<Sight>>();
		try {
			result.setData(dao.findAll());
		}catch(Exception e) {
			result.setErrorCode(ErrorCode.FAILED);
		}
		return result;
	}

	public int delSight(int sight_id) {
		try {
			dao.delSight(sight_id);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}	
}
