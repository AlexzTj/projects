package com.blacklist.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.blacklist.dao.PostDAO;
import com.blacklist.dao.UserDAO;
import com.blacklist.dao.UserRoleDAO;
import com.blacklist.model.Post;
import com.blacklist.model.User;
import com.blacklist.model.UserRole;

@Service
public class InitDbService {
	@Autowired
	private UserDAO userDao;	
	@Autowired
	private UserRoleDAO userRoleDao;
	@Autowired
	private PostDAO postDao;
	
	 @Autowired
	    @Qualifier("transactionManager")
	    protected PlatformTransactionManager txManager;

	    @PostConstruct
	    private void init(){
	        TransactionTemplate tmpl = new TransactionTemplate(txManager);
	        tmpl.execute(new TransactionCallbackWithoutResult() {
	            @Override
	            protected void doInTransactionWithoutResult(TransactionStatus status) {
	            	
	            	//INIT ADMIN USER
	        		UserRole adminRole=new UserRole();
	        		adminRole.setRole("ROLE_ADMIN");
	        		userRoleDao.save(adminRole);
	        		
	        		UserRole userRole=new UserRole();
	        		userRole.setRole("ROLE_USER");
	        		userRoleDao.save(userRole);
	        		
	        		Set<UserRole> userRoles = new HashSet<>();
	        		userRoles.add(adminRole);
	        		userRoles.add(userRole);
	        		
	        		
	        		
	        		
	        		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        		User admin=new User("admin",encoder.encode("admin"),userRoles);	
	        		admin.setEnabled(true);
	        		
	        		userDao.save(admin);
	        			        		
	        		Post post = new Post();
	        		post.setTitle("title");
	        		post.setContent("content");
	        		post.setUser(admin);
	        		postDao.save(post);
	        		
	        		Post post1 = new Post();
	        		post1.setTitle("title");
	        		post1.setContent("content");
	        		post1.setUser(admin);
	        		postDao.save(post1);
	        		
	        		System.out.println("saved!!");
	            }
	        });
	   }
	    


		

}
