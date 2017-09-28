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
		
		@Column
		private int level;
		
		@Column
		private String poi;
		
		@Column
		private double radius;

		
		public School(int id,String poi,double radius) {
			this.id = id;
			this.poi = poi;
			this.radius = radius;
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
				
}
