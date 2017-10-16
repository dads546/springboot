package com.sxl.springboot.service;

import java.util.List;

import com.sxl.springboot.dto.UserComment;
import com.sxl.springboot.model.Comment;

public interface CommentService{
		int addComment(Comment comment);

		List<UserComment> getSchoolComments(int school_id);
		
		List<Comment> getSightComments(int sight_id);
}
