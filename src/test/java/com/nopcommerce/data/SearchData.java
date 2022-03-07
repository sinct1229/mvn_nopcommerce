package com.nopcommerce.data;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class SearchData {
	public static SearchData getSearchData() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(
				new File(GlobalConstants.PROJECT_PATH + "\\src\\test\\java\\com\\nopcommerce\\data\\Search.json"),
				SearchData.class);
	}
	
	@JsonProperty("searchEmptyMessage")
	String  searchEmptyMessage;
	
	@JsonProperty("dataNoExisted")
	String  dataNoExisted;
	
	@JsonProperty("dataNoExistedMessage")
	String  dataNoExistedMessage;
	
	@JsonProperty("searchLike")
	String  searchLike;
	
	@JsonProperty("productLike")
	String  productLike;
	
	@JsonProperty("search")
	String  search;
	
	@JsonProperty("searchKeyword")
	String  searchKeyword;
	
	@JsonProperty("parentCategory")
	String  parentCategory;
	
	@JsonProperty("productSubCate")
	String  productSubCate;
	
	@JsonProperty("incorrectManufacturerCate")
	String  incorrectManufacturerCate;
	
	@JsonProperty("correctManufacturerCate")
	String  correctManufacturerCate;

	public String getSearchEmptyMessage() {
		return searchEmptyMessage;
	}

	public String getDataNoExisted() {
		return dataNoExisted;
	}

	public String getDataNoExistedMessage() {
		return dataNoExistedMessage;
	}

	public String getSearchLike() {
		return searchLike;
	}

	public String getProductLike() {
		return productLike;
	}

	public String getSearch() {
		return search;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public String getParentCategory() {
		return parentCategory;
	}

	public String getProductSubCate() {
		return productSubCate;
	}

	public String getIncorrectManufacturerCate() {
		return incorrectManufacturerCate;
	}

	public String getCorrectManufacturerCate() {
		return correctManufacturerCate;
	}
}
