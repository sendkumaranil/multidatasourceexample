package com.multids.example.app.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.multids.example.app.utils.ValidationUtils;


public class EmailValidator implements ConstraintValidator<Email, String> {

	@Override
	public boolean isValid(String email, ConstraintValidatorContext validator) {
		
		if(ValidationUtils.isValidEmail(email)) {
			return true;
		}
		return false;
	}

}
