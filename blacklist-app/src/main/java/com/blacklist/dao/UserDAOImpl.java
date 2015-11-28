package com.blacklist.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.blacklist.model.User;


@Repository("userDao")
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager em;

	public User save(User user){
		em.persist(user);
		em.flush();
		return user;
	}
	

	public void delete(User user){
		em.remove(user);
	}


	@Override
	public User findOne(String id) {
		try{
			TypedQuery<User> query = em.createQuery("select u from User u where u.userName = :username", User.class);
			
			return query.setParameter("username", id).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}



}
