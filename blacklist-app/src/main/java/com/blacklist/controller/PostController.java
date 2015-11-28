package com.blacklist.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blacklist.model.Post;
import com.blacklist.service.PostService;
import com.blacklist.validator.PostValidator;

@Controller
@SessionAttributes("post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private PostValidator postValidator;
	
	@ModelAttribute("post")
	public Post constructPost(){
		return new Post();
	}
	
	@RequestMapping(value = "/posts/{post_id}", method = RequestMethod.GET)
	public String detail(@PathVariable Long post_id, Model model) {
		Post post=postService.findPostById(post_id);
		model.addAttribute("post", post);
		return "post-detail";
	}
	@RequestMapping(value = "/posts",method=RequestMethod.GET)
	public String getPosts(){
		return "redirect:/account.html";
	}
	@RequestMapping(value = "/posts",method=RequestMethod.POST)
	public String doAddPost(@ModelAttribute("post") Post post,Principal principal,
			BindingResult result,SessionStatus sessionStatus,final RedirectAttributes redirectAttributes ){
		String name = principal.getName();
		postValidator.validate(post,result);
		if(result.hasErrors()){
			return "account";
		}
		postService.save(post,name);
		redirectAttributes.addFlashAttribute("message","Added successfully.");
		sessionStatus.setComplete(); 
		return "redirect:/account.html";
	}
	@RequestMapping(value="/posts/remove/{post_id}",method = RequestMethod.GET)
	public String remove(@PathVariable Long post_id, final RedirectAttributes redirectAttributes){
		Post post = postService.findPostById(post_id);
		postService.delete(post);
		redirectAttributes.addFlashAttribute("message","Removed successfully.");
		return "redirect:/account.html";
	}
	
	@RequestMapping(value="/posts/edit/{post_id}",method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable Long post_id,Model model){
		Post post=postService.findPostById(post_id);
		
		return new ModelAndView("post-edit","post", post);
	}
	
	@RequestMapping(value="/posts/edit/{post_id}",method = RequestMethod.POST)
	public String editPost(@ModelAttribute Post post, BindingResult result,SessionStatus sessionStatus, final RedirectAttributes redirectAttributes){
		postValidator.validate(post, result);
		if(result.hasErrors()){
			return "post-edit";
		}else{
			postService.update(post);
		}
		redirectAttributes.addFlashAttribute("message","Edited successfully.");
		sessionStatus.setComplete();
		return "redirect:/account.html";
	}
}
