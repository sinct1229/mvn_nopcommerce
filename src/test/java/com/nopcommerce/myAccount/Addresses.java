package com.nopcommerce.myAccount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.authentication.Login;
import com.nopcommerce.data.MyAccountData.Address;

import commons.BaseTest;
import nopcommerce.pageObject.AddressPageObject;
import nopcommerce.pageObject.DashboardPageObject;
import nopcommerce.pageObject.LoginPageObject;
import nopcommerce.pageObject.MyAccountPageObject;
import nopcommerce.pageObject.PageGeneratorManager;

public class Addresses extends BaseTest{
	WebDriver driver;
	DashboardPageObject dashboardPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	AddressPageObject addressPage;
	
	@Parameters({"browser", "appURL"})
	@BeforeClass
	public void beforeClass(String browser, String appURL) {
		log.info("Pre-condition: Step 1 - Open browser '" + browser + "' navigate to '" + appURL + "'");
		driver = getBrowserDriver(browser, appURL);
		dashboardPage = (DashboardPageObject) PageGeneratorManager.getDashboardPage(getDriver());
		
		log.info("Pre-condition: Step 2 - Open login page");
		loginPage = (LoginPageObject) dashboardPage.clickToHeaderButton(getDriver(), "Log in");
		
		log.info("Pre-condition: Step 3 - Set cookies");
		loginPage.setCookie(getDriver(), Login.loginPageCookies);
		
		loginPage.sleepInSecond(3);
		
		loginPage.refreshCurrentPage(getDriver());
		
		dashboardPage = PageGeneratorManager.getDashboardPage(getDriver());
		
		dashboardPage.closeBarNotification();
		
		dashboardPage.clickToHeaderButton(getDriver(), "My account");
		
		myAccountPage = (MyAccountPageObject) PageGeneratorManager.getMyAccountPage(getDriver());
		
		addressPage =  (AddressPageObject) myAccountPage.openMenuByText("Addresses");
		
		
	}
	@Test
	public void Test_01_Add_Address_Successfully() {
		log.info("Test_01_Add_Address_Successfully: Click to Add new button");
		addressPage.clickToButtonByClassName(driver, "add-address-button");
		
		log.info("Test_01_Add_Address_Successfully: Input FirstName to textbox");
		addressPage.sendKeyToTextBoxByID(driver, Address.FIRST_NAME, "Address_FirstName");
		
		log.info("Test_01_Add_Address_Successfully: Inpt LastName to textbox");
		addressPage.sendKeyToTextBoxByID(driver, Address.LAST_NAME, "Address_LastName");
		
		log.info("Test_01_Add_Address_Successfully: Input Email to textbox");
		addressPage.sendKeyToTextBoxByID(driver, Address.EMAIL, "Address_Email");
		
		log.info("Test_01_Add_Address_Successfully: Input company to textbox");
		addressPage.sendKeyToTextBoxByID(driver, Address.COMPANY, "Address_Company");
		
		log.info("Test_01_Add_Address_Successfully: Select country");
		addressPage.selectOptionByText(driver, Address.COUNTRY, "Address.CountryId");
		
		log.info("Test_01_Add_Address_Successfully: Input city to textbox");
		addressPage.sendKeyToTextBoxByID(driver, Address.CITY, "Address_City");
		
		log.info("Test_01_Add_Address_Successfully: Input address 1");
		addressPage.sendKeyToTextBoxByID(driver, Address.ADDRESS_1, "Address_Address1");
		
		log.info("Test_01_Add_Address_Successfully: Input address 2");
		addressPage.sendKeyToTextBoxByID(driver, Address.ADDRESS_2, "Address_Address2");
		
		log.info("Test_01_Add_Address_Successfully: Input Zipcode to textbox");
		addressPage.sendKeyToTextBoxByID(driver, Address.ZIPCODE, "Address_ZipPostalCode");
		
		log.info("Test_01_Add_Address_Successfully: Input Phone number to textbox");
		addressPage.sendKeyToTextBoxByID(driver, Address.PHONE_NUMBER, "Address_PhoneNumber");
		
		log.info("Test_01_Add_Address_Successfully: Input Fax number to textbox");
		addressPage.sendKeyToTextBoxByID(driver, Address.FAX_NUMBER, "Address_FaxNumber");
		
		log.info("Test_01_Add_Address_Successfully: Click to Save button");
		addressPage.clickToButtonByClassName(driver, "save-address-button");
	
		log.info("Test_01_Add_Address_Successfully: Verify First Name is saved successfully");
		verifyTrue(addressPage.getValueOfFieldByClassName("name").contains(Address.FIRST_NAME));
		
		log.info("Test_01_Add_Address_Successfully: Verify Last Name is saved successfully");
		verifyTrue(addressPage.getValueOfFieldByClassName("name").contains(Address.LAST_NAME));
		
		log.info("Test_01_Add_Address_Successfully: Verify Email is saved successfully");
		verifyTrue(addressPage.getValueOfFieldByClassName("email").contains(Address.EMAIL));
		
		log.info("Test_01_Add_Address_Successfully: Verify Phone Number is saved successfully");
		verifyTrue(addressPage.getValueOfFieldByClassName("phone").contains(Address.PHONE_NUMBER));
		
		log.info("Test_01_Add_Address_Successfully: Verify Fax Number is saved successfully");
		verifyTrue(addressPage.getValueOfFieldByClassName("fax").contains(Address.FAX_NUMBER));
		
		log.info("Test_01_Add_Address_Successfully: Verify Address 1 is saved successfully");
		verifyTrue(addressPage.getValueOfFieldByClassName("address1").contains(Address.ADDRESS_1));
		
		log.info("Test_01_Add_Address_Successfully: Verify Address 2 is saved successfully");
		verifyTrue(addressPage.getValueOfFieldByClassName("address2").contains(Address.ADDRESS_2));
		
		log.info("Test_01_Add_Address_Successfully: Verify City is saved successfully");
		verifyTrue(addressPage.getValueOfFieldByClassName("city-state-zip").contains(Address.CITY));
		
		log.info("Test_01_Add_Address_Successfully: Verify Zipcode is saved successfully");
		verifyTrue(addressPage.getValueOfFieldByClassName("city-state-zip").contains(Address.ZIPCODE));
		
		log.info("Test_01_Add_Address_Successfully: Verify Country is saved successfully");
		verifyTrue(addressPage.getValueOfFieldByClassName("country").contains(Address.COUNTRY));
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
		
	}

}
