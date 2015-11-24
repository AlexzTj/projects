package com.blacklist.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRole {
	
	@Id
	@GeneratedValue
	@Column(name = "role_id")
	private Integer userRoleId;

	@ManyToMany(mappedBy = "userRoles")
	private Set<User> users = new HashSet<>(0);

	private String role;

	public UserRole() {
	}

	public UserRole(Set<User> users, String role) {
		this.users = users;
		this.role = role;
	}

	
	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
