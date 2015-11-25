package com.blacklist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.blacklist.model.Post;
import com.blacklist.model.User;

@Repository("postDAO")
public class PostDAOImpl implements PostDAO {

	@PersistenceContext
	private EntityManager em;

	public Post save(Post post) {
		em.persist(post);
		em.flush();
		return post;
	}
	public Post update(Post post) {
		em.merge(post);
		return post;
	}

	public void delete(Post post) {
		em.remove(em.contains(post) ? post : em.merge(post));
	}
	public void delete(Long id) {
		Post post = em.find(Post.class, id);
		delete(post);
	}

	public List<Post> findAllPosts() {
		TypedQuery<Post> query = em.createNamedQuery(Post.FIND_ALL_POSTS, Post.class);
		return query.getResultList();
	}

	public Post findPostById(Long post_id) {
		Post post = (Post)em.find(Post.class, post_id);
		return post;
	}
	
	@Override
	public List<Post> findByUser(User user) {
		TypedQuery<Post> query = em.createQuery("select p from Post p where p.user = :user ", Post.class);
		
		return query.setParameter("user", user).getResultList();
	}

	
}
