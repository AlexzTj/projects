package com.blacklist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blacklist.model.Post;
import com.blacklist.service.PostService;

@Controller
public class HomeController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String getPosts(Model model) {
		List<Post> posts = postService.findAllPosts();
		model.addAttribute("getAllPosts",posts);
		return "home";
	}
}
