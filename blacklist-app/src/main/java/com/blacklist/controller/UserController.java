package com.blacklist.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.blacklist.model.Post;
import com.blacklist.model.User;
import com.blacklist.service.PostService;
import com.blacklist.service.UserDetailsService;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PostService postService;
	@ModelAttribute("user")
	public User constructUser(){
		return new User();
	}
	
	@ModelAttribute("post")
	public Post constructPost(){
		return new Post();
	}
	
	@RequestMapping(value = "addUser", method = RequestMethod.GET)
	public String dUser() {
		return "addUser";
	}

	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user) {
		

		userDetailsService.save(user);
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value="/register")
	public String register(){
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user){
		
		userDetailsService.save(user);
		return "redirect:/register.html?success=true";
	}
	
	@RequestMapping(value = "/account")
	public String account(Model model,Principal principal){
		String name = principal.getName();
		model.addAttribute("user", userDetailsService.findOneWithPosts(name));
		return "account";
	}
	
	@RequestMapping(value = "/account",method=RequestMethod.POST)
	public String doAddPost(@ModelAttribute("post") Post post,Principal principal){
		String name = principal.getName();
		postService.save(post,name);
		return "redirect:/account.html";
	}
	
}
