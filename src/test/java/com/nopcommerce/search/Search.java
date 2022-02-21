package com.nopcommerce.search;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.MyAccountData;

import commons.BaseTest;
import nopcommerce.pageObject.DashboardPageObject;
import nopcommerce.pageObject.PageGeneratorManager;
import nopcommerce.pageObject.SearchPageObject;

public class Search extends BaseTest{
	WebDriver driver;
	DashboardPageObject dashboardPage;
	SearchPageObject searchPage;
	
	@Parameters({"browser", "appURL"})
	@BeforeClass
	public void beforeClass(String browser, String appURL) {
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
		verifyTrue(searchPage.isErrorMessageDisplayed(MyAccountData.Seach.SEARCH_EMPTY_MESSAGE));
		
	}
	
	@Test
	public void Test_02_Search_With_Data_No_Existed() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, MyAccountData.Seach.DATA_NO_EXISTED, "q");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify error message is displayed");
		verifyTrue(searchPage.isErrorMessageDisplayed(MyAccountData.Seach.DATA_NO_EXISTED_MESSAGE));
	}
	
	
	@Test
	public void Test_03_Search_Like() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, MyAccountData.Seach.SEARCH_LIKE, "q");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify product contained keyword is displayed");
		verifyTrue(searchPage.isProductDisplayed(MyAccountData.Seach.PRODUCT_LIKE));
	}
	
	@Test
	public void Test_04_Search_Equal() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, MyAccountData.Seach.SEARCH, "q");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify product contained keyword is displayed");
		verifyTrue(searchPage.isProductDisplayed(MyAccountData.Seach.SEARCH));
	}
	
	@Test
	public void Test_05_Search_With_Parent_Category() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, MyAccountData.Seach.SEARCH_KEYWORD, "q");
		
		log.info("Click to advance checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "advs");
		
		log.info("Select category");
		searchPage.selectOptionByText(driver, MyAccountData.Seach.PARENT_CATEGORY, "cid");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify no data message is displayed");
		verifyTrue(searchPage.isErrorMessageDisplayed(MyAccountData.Seach.DATA_NO_EXISTED_MESSAGE));
	}
	
	@Test
	public void Test_06_Search_With_Sub_Category() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, MyAccountData.Seach.SEARCH_KEYWORD, "q");
		
		log.info("Click to advance checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "advs");
		
		log.info("Select parent category");
		searchPage.selectOptionByText(driver, MyAccountData.Seach.PARENT_CATEGORY, "cid");
		
		log.info("Check to sub category checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "isc");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify product contained keyword is displayed");
		verifyTrue(searchPage.isProductDisplayed(MyAccountData.Seach.PRODUCT_SUB_CATE));
	}
	
	@Test
	public void Test_07_Search_With_Incorrect_Manufacter() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, MyAccountData.Seach.SEARCH_KEYWORD, "q");
		
		log.info("Click to advance checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "advs");
		
		log.info("Select parent category");
		searchPage.selectOptionByText(driver, MyAccountData.Seach.PARENT_CATEGORY, "cid");
		
		log.info("Check to sub category checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "isc");
		
		log.info("Select manufacturer");
		searchPage.selectOptionByText(driver, MyAccountData.Seach.INCORRECT_MANUFACTURER_CATE, "mid");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify no data message is displayed");
		verifyTrue(searchPage.isErrorMessageDisplayed(MyAccountData.Seach.DATA_NO_EXISTED_MESSAGE));
	}
	
	@Test
	public void Test_08_Search_With_Correct_Manufacter() {
		log.info("Open search page");
		searchPage.openPageInFooterByName(driver, "Search");
		
		log.info("Input keyword to textbox");
		searchPage.sendKeyToTextBoxByID(driver, MyAccountData.Seach.SEARCH_KEYWORD, "q");
		
		log.info("Click to advance checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "advs");
		
		log.info("Select parent category");
		searchPage.selectOptionByText(driver, MyAccountData.Seach.PARENT_CATEGORY, "cid");
		
		log.info("Check to sub category checkbox");
		searchPage.checkToCheckBoxOrRadioByID(driver, "isc");
		
		log.info("Select manufacturer");
		searchPage.selectOptionByText(driver, MyAccountData.Seach.CORRECT_MANUFACTURER_CATE, "mid");
		
		log.info("Click to search button");
		searchPage.clickToButtonByClassName(driver, "search-button");
		
		log.info("Verify product is displayed");
		verifyTrue(searchPage.isProductDisplayed(MyAccountData.Seach.SEARCH));
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
		
	}

}
