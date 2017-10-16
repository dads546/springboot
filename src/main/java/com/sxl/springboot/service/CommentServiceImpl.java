package com.sxl.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.springboot.dao.CommentRepository;
import com.sxl.springboot.dto.UserComment;
import com.sxl.springboot.model.Comment;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository dao;
	public int addComment(Comment comment) {
		try {
			dao.save(comment);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	public List<UserComment> getSchoolComments(int school_id) {
		// TODO Auto-generated method stub
		return dao.getSchoolComments(school_id);
	}
	
	public List<Comment> getSightComments(int sight_id) {
		return dao.getSightComments(sight_id);
	}
}
