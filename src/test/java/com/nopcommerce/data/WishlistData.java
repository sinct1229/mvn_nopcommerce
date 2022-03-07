package com.nopcommerce.data;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class WishlistData {
	public static WishlistData getWishlistData() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(
				new File(GlobalConstants.PROJECT_PATH + "\\src\\test\\java\\com\\nopcommerce\\data\\Login.json"),
				WishlistData.class);
	}
	
	@JsonProperty("productName")
	String  productName;
	
	@JsonProperty("emptyMessage")
	String  emptyMessage;
	
	@JsonProperty("product_1")
	String  product_1;
	
	@JsonProperty("product_2")
	String  product_2;
	
	@JsonProperty("product_3")
	String  product_3;
	
	@JsonProperty("product_4")
	String  product_4;

	public String getProductName() {
		return productName;
	}

	public String getEmptyMessage() {
		return emptyMessage;
	}

	public String getProduct_1() {
		return product_1;
	}

	public String getProduct_2() {
		return product_2;
	}

	public String getProduct_3() {
		return product_3;
	}

	public String getProduct_4() {
		return product_4;
	}
	
	
}
