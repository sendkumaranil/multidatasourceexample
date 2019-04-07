package com.multids.example.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.multids.example.app.config.DataSourceProperties;


public class DataSourcePropertyValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == DataSourceProperties.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "host", "host.empty","database host cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "username", "username.empty","username cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.empty","password cannot be empty");
		
		//DataSourceProperties dp=(DataSourceProperties)target;
		
	}

}
