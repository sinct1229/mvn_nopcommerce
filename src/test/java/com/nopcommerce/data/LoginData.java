package com.nopcommerce.data;

public class LoginData {
	public static class ErrorMessage{
		public static final String EMPTY_EMAIL = "Please enter your email";
		public static final String INVALID_EMAIL = "Wrong email";
		public static final String SUMMARY_ERROR = "Login was unsuccessful. Please correct the errors and try again.";
		public static final String NO_EXISTED_EMAIL = "No customer account found";
		public static final String INVALID_PASSWORD = "The credentials provided are incorrect";
	}
	
	public static class InvalidData{
		public static final String INVALID_EMAIL = "tiki@";
		public static final String NO_EXISTED_EMAIL = "tiki@hmail.com";
		public static final String INVALID_PASSWORD = "tiki@123";
	}

}
