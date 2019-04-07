package com.multids.example.app.utils;

import java.util.regex.Pattern;

public class ValidationUtils {

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN); 
		if(email==null) {
			return false;
		}
		return pattern.matcher(email).matches();
	}
}
