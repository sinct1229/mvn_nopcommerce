package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
		customerPage.clickToAddNewButton();
		
		log.info("Input email");
		
		
		log.info("Input password");
		
		
		log.info("Input first name");
		
		
		log.info("Input class name");
		
		
		log.info("Select gender");
		
		
		log.info("Select day");
		
		
		log.info("Input day of birth");
		
		
		log.info("Input company name");
		
		
		log.info("Select customer role");
		
		
		log.info("Input admin comment");
		
		
	}
	@AfterClass
	public void afterClass() {
		
	}
}
