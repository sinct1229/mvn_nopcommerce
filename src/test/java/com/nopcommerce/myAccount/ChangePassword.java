package com.nopcommerce.myAccount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nopcommerce.data.LoginData;
import com.nopcommerce.data.MyAccountData;

import commons.BaseTest;
import commons.GlobalConstants;
import nopcommerce.pageObject.ChangePasswordPageObject;
import nopcommerce.pageObject.DashboardPageObject;
import nopcommerce.pageObject.LoginPageObject;
import nopcommerce.pageObject.MyAccountPageObject;
import nopcommerce.pageObject.PageGeneratorManager;

public class ChangePassword extends BaseTest{
	WebDriver driver;
	DashboardPageObject dashboardPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	ChangePasswordPageObject changePasswordPage;
	
	@Parameters({"browser", "appURL"})
	@BeforeClass
	public void beforeClass(String browser, String appURL) {
		log.info("Pre-condition: Step 1 - Open browser '" + browser + "' navigate to '" + appURL + "'");
		driver = getBrowserDriver(browser, appURL);
		dashboardPage = (DashboardPageObject) PageGeneratorManager.getDashboardPage(getDriver());
		
		log.info("Pre-condition: Step 2 - Open login page");
		loginPage = (LoginPageObject) dashboardPage.clickToHeaderButton(getDriver(), "Log in");
		
		log.info("Pre-condition: Step 3 - Login to site");
		
		loginPage.sendKeyToTextBoxByID(driver, GlobalConstants.EMAIL, "Email");
		
		loginPage.sendKeyToTextBoxByID(driver, GlobalConstants.PASSWORD, "Password");
		
		loginPage.clickToButtonByClassName(driver, "login-button");
		
		dashboardPage = PageGeneratorManager.getDashboardPage(driver);
		
		dashboardPage.clickToHeaderButton(getDriver(), "My account");
		
		myAccountPage = (MyAccountPageObject) PageGeneratorManager.getMyAccountPage(getDriver());
		
		changePasswordPage =   (ChangePasswordPageObject) myAccountPage.openMenuByText("Change password");
	}
	
	@Test
	public void Test_01_Change_Password_Successfully() {
		log.info("Input old password to textbox");
		changePasswordPage.sendKeyToTextBoxByID(driver, GlobalConstants.PASSWORD, "OldPassword");
		
		log.info("Input new password to textbox");
		changePasswordPage.sendKeyToTextBoxByID(driver, GlobalConstants.NEW_PASSWORD, "NewPassword");
		
		log.info("Input confirm password to textbox");
		changePasswordPage.sendKeyToTextBoxByID(driver, GlobalConstants.NEW_C_PASSWORD, "ConfirmNewPassword");
		
		log.info("Click to Change button");
		changePasswordPage.clickToButtonByClassName(driver, "change-password-button");
		
		log.info("Verify change password successfully");
		verifyTrue(changePasswordPage.isSuccessMessageDisplayed(MyAccountData.ChangePassword.CHANGE_SUCCESS));
		
		log.info("Close bar notification");
		changePasswordPage.closeBarNotification();
		
		log.info("Log out");
		dashboardPage = (DashboardPageObject) changePasswordPage.clickToHeaderButton(driver, "Log out");

		log.info("Log out");
		dashboardPage = (DashboardPageObject) changePasswordPage.clickToHeaderButton(driver, "Log out");
		
		log.info("Login");
		loginPage = (LoginPageObject) dashboardPage.clickToHeaderButton(driver, "Log in");
		
		log.info("Input email");
		loginPage.sendKeyToTextBoxByID(driver, GlobalConstants.EMAIL, "Email");
		
		log.info("Input old password");
		loginPage.sendKeyToTextBoxByID(driver, GlobalConstants.PASSWORD, "Password");
		
		log.info("Click Login button");
		loginPage.clickToButtonByClassName(driver, "login-button");
		
		log.info("Verify login fail");
		verifyTrue(loginPage.isSummaryErrorMessageDisplayed(LoginData.ErrorMessage.SUMMARY_ERROR));
		verifyTrue(loginPage.isSummaryErrorMessageDisplayed(LoginData.ErrorMessage.INVALID_PASSWORD));
		
		log.info("Input email");
		loginPage.sendKeyToTextBoxByID(driver, GlobalConstants.EMAIL, "Email");
		
		log.info("Input new password");
		loginPage.sendKeyToTextBoxByID(driver, GlobalConstants.NEW_PASSWORD, "Password");
		
		log.info("Click login button");
		loginPage.clickToButtonByClassName(driver, "login-button");
		dashboardPage = PageGeneratorManager.getDashboardPage(getDriver());
		
		log.info("Verify login successfully");
		verifyTrue(dashboardPage.isLogOutTextIsDisplayed());
		
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
		
	}

}
