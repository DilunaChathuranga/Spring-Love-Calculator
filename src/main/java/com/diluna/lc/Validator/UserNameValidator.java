package com.diluna.lc.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.diluna.lc.api.UserRegistrationDTO;

public class UserNameValidator implements Validator {

	//check the given validator is support for given Object(DTO)
	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationDTO.class.equals(clazz);
	}

	//We need to write custom validation Logic
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("Inside Username validator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty","User name can't be Empty");
		System.out.println("Check user name is empty");
		
		//Write own logic to check _(underscore)
		//Object is a super class in java. so can store any type class in java. That's why we can type cast here
		String username=((UserRegistrationDTO)target).getUsername();
		if(!username.contains("_")){
			errors.rejectValue("username","username.invalid", "Username must contain _");
		}
		System.out.println("Check user name Contain _");
	}

}
