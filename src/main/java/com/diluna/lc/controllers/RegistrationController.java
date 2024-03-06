package com.diluna.lc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diluna.lc.Validator.EmailValidator;
import com.diluna.lc.Validator.UserNameValidator;
import com.diluna.lc.api.CommunicationDTO;
import com.diluna.lc.api.Phone;
import com.diluna.lc.api.UserRegistrationDTO;
import com.diluna.lc.propertyEditor.NamePropertyEditor;

@Controller
public class RegistrationController {

	@RequestMapping("/register")
	public String Registration(@ModelAttribute("UserReg") UserRegistrationDTO dto) {
		// @ModelAttribute("UserReg") UserRegistrationDTO dto ->> Spring create
		// objectUserRegistrationDTO dto
		// and send that object to "register-page"

		// 2 ->> We can Set default value here
		//We can Use DB to fetch those data without hardcoding using spring JDBC
		Phone phone=new Phone();
		phone.setUserNumber("091");
		phone.setUserNumber("2276981");
		
		CommunicationDTO communicationDTO=new CommunicationDTO();
		communicationDTO.setPhone(phone);
		
		dto.setCommunicationDTO(communicationDTO);
		
		return "register-page";
	}

	@RequestMapping("/register-success")
	public String processRegistration(@Valid @ModelAttribute("UserReg") UserRegistrationDTO dto,BindingResult result) {
		
		//Another way to register Validatior(We can do this using @Autowire concept without creating Object by ourself)
		//EmailValidator ev=new EmailValidator();
		//ev.validate(dto, result);
		
		if (result.hasErrors()) {
			System.out.println("My page has errors");
			List<ObjectError> allErrors=result.getAllErrors();
			for(ObjectError error:allErrors) {
				System.out.println(error);
			}
			return "register-page";
		}
		
			return "register-process";
		
	}
	
	
	//This method is used to control the property binding
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//Data binding dosen't happen for given field
		//binder.setDisallowedFields("password");
		
		//StringTrimmerEditor Convert White spaces to Null
		StringTrimmerEditor editor=new StringTrimmerEditor(true); //if true -> return null,false -> trim the white spaces and return null
		binder.registerCustomEditor(String.class,"name",editor);
		System.out.println("Inside InitBinder");
		
		
		//Custom Binder for Take registration name in All Uppercase
		NamePropertyEditor npe=new NamePropertyEditor();
		binder.registerCustomEditor(String.class, "name",npe);
		
		//Register Username Validator
		UserNameValidator usernamevalidator=new UserNameValidator();
		binder.addValidators(usernamevalidator);
		
		//Register email validator
		//EmailValidator emailvalidator=new EmailValidator();
		//binder.addValidators(emailvalidator);
		
		//above same thing we can do the in one line
		binder.addValidators(new EmailValidator());
		
	} 

}
