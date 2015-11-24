package com.blacklist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blacklist.dao.PostDAO;
import com.blacklist.dao.UserDAO;
import com.blacklist.model.Post;
import com.blacklist.model.User;


@Service("postService")
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO postDao;
	
	@Autowired
	private UserDAO userDao;
	
	@Transactional
	public Post save(Post post) {
		System.out.println("service save");
		return postDao.save(post);
	}
	
	@Transactional
	public void delete(Long id) {
		postDao.delete(id);
	}

	public List<Post> findAllPosts() {
		return postDao.findAllPosts();
	}

	public Post findPostById(Long post_id) {
		
		return postDao.findPostById(post_id);
	}
	
	@Transactional
	@Override
	public void save(Post post, String name) {
		User user = userDao.findOne(name);
		post.setUser(user);
		postDao.save(post);
		
	}

	@Override
	@Transactional
	@PreAuthorize("#post.user.userName == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("post") Post post) {
		postDao.delete(post);
	}

}
