package com.blacklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.blacklist.model.Post;
import com.blacklist.service.PostService;

@Controller
@SessionAttributes("post")
public class PostController {

	@Autowired
	private PostService postService;

	@RequestMapping(value = "/posts/{post_id}", method = RequestMethod.GET)
	public String detail(@PathVariable Long post_id, Model model) {
		Post post=postService.findPostById(post_id);
		model.addAttribute("post", post);
		return "post-detail";
	}
	
	@RequestMapping(value="/posts/remove/{post_id}",method = RequestMethod.GET)
	public String remove(@PathVariable Long post_id){
		Post post = postService.findPostById(post_id);
		postService.delete(post);
		return "redirect:/account.html";
	}
	
	@RequestMapping(value="/posts/edit/{post_id}",method = RequestMethod.GET)
	public String edit(){
		return "post-edit";
	}
}