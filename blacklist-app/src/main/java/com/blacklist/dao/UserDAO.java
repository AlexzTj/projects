package com.blacklist.dao;

import com.blacklist.model.User;

public interface UserDAO {

	User save(User user);

	void delete(User user);

	User findOne(String id);

	

}