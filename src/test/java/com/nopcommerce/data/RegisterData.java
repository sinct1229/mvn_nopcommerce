package com.nopcommerce.data;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class RegisterData {
	public static RegisterData getRegisterData() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(
				new File(GlobalConstants.PROJECT_PATH + "\\src\\test\\java\\com\\nopcommerce\\data\\Register.json"),
				RegisterData.class);
	}
	
	@JsonProperty("firstNameErrorMessage")
	String   firstNameErrorMessage;
	
	@JsonProperty("lastNameErrorMessage")
	String   lastNameErrorMessage;
	
	@JsonProperty("emailErrorMessage")
	String   emailErrorMessage;
	
	@JsonProperty("passwordErrorMessage")
	String   passwordErrorMessage;
	
	@JsonProperty("confirmPasswordErrorMessage")
	String   confirmPasswordErrorMessage;
	
	@JsonProperty("invalidEmailMessage")
	String   invalidEmailMessage;
	
	@JsonProperty("existedEmailMessage")
	String   existedEmailMessage;
	
	@JsonProperty("invalidPasswordMessage_1")
	String   invalidPasswordMessage_1;
	
	@JsonProperty("invalidPasswordMessage_2")
	String   invalidPasswordMessage_2;
	
	@JsonProperty("passwordUnmatchError")
	String   passwordUnmatchError;
	
	@JsonProperty("invalidEmail")
	String   invalidEmail;
	
	@JsonProperty("invalidPassword")
	String   invalidPassword;
	
	@JsonProperty("existedEmail")
	String   existedEmail;
	
	@JsonProperty("otherConfirmPassword")
	String   otherConfirmPassword;
	
	@JsonProperty("registerSuccess")
	String   registerSuccess;

	public String getFirstNameErrorMessage() {
		return firstNameErrorMessage;
	}

	public String getLastNameErrorMessage() {
		return lastNameErrorMessage;
	}

	public String getEmailErrorMessage() {
		return emailErrorMessage;
	}

	public String getPasswordErrorMessage() {
		return passwordErrorMessage;
	}

	public String getConfirmPasswordErrorMessage() {
		return confirmPasswordErrorMessage;
	}

	public String getInvalidEmailMessage() {
		return invalidEmailMessage;
	}

	public String getExistedEmailMessage() {
		return existedEmailMessage;
	}

	public String getInvalidPasswordMessage_1() {
		return invalidPasswordMessage_1;
	}

	public String getInvalidPasswordMessage_2() {
		return invalidPasswordMessage_2;
	}

	public String getPasswordUnmatchErrorMessage() {
		return passwordUnmatchError;
	}

	public String getInvalidEmail() {
		return invalidEmail;
	}

	public String getInvalidPassword() {
		return invalidPassword;
	}

	public String getExistedEmail() {
		return existedEmail;
	}

	public String getOtherConfirmPassword() {
		return otherConfirmPassword;
	}

	public String getRegisterSuccess() {
		return registerSuccess;
	}
	
	
	@JsonProperty("RegisterSuccess")
	RegisterSuccess register;
	
	public class RegisterSuccess{
		@JsonProperty("firstname")
		String firstname;
		
		@JsonProperty("lastname")
		String lastname;
		
		@JsonProperty("day")
		String day;
		
		@JsonProperty("month")
		String month;
		
		@JsonProperty("year")
		String year;
		
		@JsonProperty("company")
		String company;
		
	}
	
	public String getFirstNameRegister() {
		return register.firstname;
	}
	
	public String getLastNameRegister() {
		return register.lastname;
	}
	
	public String getDayRegister() {
		return register.day;
	}
	
	public String getMonthRegister() {
		return register.month;
	}
	
	public String getYearRegister() {
		return register.year;
	}
	
	public String getCompanyRegister() {
		return register.company;
	}
}
