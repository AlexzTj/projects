package com.blacklist.dao;

import java.util.List;
import java.util.Set;

import com.blacklist.model.Post;
import com.blacklist.model.User;


public interface PostDAO {

	Post save(Post post);
	Post update(Post post);

	void delete(Long id);
	
	void delete(Post post);
	
	List<Post> findAllPosts();

	Post findPostById(Long post_id);

	List<Post> findByUser(User user);

}