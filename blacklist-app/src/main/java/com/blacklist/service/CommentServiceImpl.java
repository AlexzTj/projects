package com.blacklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blacklist.dao.CommentDAO;
import com.blacklist.model.Comment;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDAO commentDao;
	
	@Transactional
	public Comment save(Comment comment) {
		return commentDao.save(comment);
	}
	
	@Transactional
	public void delete(Comment comment) {
		commentDao.delete(comment);
	}

}
