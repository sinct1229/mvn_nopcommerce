package com.nopcommerce.data;

public class RegisterData {
	public static class ErrorMessage {
		public static final String FIRSTNAME_ERROR = "First name is required.";
		public static final String LASTNAME_ERROR = "Last name is required.";
		public static final String EMAIL_ERROR = "Email is required.";
		public static final String PASSWORD_ERROR = "Password is required.";
		public static final String C_PASSWORD_ERROR = "Password is required.";
		public static final String INVALID_EMAIL = "Wrong email";
		public static final String EXISTED_EMAIL = "The specified email already exists";
		public static final String INVALID_PASSWORD_1 = "Password must meet the following rules: ";
		public static final String INVALID_PASSWORD_2 = "must have at least 6 characters";
		public static final String PASSWORD_UNMATCH = "The password and confirmation password do not match.";
	}
	
	public static class RegisterSuccess{
		public static final String FIRSTNAME = "Sin";
		public static final String LASTNAME = "Cao";
		public static final String DAY = "29";
		public static final String MONTH = "December";
		public static final String YEAR = "1999";
		public static final String COMPANY = "Tiki";
	}
	
	public static class DataInvalid{
		public static final String INVALID_EMAIL = "123test";
		public static final String INVALID_PASSWORD = "123pa";
		public static final String EXISTED_EMAIL = "sinct1999@gmail.com";
		public static final String OTHER_C_PASSWORD = "tiki@456";
	}
	
	public static class Success{
		public static final String REGISTER_SUCCESS = "Your registration completed";
	}

}
