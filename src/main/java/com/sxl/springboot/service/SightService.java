package com.sxl.springboot.service;

import java.util.List;

import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.model.Sight;

public interface SightService {
	BaseModelResult<Integer> addSight(Sight sight);

	BaseModelResult<List<Sight>> getSchoolSight(int schoolId);

	BaseModelResult<List<Sight>> getAllSights();

	int delSight(int sight_id);

	BaseModelResult<Sight> getSight(int sightId);

	BaseModelResult<Integer> editSight(int id,String name, String intro, String fileName);

}
