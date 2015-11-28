package com.blacklist.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Id
	@Column(name = "username", nullable = false,  length = 45)

	private String userName;
	
	@Column(nullable = false)
	
	private String password;

    @Transient
	private String confirmPassword;
	
	@ManyToMany
	@JoinTable(name="User_Role", 
    joinColumns=@JoinColumn(name="username"),
    inverseJoinColumns=@JoinColumn(name="role_id")) 
	private Set<UserRole> userRoles=new HashSet<UserRole>(0);
	
	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
	private List<Post> posts;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
	private List<Comment> comments ;
	
	private boolean enabled;

	

	public User() {}
	
	public User(String username, String password) {
		this.userName = username;
		this.password = password;
	}
	public User(String username, String password, Set<UserRole> userRole) {
		this.userName = username;
		this.password = password;
		this.userRoles = userRole;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public String getUsername() {
		return userName;
	}
	
	
	public Set<UserRole> getUserRole() {
		return userRoles;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	
	public void setUserRole(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
