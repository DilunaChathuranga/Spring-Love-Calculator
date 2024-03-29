package com.diluna.lc.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.diluna.lc.api.UserRegistrationDTO;

public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Check empty
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "CommunicationDTO.email", "email.empty","eeeeeeee");

		//check format
		String email=((UserRegistrationDTO) target).getCommunicationDTO().getEmail();
		
		if (!email.endsWith(".com")) {
			errors.rejectValue("CommunicationDTO.email", "email.invalidDomain","errrrrr");
			
		}
	}

}
