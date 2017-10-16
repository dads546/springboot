package com.sxl.springboot.dto;

import java.util.Date;

public class UserComment {
	private String username;

	private int level;
	
	private String content;
	
	private Date createTime;

	
	public UserComment(String username, int level, String content, Date createTime) {
		super();
		this.username = username;
		this.level = level;
		this.content = content;
		this.createTime = createTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
