package com.nopcommerce.authentication;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.LoginData;

import commons.BaseTest;
import commons.GlobalConstants;
import nopcommerce.pageObject.DashboardPageObject;
import nopcommerce.pageObject.LoginPageObject;
import nopcommerce.pageObject.PageGeneratorManager;

public class Login extends BaseTest{
	WebDriver driver;
	DashboardPageObject dashboardPage;
	LoginPageObject loginPage;
	public static Set<Cookie> loginPageCookies;
	
	@Parameters({"browser", "appURL"})
	@BeforeClass
	public void beforeClass(String browser, String appURL) {
		log.info("Pre-condition: Step 1 - Open browser '" + browser + "' navigate to '" + appURL + "'");
		driver = getBrowserDriver(browser, appURL);
		dashboardPage = PageGeneratorManager.getDashboardPage(getDriver());
	
		log.info("Pre-condition: Step 2 - Open login page");
		loginPage = (LoginPageObject) dashboardPage.clickToHeaderButton(getDriver(), "Log in");
		
	}
	
	@Test
	public void Test_01_Login_With_Empty_Data() {
		log.info("Test_01_Login_With_Empty_Data: Click to login button");
		loginPage.clickToButtonByClassName(driver, "login-button");
		
		log.info("Test_01_Login_With_Empty_Data: Verify error message is displayed");
		verifyTrue(loginPage.isErrorMessageDisplayedByText(LoginData.ErrorMessage.EMPTY_EMAIL));
	}
	
	@Test
	public void Test_02_Login_With_Invalid_Email() {

		log.info("Test_02_Login_With_Invalid_Email: Input invalid email to textbox");
		loginPage.sendKeyToTextBoxByID(getDriver(), LoginData.InvalidData.INVALID_EMAIL, "Email");
		
		log.info("Test_02_Login_With_Invalid_Email: Click to login button");
		loginPage.clickToButtonByClassName(driver, "login-button");
		
		log.info("Test_02_Login_With_Invalid_Email: Verify error message is displayed");
		verifyTrue(loginPage.isErrorMessageDisplayedByText(LoginData.ErrorMessage.INVALID_EMAIL));
	}
	
	@Test
	public void Test_03_Login_With_No_Existed_Email() {

		log.info("Test_03_Login_With_No_Existed_Email: Input no-existed email to textbox");
		loginPage.sendKeyToTextBoxByID(getDriver(), LoginData.InvalidData.NO_EXISTED_EMAIL, "Email");
		
		log.info("Test_03_Login_With_No_Existed_Email: Input password to textbox");
		loginPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.PASSWORD, "Password");
		
		log.info("Test_03_Login_With_No_Existed_Email: Click to login button");
		loginPage.clickToButtonByClassName(driver, "login-button");
		
		log.info("Test_03_Login_With_No_Existed_Email: Verify error message is displayed");
		verifyTrue(loginPage.isSummaryErrorMessageDisplayed(LoginData.ErrorMessage.SUMMARY_ERROR));
		verifyTrue(loginPage.isSummaryErrorMessageDisplayed(LoginData.ErrorMessage.NO_EXISTED_EMAIL));
	}
	
	@Test
	public void Test_04_Login_With_Empty_Password() {

		log.info("Test_04_Login_With_Empty_Password: Input email to textbox");
		loginPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.EMAIL, "Email");
		
		log.info("Test_04_Login_With_Empty_Password: Click to login button");
		loginPage.clickToButtonByClassName(driver, "login-button");
		
		log.info("Test_04_Login_With_Empty_Password: Verify error message is displayed");
		verifyTrue(loginPage.isSummaryErrorMessageDisplayed(LoginData.ErrorMessage.SUMMARY_ERROR));
		verifyTrue(loginPage.isSummaryErrorMessageDisplayed(LoginData.ErrorMessage.INVALID_PASSWORD));
	}
	
	@Test
	public void Test_05_Login_With_Invalid_Password() {

		log.info("Test_05_Login_With_Invalid_Password: Input email to textbox");
		loginPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.EMAIL, "Email");
		
		log.info("Test_05_Login_With_Invalid_Password: Input password to textbox");
		loginPage.sendKeyToTextBoxByID(getDriver(), LoginData.InvalidData.INVALID_PASSWORD, "Password");
		
		log.info("Test_05_Login_With_Invalid_Password: Click to login button");
		loginPage.clickToButtonByClassName(driver, "login-button");
		
		log.info("Test_05_Login_With_Invalid_Password: Verify error message is displayed");
		verifyTrue(loginPage.isSummaryErrorMessageDisplayed(LoginData.ErrorMessage.SUMMARY_ERROR));
		verifyTrue(loginPage.isSummaryErrorMessageDisplayed(LoginData.ErrorMessage.INVALID_PASSWORD));
	}
	
	@Test
	public void Test_06_Login_Success() {

		log.info("Test_06_Login_Success: Input email to textbox");
		loginPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.EMAIL, "Email");
		
		log.info("Test_06_Login_Success: Input password to textbox");
		loginPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.PASSWORD, "Password");
		
		log.info("Test_06_Login_Success: Click to login button");
		loginPage.clickToButtonByClassName(driver, "login-button");
		dashboardPage = PageGeneratorManager.getDashboardPage(getDriver());
		
		log.info("Test_06_Login_Success: Verify log out text is displayed");
		verifyTrue(dashboardPage.isLogOutTextIsDisplayed());
		
		log.info("Get cookies");
		loginPageCookies = dashboardPage.getAllCookies(getDriver());
		
		System.out.println(loginPageCookies);
		
	}

	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
		
	}
}
