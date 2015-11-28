package com.blacklist.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.blacklist.model.Post;
import com.blacklist.model.User;
import com.blacklist.service.PostService;
import com.blacklist.service.UserDetailsService;
import com.blacklist.validator.UserValidator;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private PostService postService;
	@ModelAttribute("user")
	public User constructUser(){
		return new User();
	}
	
	
	@RequestMapping(value="/register")
	public String register(){
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user, BindingResult result){
		userValidator.validate(user,result);
		if(result.hasErrors()){
			return "register";
		}
		userDetailsService.save(user);
		return "redirect:/account.html";
	}
	
	@RequestMapping(value = "/account")
	public String account(Model model,Principal principal){
		String name = principal.getName();
		model.addAttribute("user", userDetailsService.findOneWithPosts(name));
		model.addAttribute("post", new Post());
	
		return "account";
	}
	
	
	
}
