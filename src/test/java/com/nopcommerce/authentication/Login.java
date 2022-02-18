package com.nopcommerce.authentication;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import nopcommerce.pageObject.LoginPageObject;
import nopcommerce.pageObject.PageGeneratorManager;

public class Login extends BaseTest{
	WebDriver driver;
	LoginPageObject loginPage;
	
	@Parameters({"browser", "appURL"})
	@BeforeClass
	public void beforeClass(String browser, String appURL) {
		log.info("Pre-condition: Step 1 - Open browser '" + browser + "' navigate to '" + appURL + "'");
		driver = getBrowserDriver(browser, appURL);
		loginPage = PageGeneratorManager.getLoginPage(getDriver());
		
	}
	
	@Test
	public void Test_01_() {
		log.info("");
		
	}

	
	@AfterClass
	public void afterClass() {
		
	}
}
