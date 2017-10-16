package com.sxl.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.springboot.Enum.ErrorCode;
import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.dao.SchoolRepository;
import com.sxl.springboot.model.School;

@Service
public class SchoolServiceImpl implements SchoolService{

	@Autowired
	private SchoolRepository dao;
	public BaseModelResult<School> getSchoolInfo(Integer school_id) {
		BaseModelResult<School> result = new BaseModelResult<School>();
		School school = dao.findOne(school_id);
		if(school == null) {
			result.setErrorCode(ErrorCode.NOSUCHSCHOOL);
		}else {
			result.setData(school);
			result.setErrorCode(ErrorCode.SUCCESS);
		}
		// TODO Auto-generated method stub
		return result;
	}
	public BaseModelResult<List<School>> getAllSchool() {
		BaseModelResult<List<School>> result = new BaseModelResult<List<School>>();
		result.setData(dao.findAll());
		return result;
	}

	public School addOrUpdateSchool(School school) {
		return dao.save(school);
	}
	
	public int delSchool(int school_id) {
		try {
			dao.delSchool(school_id);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	public List<School> getAroundSchools(List<String> school_names) {
		// TODO Auto-generated method stub
		return dao.findByNameIn(school_names);
	}	
	
}
