package com.blacklist.dao;

import com.blacklist.model.UserRole;

public interface UserRoleDAO {

	UserRole save(UserRole userRole);

	void delete(UserRole userRole);

	UserRole findByName(String string);

}