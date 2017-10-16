package com.sxl.springboot.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static Timestamp DateToStamp(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		return Timestamp.valueOf(sdf.format(date));
	}

}
