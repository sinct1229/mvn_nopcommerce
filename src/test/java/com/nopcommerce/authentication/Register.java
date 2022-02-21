package com.nopcommerce.authentication;

import org.testng.annotations.Test;

import com.nopcommerce.data.RegisterData;

import commons.BaseTest;
import commons.GlobalConstants;
import nopcommerce.pageObject.DashboardPageObject;
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
	DashboardPageObject dashboardPage;
	
	@Parameters({"browser", "appURL"})
	@BeforeClass
	public void beforeClass(String browser, String appURL) {
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
		verifyTrue(registerPage.isErrorMessageDisplayedByText(RegisterData.ErrorMessage.FIRSTNAME_ERROR));
		
		log.info("Test_01_Register_With_Empty_Data: Verify error message is dispaled in lastname field");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(RegisterData.ErrorMessage.LASTNAME_ERROR));
		
		log.info("Test_01_Register_With_Empty_Data: Verify error message is dispaled in email field");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(RegisterData.ErrorMessage.EMAIL_ERROR));
		
		log.info("Test_01_Register_With_Empty_Data: Verify error message is dispaled in password field");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(RegisterData.ErrorMessage.PASSWORD_ERROR));
		
		log.info("Test_01_Register_With_Empty_Data: Verify error message is dispaled in confirm password field");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(RegisterData.ErrorMessage.C_PASSWORD_ERROR));
	}
	
	@Test
	public void Test_02_Register_With_Invalid_Email() {
		log.info("Test_02_Register_With_Invalid_Email: Click on register button in header");
		registerPage.clickToHeaderButton(getDriver(), "Register");
		
		log.info("Test_02_Register_With_Invalid_Email: Check to female gender");
		registerPage.checkToCheckBoxOrRadioByID(getDriver(), "gender-female");
		
		log.info("Test_02_Register_With_Invalid_Email: Input firstname");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.FIRSTNAME, "FirstName");
		
		log.info("Test_02_Register_With_Invalid_Email: Input lastname");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.LASTNAME, "LastName");
		
		log.info("Test_02_Register_With_Invalid_Email: Select day");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.DAY, "DateOfBirthDay");
		
		log.info("Test_02_Register_With_Invalid_Email: Select month");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.MONTH, "DateOfBirthMonth");
		
		log.info("Test_02_Register_With_Invalid_Email: Select year");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.YEAR, "DateOfBirthYear");
		
		log.info("Test_02_Register_With_Invalid_Email: Input invalid email" + RegisterData.DataInvalid.INVALID_EMAIL);
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.DataInvalid.INVALID_EMAIL, "Email");
		
		log.info("Test_02_Register_With_Invalid_Email: Input company");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.COMPANY, "Company");
		
		log.info("Test_02_Register_With_Invalid_Email: Input password");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.PASSWORD, "Password");
		
		log.info("Test_02_Register_With_Invalid_Email: Input confirm password");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.C_PASSWORD, "ConfirmPassword");
		
		log.info("Test_02_Register_With_Invalid_Email: Click on register button");
		registerPage.clickToButtonByName(getDriver(), "register-button");
		
		log.info("Test_02_Register_With_Invalid_Email: Verify " + RegisterData.ErrorMessage.INVALID_EMAIL + " is displayed");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(RegisterData.ErrorMessage.INVALID_EMAIL));
	}
	
	@Test
	public void Test_03_Register_Success() {
		log.info("Test_03_Register_Success: Click on register button in header");
		registerPage.clickToHeaderButton(getDriver(), "Register");
		
		log.info("Test_03_Register_Success: Check to female gender");
		registerPage.checkToCheckBoxOrRadioByID(getDriver(), "gender-female");
		
		log.info("Test_03_Register_Success: Input firstname");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.FIRSTNAME, "FirstName");
		
		log.info("Test_03_Register_Success: Input lastname");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.LASTNAME, "LastName");
		
		log.info("Test_03_Register_Success: Select day");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.DAY, "DateOfBirthDay");
		
		log.info("Test_03_Register_Success: Select month");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.MONTH, "DateOfBirthMonth");
		
		log.info("Test_03_Register_Success: Select year");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.YEAR, "DateOfBirthYear");
		
		log.info("Test_03_Register_Success: Input email");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.EMAIL, "Email");
		
		log.info("Test_03_Register_Success: Input company");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.COMPANY, "Company");
		
		log.info("Test_03_Register_Success: Input password");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.PASSWORD, "Password");
		
		log.info("Test_03_Register_Success: Input confirm password");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.C_PASSWORD, "ConfirmPassword");
		
		log.info("Test_03_Register_Success: Click on register button");
		registerPage.clickToButtonByName(getDriver(), "register-button");
		
		log.info("Test_03_Register_Success: Verify " + RegisterData.Success.REGISTER_SUCCESS + " is displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed(RegisterData.Success.REGISTER_SUCCESS));
		
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
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.FIRSTNAME, "FirstName");
		
		log.info("Test_04_Register_With_Existed_Email: Input lastname");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.LASTNAME, "LastName");
		
		log.info("Test_04_Register_With_Existed_Email: Select day");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.DAY, "DateOfBirthDay");
		
		log.info("Test_04_Register_With_Existed_Email: Select month");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.MONTH, "DateOfBirthMonth");
		
		log.info("Test_04_Register_With_Existed_Email: Select year");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.YEAR, "DateOfBirthYear");
		
		log.info("Test_04_Register_With_Existed_Email: Input existed email");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.EMAIL, "Email");
		
		log.info("Test_04_Register_With_Existed_Email: Input company");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.COMPANY, "Company");
		
		log.info("Test_04_Register_With_Existed_Email: Input password");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.PASSWORD, "Password");
		
		log.info("Test_04_Register_With_Existed_Email: Input confirm password");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.C_PASSWORD, "ConfirmPassword");
		
		log.info("Test_04_Register_With_Existed_Email: Click on register button");
		registerPage.clickToButtonByName(getDriver(), "register-button");
		
		log.info("Test_04_Register_With_Existed_Email: Verify " + RegisterData.ErrorMessage.EXISTED_EMAIL + " is displayed");
		verifyTrue(registerPage.isExistedEMailErrorDisplayed(RegisterData.ErrorMessage.EXISTED_EMAIL));
	}
	
	@Test
	public void Test_05_Register_With_Invalid_Password() {
		log.info("Test_05_Register_With_Invalid_Password: Click on register button in header");
		registerPage.clickToHeaderButton(getDriver(), "Register");
		
		log.info("Test_05_Register_With_Invalid_Password: Check to female gender");
		
		log.info("Test_05_Register_With_Invalid_Password: Input firstname");
		registerPage.checkToCheckBoxOrRadioByID(getDriver(), "gender-female");
		
		log.info("Test_05_Register_With_Invalid_Password: Input firstname");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.FIRSTNAME, "FirstName");
		
		log.info("Test_05_Register_With_Invalid_Password: Input lastname");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.LASTNAME, "LastName");
		
		log.info("Test_05_Register_With_Invalid_Password: Select day");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.DAY, "DateOfBirthDay");
		
		log.info("Test_05_Register_With_Invalid_Password: Select month");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.MONTH, "DateOfBirthMonth");
		
		log.info("Test_05_Register_With_Invalid_Password: Select year");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.YEAR, "DateOfBirthYear");
		
		log.info("Test_05_Register_With_Invalid_Password: Input email");
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.EMAIL, "Email");
		
		log.info("Test_05_Register_With_Invalid_Password: Input company");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.COMPANY, "Company");
		
		log.info("Test_05_Register_With_Invalid_Password: Input invalid password" + RegisterData.DataInvalid.INVALID_PASSWORD);
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.DataInvalid.INVALID_PASSWORD, "Password");
		
		log.info("Test_05_Register_With_Invalid_Password: Input confirm password");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.DataInvalid.INVALID_PASSWORD, "ConfirmPassword");
		
		log.info("Test_05_Register_With_Invalid_Password: Click on register button");
		registerPage.clickToButtonByName(getDriver(), "register-button");
		
		log.info("Test_05_Register_With_Invalid_Password: Verify " + RegisterData.ErrorMessage.INVALID_PASSWORD_1 + RegisterData.ErrorMessage.INVALID_PASSWORD_2 + " is displayed");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(RegisterData.ErrorMessage.INVALID_PASSWORD_1));
		verifyTrue(registerPage.isErrorMessageDisplayedByText(RegisterData.ErrorMessage.INVALID_PASSWORD_2));
	}
	
	@Test
	public void Test_06_Register_With_Unmatch_Password_CPassword() {
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Click on register button in header");
		registerPage.clickToHeaderButton(getDriver(), "Register");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Check to female gender");
		registerPage.checkToCheckBoxOrRadioByID(getDriver(), "gender-female");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Input firstname");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.FIRSTNAME, "FirstName");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Input lastname");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.LASTNAME, "LastName");
		
		log.info("Test_05_Register_With_Invalid_Password: Select day");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.DAY, "DateOfBirthDay");
		
		log.info("Test_05_Register_With_Invalid_Password: Select month");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.MONTH, "DateOfBirthMonth");
		
		log.info("Test_05_Register_With_Invalid_Password: Select year");
		registerPage.selectOptionByText(getDriver(), RegisterData.RegisterSuccess.YEAR, "DateOfBirthYear");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Input email");
		registerPage.sendKeyToTextBoxByID(getDriver(),  GlobalConstants.EMAIL, "Email");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Input company");
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.RegisterSuccess.COMPANY, "Company");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Input password" + GlobalConstants.PASSWORD);
		registerPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.PASSWORD, "Password");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Input orther confirm password" + RegisterData.DataInvalid.OTHER_C_PASSWORD);
		registerPage.sendKeyToTextBoxByID(getDriver(), RegisterData.DataInvalid.OTHER_C_PASSWORD, "ConfirmPassword");
	
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Click on register button");
		registerPage.clickToButtonByName(getDriver(), "register-button");
		
		log.info("Test_06_Register_With_Unmatch_Password_CPassword: Verify " + RegisterData.ErrorMessage.PASSWORD_UNMATCH + " is displayed");
		verifyTrue(registerPage.isErrorMessageDisplayedByText(RegisterData.ErrorMessage.PASSWORD_UNMATCH));
	}
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
