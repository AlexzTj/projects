package com.blacklist.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="posts")
@NamedQueries({
@NamedQuery(name=Post.FIND_ALL_POSTS,query="Select p from Post p")
})
public class Post {
	
	public static final String FIND_ALL_POSTS = "findAllPosts";
	
	@Id
	@GeneratedValue
	@Column(name="post_id",nullable=false)
	private Long postId;
	
	@Lob
	private String content;
	private String title;
	
	private String company;
	private String companyDescr;
	
	
	@ManyToOne(fetch = FetchType.EAGER )
	private User user;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@OneToMany(mappedBy="post",cascade=CascadeType.REMOVE)
	private List<Comment> comments;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyDescr() {
		return companyDescr;
	}
	public void setCompanyDescr(String companyDescr) {
		this.companyDescr = companyDescr;
	}
	
}
