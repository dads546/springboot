package com.sxl.springboot.dao;

import java.util.List;

import org.springframework.core.annotation.AliasFor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sxl.springboot.dto.UserComment;
import com.sxl.springboot.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	@Query("select new com.sxl.springboot.dto.UserComment(u.username,c.level,c.content,c.createTime) from Comment c ,User u  where c.school_id = ?1 and c.id = u.id")
	List<UserComment> getSchoolComments(int school_id);
	
	@Query("select c from Comment c,User u  where c.sight_id = ?1")
	List<Comment> getSightComments(int sight_id);
}
