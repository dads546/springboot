package com.sxl.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@SuppressWarnings("serial")
public class School implements Serializable {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		@Column
		private String name;
		
		@Column
		private String intro;
		
		@Column
		private String urls;
		
		@Column
		private String address;
		
		@Column
		private String area;
		
		@Column(columnDefinition="tinyint default 0")
		private int level = 0;
		
		@Column
		private String poi;
		
		@Column(columnDefinition="tinyint default 0")
		private double radius = 0;

		
		public School() {
			super();
		}
		public School(int id,String poi,double radius) {
			this.id = id;
			this.poi = poi;
			this.radius = radius;
		}
		
		
		public School(String name, String intro, String urls, String address, String area, int level) {
			super();
			this.name = name;
			this.intro = intro;
			this.urls = urls;
			this.address = address;
			this.area = area;
			this.level = level;
		}
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public String getPoi() {
			return poi;
		}

		public void setPoi(String poi) {
			this.poi = poi;
		}

		public double getRadius() {
			return radius;
		}

		public void setRadius(double radius) {
			this.radius = radius;
		}
		public String getIntro() {
			return intro;
		}
		public void setIntro(String intro) {
			this.intro = intro;
		}
		public String getUrls() {
			return urls;
		}
		public void setUrls(String urls) {
			this.urls = urls;
		}
		
				
}
