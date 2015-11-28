package com.blacklist.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.blacklist.model.Post;

@Component
public class PostValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Post.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "title", "title.empty");
		Post p = (Post)obj;
		if(p.getContent().length()<2){
			e.rejectValue("content","content.short");
		}
	}

}
