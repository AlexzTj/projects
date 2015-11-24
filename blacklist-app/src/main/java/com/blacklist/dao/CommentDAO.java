package com.blacklist.dao;

import com.blacklist.model.Comment;

public interface CommentDAO {

	Comment save(Comment comment);

	void delete(Comment comment);

}