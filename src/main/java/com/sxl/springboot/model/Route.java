package com.sxl.springboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class Route implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private int u_id;
	
	@Column
	private Date create_time;
	
	@Column
	private String pois;

	
	public Route() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getPois() {
		return pois;
	}

	public void setPois(String pois) {
		this.pois = pois;
	}
}
