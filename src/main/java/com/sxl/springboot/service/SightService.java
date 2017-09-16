package com.sxl.springboot.service;

import com.sxl.springboot.common.BaseModelResult;
import com.sxl.springboot.model.Sight;

public interface SightService {
	BaseModelResult<Integer> addSight(Sight sight);

}
