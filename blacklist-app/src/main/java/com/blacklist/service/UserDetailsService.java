package com.blacklist.service;

import com.blacklist.model.User;

public interface UserDetailsService {
	
	User save(User user);

	void delete(User user);

	User findOneWithPosts(String name);
}
