package com.blacklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blacklist.dao.UserRoleDAO;
import com.blacklist.model.UserRole;


@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	UserRoleDAO userRoleDao;
	
	@Transactional
	public UserRole save(UserRole userRole){

		return userRoleDao.save(userRole);
	}
}
