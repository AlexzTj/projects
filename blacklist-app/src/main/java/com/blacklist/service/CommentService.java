package com.blacklist.service;

import com.blacklist.model.Comment;

public interface CommentService {
	
	Comment save(Comment comment);

	void delete(Comment comment);
}
