package com.blacklist.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.blacklist.model.Comment;

@Repository("commentDAO")
public class CommentDAOImpl implements CommentDAO {
	
	@PersistenceContext
	private EntityManager em;

	public Comment save(Comment comment) {
		if(comment==null){
			em.persist(comment);
			em.flush();
		}else{
			em.merge(comment);
		}
		
		return comment;
	}

	public void delete(Comment comment) {
		em.remove(comment);
		
	}


	
}
