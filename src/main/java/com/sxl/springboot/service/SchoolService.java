package com.sxl.springboot.service;

import java.util.List;

import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.model.School;

public interface SchoolService {

	BaseModelResult<School> getSchoolInfo(Integer school_id);

	BaseModelResult<List<School>> getAllSchool();
	
	School addOrUpdateSchool(School school);

	int delSchool(int school_id);

	List<School> getAroundSchools(List<String> school_names);

}
