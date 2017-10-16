package com.sxl.springboot.common;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sxl.springboot.model.School;

public class AreaHelper {
	private static double EARTH_RADIUS = 6378.137;//地球半径
	private static double rad(double d)
	{
		return d * Math.PI / 180.0;
	}
	
	
	
	//根据两点的经纬度计算两点之前的距离
	public static double GetDistance(double lat1, double lng1, double lat2, double lng2)
	{
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
		Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}
	
	public boolean isInSchool(String poi,List<School> schools) {
		String[] pois = poi.split(",");
		double lat1 = Double.parseDouble(pois[0]);
		double lng1 = Double.parseDouble(pois[1]);
		for(School school:schools) {
			double radius = school.getRadius();
			String[] spois = school.getPoi().split(",");
			double lat2 = Double.parseDouble(spois[0]);
			double lng2 = Double.parseDouble(spois[1]);
			if(GetDistance(lat1, lng1, lat2, lng2)<=radius) {
				return true;
			}
			
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
