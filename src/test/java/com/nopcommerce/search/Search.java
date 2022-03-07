package com.nopcommerce.search;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nopcommerce.data.SearchData;

import commons.BaseTest;
import nopcommerce.pageObject.DashboardPageObject;
import nopcommerce.pageObject.PageGeneratorManager;
import nopcommerce.pageObject.SearchPageObject;

public class Search extends BaseTest{
	WebDriver driver;
	DashboardPageObject dashboardPage;
	SearchPageObject searchPage;
	SearchData searchData;
	
	@Parameters({"browser", "appURL"})
	@BeforeClass
	public void beforeClass(String browser, String appURL) throws JsonParseException, JsonMappingException, IOException {
		searchData = SearchData.getSearchData();
		log.info("Pre-condition: Step 1 - Open browser '" + browser + "' navigate to '" + appURL + "'");
		driver = getBrowserDriver(browser, appURL);
		dashboardPage = (DashboardPageObject) PageGeneratorManager.getDashboardPage(getDriver());
		
		searchPage =(SearchPageObject) dashboardPage.openPageInFooterByName(driver, "Search");
	}
	
	@Test
	public void Test_01_Search_With_Empty_Data() {
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify error message is displayed");
		verifyTrue(searchPage.isErrorMessageDisplayed(searchData.getSearchEmptyMessage()));
		
	}
	
	@Test
	public void Test_02_Search_With_Data_No_Existed() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, searchData.getDataNoExisted(), "q");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify error message is displayed");
		verifyTrue(searchPage.isErrorMessageDisplayed(searchData.getDataNoExistedMessage()));
	}
	
	
	@Test
	public void Test_03_Search_Like() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, searchData.getSearchLike(), "q");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify product contained keyword is displayed");
		verifyTrue(searchPage.isProductDisplayed(searchData.getProductLike()));
	}
	
	@Test
	public void Test_04_Search_Equal() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, searchData.getSearch(), "q");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify product contained keyword is displayed");
		verifyTrue(searchPage.isProductDisplayed(searchData.getSearch()));
	}
	
	@Test
	public void Test_05_Search_With_Parent_Category() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, searchData.getSearchKeyword(), "q");
		
		log.info("Click to advance checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "advs");
		
		log.info("Select category");
		searchPage.selectOptionByText(driver, searchData.getParentCategory(), "cid");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify no data message is displayed");
		verifyTrue(searchPage.isErrorMessageDisplayed(searchData.getDataNoExistedMessage()));
	}
	
	@Test
	public void Test_06_Search_With_Sub_Category() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, searchData.getSearchKeyword(), "q");
		
		log.info("Click to advance checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "advs");
		
		log.info("Select parent category");
		searchPage.selectOptionByText(driver,searchData.getParentCategory(), "cid");
		
		log.info("Check to sub category checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "isc");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify product contained keyword is displayed");
		verifyTrue(searchPage.isProductDisplayed(searchData.getProductSubCate()));
	}
	
	@Test
	public void Test_07_Search_With_Incorrect_Manufacter() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, searchData.getSearchKeyword(), "q");
		
		log.info("Click to advance checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "advs");
		
		log.info("Select parent category");
		searchPage.selectOptionByText(driver, searchData.getParentCategory(), "cid");
		
		log.info("Check to sub category checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "isc");
		
		log.info("Select manufacturer");
		searchPage.selectOptionByText(driver, searchData.getIncorrectManufacturerCate(), "mid");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify no data message is displayed");
		verifyTrue(searchPage.isErrorMessageDisplayed(searchData.getDataNoExistedMessage()));
	}
	
	@Test
	public void Test_08_Search_With_Correct_Manufacter() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, searchData.getSearchKeyword(), "q");
		
		log.info("Click to advance checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "advs");
		
		log.info("Select parent category");
		searchPage.selectOptionByText(driver, searchData.getParentCategory(), "cid");
		
		log.info("Check to sub category checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "isc");
		
		log.info("Select manufacturer");
		searchPage.selectOptionByText(driver, searchData.getCorrectManufacturerCate(), "mid");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify product is displayed");
		verifyTrue(searchPage.isProductDisplayed(searchData.getSearch()));
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
		
	}

}
