package com.nopcommerce.data;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class OrderData {
	public static OrderData getOrderData() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(
				new File(GlobalConstants.PROJECT_PATH + "\\src\\test\\java\\com\\nopcommerce\\data\\Order.json"),
				OrderData.class);
	}
	
	@JsonProperty("product")
	String product;

	public String getProduct() {
		return product;
	}
}
