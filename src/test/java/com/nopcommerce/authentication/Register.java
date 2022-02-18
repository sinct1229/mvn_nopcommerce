package com.nopcommerce.authentication;

import org.testng.annotations.Test;

import commons.BaseTest;
import nopcommerce.pageObject.LoginPageObject;
import nopcommerce.pageObject.PageGeneratorManager;
import nopcommerce.pageObject.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Register extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	@Parameters({"browser", "appURL"})
	@BeforeClass
	public void beforeClass(String browser, String appURL) {
		log.info("Pre-condition: Step 1 - Open browser '" + browser + "' navigate to '" + appURL + "'");
		driver = getBrowserDriver(browser, appURL);
		loginPage = PageGeneratorManager.getLoginPage(getDriver());
		
		log.info("Pre-condition: Step 2 - Open register page");
		registerPage = loginPage.clickToHereText();
		PageGeneratorManager.getRegisterPage(getDriver());
	}
	
	@Test
	public void Test_01_() {
	}
	
	@AfterClass
	public void afterClass() {
	}

}
