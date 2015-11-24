package com.blacklist.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.blacklist.model.UserRole;

@Repository("userRoleDAO")
public class UserRoleDaoImpl implements UserRoleDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public UserRole save(UserRole userRole){
		System.out.println("dao save");
			em.persist(userRole);
			em.flush();
		return userRole;
	}
	
	@Override
	public void delete(UserRole userRole){
		em.remove(userRole);
	}


	@Override
	public UserRole findByName(String roleName) {
		TypedQuery<UserRole> query = em.createQuery("select r from UserRole r where r.role = :role", UserRole.class);
		return query.setParameter("role", roleName).getSingleResult();
	}
}
