package com.sxl.springboot.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxl.springboot.common.DateUtil;
import com.sxl.springboot.dto.UserComment;
import com.sxl.springboot.model.Comment;
import com.sxl.springboot.service.CommentService;

@SpringBootApplication
@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService service;
	//评论接口
	@RequestMapping("/addComment")
	public int addComment(@RequestBody Comment comment) {
		comment.setCreateTime(DateUtil.DateToStamp(new Date()));
		return service.addComment(comment);
	}
	//显示学校评论接口
	@RequestMapping("/getSchoolComments")
	public List<UserComment> getCommentsOfSchool(@RequestBody Integer school_id){
		return service.getSchoolComments(school_id);
	}
	
	//显示景点评论接口
	@RequestMapping("/getSightComments")
	public List<Comment> getCommentsOfSight(@RequestBody Integer sight_id){
		return service.getSightComments(sight_id);
	}
}
