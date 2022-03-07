package com.nopcommerce.authentication;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nopcommerce.data.RegisterData;

import commons.BaseTest;
import commons.GlobalConstants;
import nopcommerce.pageObject.DashboardPageObject;
import nopcommerce.pageObject.LoginPageObject;
import nopcommerce.pageObject.PageGeneratorManager;
import nopcommerce.pageObject.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Register extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	DashboardPageObject dashboardPage;
	RegisterData registerData;
	
	@Parameters({"browser", "appURL"})
	@BeforeClass
	public void beforeClass(String browser, String appURL) throws JsonParseException, JsonMappingException, IOException {
		registerData = RegisterData.getRegisterData();
		log.info("Pre-condition: Step 1 - Open browser '" + browser + "' navigate to '" + appURL + "'");
		driver = getBrowserDriver(browser, appURL);
		dashboardPage = (DashboardPageObject) PageGeneratorManager.getDashboardPage(getDriver());
		
		log.info("Pre-condition: Step 2 - Open register page");
		registerPage = (RegisterPageObject) dashboardPage.clickToHeaderButton(getDriver(), "Register");
	}
	
	@Test
	public void Test_01_Register_With_Empty_Data() {
		log.info("Test_01_Register_With_Empty_Data: Click on register button");
		registerPage.clickToButtonByName(getDriver(), "register-button");
		
		log.info("Test_01_Register_With_Empty_Data: Verify error message is dispaled in firstname field");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(registerData.getFirstNameErrorMessage()));
		
		log.info("Test_01_Register_With_Empty_Data: Verify error message is dispaled in lastname field");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(registerData.getLastNameErrorMessage()));
		
		log.info("Test_01_Register_With_Empty_Data: Verify error message is dispaled in email field");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(registerData.getEmailErrorMessage()));
		
		log.info("Test_01_Register_With_Empty_Data: Verify error message is dispaled in password field");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(registerData.getPasswordErrorMessage()));
		
		log.info("Test_01_Register_With_Empty_Data: Verify error message is dispaled in confirm password field");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(registerData.getConfirmPasswordErrorMessage()));
	}
	
	@Test
	public void Test_02_Register_With_Invalid_Email() {
		log.info("Test_02_Register_With_Invalid_Email: Click on register button in header");
		registerPage.clickToHeaderButton(getDriver(), "Register");
		
		log.info("Test_02_Register_With_Invalid_Email: Check to female gender");
		registerPage.checkToCheckBoxOrRadioByID(getDriver(), "gender-female");
		
		log.info("Test_02_Register_With_Invalid_Email: Input firstname");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getFirstNameRegister(), "FirstName");
		
		log.info("Test_02_Register_With_Invalid_Email: Input lastname");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getLastNameRegister(), "LastName");
		
		log.info("Test_02_Register_With_Invalid_Email: Select day");
		registerPage.selectOptionByText(getDriver(), registerData.getDayRegister(), "DateOfBirthDay");
		
		log.info("Test_02_Register_With_Invalid_Email: Select month");
		registerPage.selectOptionByText(getDriver(), registerData.getMonthRegister(), "DateOfBirthMonth");
		
		log.info("Test_02_Register_With_Invalid_Email: Select year");
		registerPage.selectOptionByText(getDriver(), registerData.getYearRegister(), "DateOfBirthYear");
		
		log.info("Test_02_Register_With_Invalid_Email: Input invalid email" + registerData.getInvalidEmail());
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getInvalidEmail(), "Email");
		
		log.info("Test_02_Register_With_Invalid_Email: Input company");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getCompanyRegister(), "Company");
		
		log.info("Test_02_Register_With_Invalid_Email: Input password");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.PASSWORD, "Password");
		
		log.info("Test_02_Register_With_Invalid_Email: Input confirm password");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.C_PASSWORD, "ConfirmPassword");
		
		log.info("Test_02_Register_With_Invalid_Email: Click on register button");
		registerPage.clickToButtonByName(getDriver(), "register-button");
		
		log.info("Test_02_Register_With_Invalid_Email: Verify " + registerData.getInvalidEmailMessage() + " is displayed");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(registerData.getInvalidEmailMessage()));
	}
	
	@Test
	public void Test_03_Register_Success() {
		log.info("Test_03_Register_Success: Click on register button in header");
		registerPage.clickToHeaderButton(getDriver(), "Register");
		
		log.info("Test_03_Register_Success: Check to female gender");
		registerPage.checkToCheckBoxOrRadioByID(getDriver(), "gender-female");
		
		log.info("Test_03_Register_Success: Input firstname");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getFirstNameRegister(), "FirstName");
		
		log.info("Test_03_Register_Success: Input lastname");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getLastNameRegister(), "LastName");
		
		log.info("Test_03_Register_Success: Select day");
		registerPage.selectOptionByText(getDriver(), registerData.getDayRegister(), "DateOfBirthDay");
		
		log.info("Test_03_Register_Success: Select month");
		registerPage.selectOptionByText(getDriver(), registerData.getMonthRegister(), "DateOfBirthMonth");
		
		log.info("Test_03_Register_Success: Select year");
		registerPage.selectOptionByText(getDriver(), registerData.getYearRegister(), "DateOfBirthYear");
		
		log.info("Test_03_Register_Success: Input email");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.EMAIL, "Email");
		
		log.info("Test_03_Register_Success: Input company");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getCompanyRegister(), "Company");
		
		log.info("Test_03_Register_Success: Input password");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.PASSWORD, "Password");
		
		log.info("Test_03_Register_Success: Input confirm password");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.C_PASSWORD, "ConfirmPassword");
		
		log.info("Test_03_Register_Success: Click on register button");
		registerPage.clickToButtonByName(getDriver(), "register-button");
		
		log.info("Test_03_Register_Success: Verify " + registerData.getRegisterSuccess() + " is displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed(registerData.getRegisterSuccess()));
		
		log.info("Test_03_Register_Success: Click on log out button");
		registerPage.clickToHeaderButton(getDriver(), "Log out");
	}
	
	@Test
	public void Test_04_Register_With_Existed_Email() {
		log.info("Test_04_Register_With_Existed_Email: Click on register button in header");
		registerPage.clickToHeaderButton(getDriver(), "Register");
		
		log.info("Test_04_Register_With_Existed_Email: Check to female gender");
		registerPage.checkToCheckBoxOrRadioByID(getDriver(), "gender-female");
		
		log.info("Test_04_Register_With_Existed_Email: Input firstname");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getFirstNameRegister(), "FirstName");
		
		log.info("Test_04_Register_With_Existed_Email: Input lastname");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getLastNameRegister(), "LastName");
		
		log.info("Test_04_Register_With_Existed_Email: Select day");
		registerPage.selectOptionByText(getDriver(), registerData.getDayRegister(), "DateOfBirthDay");
		
		log.info("Test_04_Register_With_Existed_Email: Select month");
		registerPage.selectOptionByText(getDriver(), registerData.getMonthRegister(), "DateOfBirthMonth");
		
		log.info("Test_04_Register_With_Existed_Email: Select year");
		registerPage.selectOptionByText(getDriver(), registerData.getYearRegister(), "DateOfBirthYear");
		
		log.info("Test_04_Register_With_Existed_Email: Input existed email");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.EMAIL, "Email");
		
		log.info("Test_04_Register_With_Existed_Email: Input company");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getCompanyRegister(), "Company");
		
		log.info("Test_04_Register_With_Existed_Email: Input password");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.PASSWORD, "Password");
		
		log.info("Test_04_Register_With_Existed_Email: Input confirm password");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.C_PASSWORD, "ConfirmPassword");
		
		log.info("Test_04_Register_With_Existed_Email: Click on register button");
		registerPage.clickToButtonByName(getDriver(), "register-button");
		
		log.info("Test_04_Register_With_Existed_Email: Verify " + registerData.getExistedEmailMessage() + " is displayed");
		verifyTrue(registerPage.isExistedEMailErrorDisplayed(registerData.getExistedEmailMessage()));
	}
	
	@Test
	public void Test_05_Register_With_Invalid_Password() {
		log.info("Test_05_Register_With_Invalid_Password: Click on register button in header");
		registerPage.clickToHeaderButton(getDriver(), "Register");
		
		log.info("Test_05_Register_With_Invalid_Password: Check to female gender");
		
		log.info("Test_05_Register_With_Invalid_Password: Input firstname");
		registerPage.checkToCheckBoxOrRadioByID(getDriver(), "gender-female");
		
		log.info("Test_05_Register_With_Invalid_Password: Input firstname");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getFirstNameRegister(), "FirstName");
		
		log.info("Test_05_Register_With_Invalid_Password: Input lastname");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getLastNameRegister(), "LastName");
		
		log.info("Test_05_Register_With_Invalid_Password: Select day");
		registerPage.selectOptionByText(getDriver(), registerData.getDayRegister(), "DateOfBirthDay");
		
		log.info("Test_05_Register_With_Invalid_Password: Select month");
		registerPage.selectOptionByText(getDriver(), registerData.getMonthRegister(), "DateOfBirthMonth");
		
		log.info("Test_05_Register_With_Invalid_Password: Select year");
		registerPage.selectOptionByText(getDriver(), registerData.getYearRegister(), "DateOfBirthYear");
		
		log.info("Test_05_Register_With_Invalid_Password: Input email");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.EMAIL, "Email");
		
		log.info("Test_05_Register_With_Invalid_Password: Input company");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getCompanyRegister(), "Company");
		
		log.info("Test_05_Register_With_Invalid_Password: Input invalid password" + registerData.getInvalidPassword());
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getInvalidPassword(), "Password");
		
		log.info("Test_05_Register_With_Invalid_Password: Input confirm password");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getInvalidPassword(), "ConfirmPassword");
		
		log.info("Test_05_Register_With_Invalid_Password: Click on register button");
		registerPage.clickToButtonByName(getDriver(), "register-button");
		
		log.info("Test_05_Register_With_Invalid_Password: Verify " + registerData.getInvalidPasswordMessage_1() + registerData.getInvalidPasswordMessage_2() + " is displayed");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(registerData.getInvalidPasswordMessage_1()));
		verifyTrue(registerPage.isErrorMessageDisplayedByText(registerData.getInvalidPasswordMessage_2()));
	}
	
	@Test
	public void Test_06_Register_With_Unmatch_Password_CPassword() {
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Click on register button in header");
		registerPage.clickToHeaderButton(getDriver(), "Register");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Check to female gender");
		registerPage.checkToCheckBoxOrRadioByID(getDriver(), "gender-female");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Input firstname");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getFirstNameRegister(), "FirstName");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Input lastname");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getLastNameRegister(), "LastName");
		
		log.info("Test_05_Register_With_Invalid_Password: Select day");
		registerPage.selectOptionByText(getDriver(), registerData.getDayRegister(), "DateOfBirthDay");
		
		log.info("Test_05_Register_With_Invalid_Password: Select month");
		registerPage.selectOptionByText(getDriver(), registerData.getMonthRegister(), "DateOfBirthMonth");
		
		log.info("Test_05_Register_With_Invalid_Password: Select year");
		registerPage.selectOptionByText(getDriver(), registerData.getYearRegister(), "DateOfBirthYear");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Input email");
		registerPage.sendKeyToTextBoxByID(getDriver(),  GlobalConstants.EMAIL, "Email");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Input company");
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getCompanyRegister(), "Company");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Input password" + GlobalConstants.PASSWORD);
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.PASSWORD, "Password");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Input orther confirm password" + registerData.getOtherConfirmPassword());
		registerPage.sendKeyToTextBoxByID(getDriver(), registerData.getOtherConfirmPassword(), "ConfirmPassword");
	
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Click on register button");
		registerPage.clickToButtonByName(getDriver(), "register-button");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Verify " + registerData.getConfirmPasswordErrorMessage() + " is displayed");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(registerData.getConfirmPasswordErrorMessage()));
	}
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
