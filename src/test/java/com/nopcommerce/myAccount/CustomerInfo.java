package com.nopcommerce.myAccount;

import org.testng.annotations.Test;

import com.nopcommerce.data.MyAccountData;

import commons.BaseTest;
import commons.GlobalConstants;
import nopcommerce.pageObject.CustomerInforPageObject;
import nopcommerce.pageObject.DashboardPageObject;
import nopcommerce.pageObject.LoginPageObject;
import nopcommerce.pageObject.MyAccountPageObject;
import nopcommerce.pageObject.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class CustomerInfo extends BaseTest{
	WebDriver driver;
	DashboardPageObject dashboardPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	CustomerInforPageObject customerInfoPage;
	
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
		
		customerInfoPage = (CustomerInforPageObject) myAccountPage.openMenuByText("Customer info");
		
	}

	@Test
	public void Test_01_Update_Customer_Info_Success() {
		
		log.info("Test_01_Update_Customer_Info_Success: Check to gender");
		customerInfoPage.checkToCheckBoxOrRadioByID(getDriver(), "gender-male");
		
		log.info("Test_01_Update_Customer_Info_Success: Input firstname");
		customerInfoPage.sendKeyToTextBoxByID(getDriver(), MyAccountData.Customer.FIRST_NAME, "FirstName");
		
		log.info("Test_01_Update_Customer_Info_Success: Input lastname");
		customerInfoPage.sendKeyToTextBoxByID(getDriver(), MyAccountData.Customer.LAST_NAME, "LastName");
		
		log.info("Test_01_Update_Customer_Info_Success: Select day");
		customerInfoPage.selectOptionByText(getDriver(), MyAccountData.Customer.DAY, "DateOfBirthDay");
		
		log.info("Test_01_Update_Customer_Info_Success: Select month");
		customerInfoPage.selectOptionByText(getDriver(), MyAccountData.Customer.MONTH, "DateOfBirthMonth");
		
		log.info("Test_01_Update_Customer_Info_Success: Select year");
		customerInfoPage.selectOptionByText(getDriver(), MyAccountData.Customer.YEAR, "DateOfBirthYear");
		
		log.info("Test_01_Update_Customer_Info_Success: Input email");
		customerInfoPage.sendKeyToTextBoxByID(getDriver(), GlobalConstants.NEW_EMAIL, "Email");
		
		log.info("Test_01_Update_Customer_Info_Success: Input company");
		customerInfoPage.sendKeyToTextBoxByID(getDriver(), MyAccountData.Customer.COMPANY, "Company");
		
		log.info("Test_01_Update_Customer_Info_Success: Click on save button");
		customerInfoPage.clickToButtonByName(getDriver(), "save-info-button");
		
		log.info("Test_01_Update_Customer_Info_Success: Verify FirstName is updated successfully");
		verifyEquals(customerInfoPage.getValueOfFieldByID("FirstName"), MyAccountData.Customer.FIRST_NAME);
		
		log.info("Test_01_Update_Customer_Info_Success: Verify LastName is updated successfully");
		verifyEquals(customerInfoPage.getValueOfFieldByID("LastName"), MyAccountData.Customer.LAST_NAME);
		
		log.info("Test_01_Update_Customer_Info_Success: Verify Day is updated successfully");
		verifyEquals(customerInfoPage.getValueOfFieldByName("DateOfBirthDay"), MyAccountData.Customer.DAY);
		
		log.info("Test_01_Update_Customer_Info_Success: Verify Month is updated successfully");
		verifyEquals(customerInfoPage.getValueOfFieldByName("DateOfBirthMonth"), MyAccountData.Customer.MONTH);
		
		log.info("Test_01_Update_Customer_Info_Success: Verify Year is updated successfully");
		verifyEquals(customerInfoPage.getValueOfFieldByName("DateOfBirthYear"), MyAccountData.Customer.YEAR);
		
		log.info("Test_01_Update_Customer_Info_Success: Verify Email is updated successfully");
		verifyEquals(customerInfoPage.getValueOfFieldByID("Email"), GlobalConstants.NEW_EMAIL);
		
		log.info("Test_01_Update_Customer_Info_Success: Verify Company is updated successfully");
		verifyEquals(customerInfoPage.getValueOfFieldByID("Company"), MyAccountData.Customer.COMPANY);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
