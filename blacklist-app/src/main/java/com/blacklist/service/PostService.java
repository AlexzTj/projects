package com.blacklist.service;

import java.util.List;

import com.blacklist.model.Post;


public interface PostService {
	
	Post save(Post post);

	void delete(Long post_id);
	
	List<Post> findAllPosts();

	Post findPostById(Long post_id);

	void save(Post post, String name);

	void delete(Post post);
}
