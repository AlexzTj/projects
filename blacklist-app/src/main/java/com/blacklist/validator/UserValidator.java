package com.blacklist.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blacklist.model.User;
import com.blacklist.service.UserDetailsService;

@Component
public class UserValidator implements Validator {
	@Autowired
	private UserDetailsService userService;
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		User user = (User)obj;
		if(user.getUsername().length()<4){
			e.reject("userName", "username.short");
		}
		User userInDb = userService.findOne(user.getUsername());
		if(userInDb!=null){
			e.rejectValue("userName", "user.already.exists");return;
		}
		if(!user.getPassword().equals(user.getConfirmPassword())){
			e.rejectValue("confirmPassword", "password.mismatch");
		}
	}

}
