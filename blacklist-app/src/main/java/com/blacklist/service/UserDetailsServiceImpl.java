package com.blacklist.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blacklist.dao.PostDAO;
import com.blacklist.dao.UserDAO;
import com.blacklist.dao.UserRoleDAO;
import com.blacklist.model.Post;
import com.blacklist.model.User;
import com.blacklist.model.UserRole;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private PostDAO postDao;
	
	@Autowired
	private UserRoleDAO userRoleDao;
	
	@Transactional
	public User save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
				
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(userRoleDao.findByName("ROLE_USER"));
		user.setUserRole(userRoles);
		return userDao.save(user);
	}
	
	@Transactional
	public void delete(User user) {
		
		userDao.delete(user);
	}

	@Transactional
	public User findOneWithPosts(String name) {
		
		User user = findOne(name);
		List<Post> posts = postDao.findByUser(user);
		user.setPosts(posts);
		return user;
	}
	
	@Transactional
	public User findOne(String id) {
		return userDao.findOne(id);
	}

}
