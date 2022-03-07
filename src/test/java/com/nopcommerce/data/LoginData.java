package com.nopcommerce.data;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class LoginData {
	public static LoginData getLoginData() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(
				new File(GlobalConstants.PROJECT_PATH + "\\src\\test\\java\\com\\nopcommerce\\data\\Login.json"),
				LoginData.class);
	}
	
	@JsonProperty("emptyEmailMessage")
	String  emptyEmailMessage;
	
	@JsonProperty("invalidEmailMessage")
	String  invalidEmailMessage;
	
	@JsonProperty("summaryErrorMessage")
	String  summaryErrorMessage;
	
	@JsonProperty("noExistedEmailMessage")
	String  noExistedEmailMessage;
	
	@JsonProperty("invalidPasswordMessage")
	String  invalidPasswordMessage;
	
	@JsonProperty("invalidEmail")
	String  invalidEmail;
	
	@JsonProperty("noExistedEmail")
	String  noExistedEmail;
	
	@JsonProperty("invalidPassword")
	String  invalidPassword;

	public String getEmptyEmailMessage() {
		return emptyEmailMessage;
	}

	public String getInvalidEmailMessage() {
		return invalidEmailMessage;
	}

	public String getSummaryErrorMessage() {
		return summaryErrorMessage;
	}

	public String getNoExistedEmailMessage() {
		return noExistedEmailMessage;
	}

	public String getInvalidPasswordMessage() {
		return invalidPasswordMessage;
	}

	public String getInvalidEmail() {
		return invalidEmail;
	}

	public String getNoExistedEmail() {
		return noExistedEmail;
	}

	public String getInvalidPassword() {
		return invalidPassword;
	}
	
	
}
