package com.diluna.lc.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<CustomAgeValidator, Integer>{

	private int lower;
	private int upper;
	
	//we wrote our custom Validator here
	@Override
	public void initialize(CustomAgeValidator customAgeValidator) {
		//Here we overide Default values for Custom validator
		//I can write post construct work here
		this.lower=customAgeValidator.lower();
		this.upper=customAgeValidator.upper();
		}
	
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		//We can write the custom logic here
		if(age ==null) {
			return false;
			}
		if(age <lower || age>upper) {
			return false;
		}
		
		return true;
	}

}
