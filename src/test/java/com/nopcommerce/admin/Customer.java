package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.adminData.CustomerData;

import commons.BaseTest;
import commons.GlobalConstants;
import nopcommerce.admin.pageObject.CustomerPageObject;
import nopcommerce.admin.pageObject.HomePageObject;
import nopcommerce.admin.pageObject.LoginPageObject;
import nopcommerce.admin.pageObject.PageGeneratorManager;
public class Customer extends BaseTest{
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	CustomerPageObject customerPage;
	
	@Parameters({"browser","appURL"})
	@BeforeClass
	public void beforeClass(String browser, String appURL) {
		log.info("Pre-condition: Step 1 - Open browser '" + browser + "' navigate to '" + appURL + "'");
		driver = getBrowserDriver(browser, appURL);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Pre-condition: Step 2 - Login to system admin");
		loginPage.sendKeyToTextBoxByID(driver, GlobalConstants.ADMIN_EMAIL, "Email");
		loginPage.sendKeyToTextBoxByID(driver, GlobalConstants.ADMIN_PASSWORD, "Password");
		loginPage.clickToButtonByClassName(driver, "login-button");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Click to Customers");
		homePage.openParentMenuByText("Customers");
		
		log.info("Click to Customers");
		customerPage = (CustomerPageObject) homePage.openChildMenu(driver, "Customers");
	}

	@Test
	public void Test_01_Create_Customer() {
		log.info("Click to Add New button");
		customerPage.clickToAddNewButton("Customers");
		
		log.info("Input email");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EMAIL, "Email");
		
		
		log.info("Input password");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.PASSWORD, "Password");
		
		
		log.info("Input first name");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.FIRST_NAME, "FirstName");
		
		log.info("Input last name");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.LAST_NAME, "LastName");
		
		log.info("Select gender");
		customerPage.checkToCheckBoxOrRadioByID(driver, "Gender_Female");
		
		
		log.info("Input day of birth");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.DATE_OF_BIRTH, "DateOfBirth");
		
		log.info("Input company name");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.COMPANY, "Company");
		
		log.info("Select customer role");
		customerPage.selectCustomerRole(CustomerData.CUSTOMER_ROLE);
		
		
		log.info("Input admin comment");
		customerPage.sendKeyToTextAreaByID(driver, CustomerData.ADMIN_COMMENT, "AdminComment");
		
		log.info("Click Save button");
		customerPage.clickToButtonByName(driver, "save");
		
		log.info("Verify create customer successfully");
		verifyTrue(customerPage.isAlertSuccessDisplayed());
		
	}
	
	@Test
	public void Test_02_Seach_Customer_Email() {
		log.info("Input keyword to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EMAIL, "SearchEmail");
		
		
		log.info("Click search button");
		customerPage.clickToButtonByClassName(driver, "btn-search");
		
		
		log.info("Verify only one customer is displayed");
		verifyTrue(customerPage.isCustomerDisplayed(CustomerData.EMAIL));
		
	}
	
	@Test
	public void Test_03_Search_Firstname_Lastname() {
		log.info("Input keyword to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.FIRST_NAME, "SearchFirstName");
		
		log.info("Input keyword to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.LAST_NAME, "SearchLastName");
		
		log.info("Click search button");
		customerPage.clickToButtonByClassName(driver, "btn-search");
		
		log.info("Verify only one customer is displayed");
		verifyTrue(customerPage.isCustomerDisplayed(L));
	}
	
	
	
	
	
	@AfterClass
	public void afterClass() {
		
	}
}
