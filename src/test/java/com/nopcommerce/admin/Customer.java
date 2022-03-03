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
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.EMAIL, "Email");
		
		
		log.info("Input password");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.PASSWORD, "Password");
		
		
		log.info("Input first name");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.FIRST_NAME, "FirstName");
		
		log.info("Input last name");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.LAST_NAME, "LastName");
		
		log.info("Select gender");
		customerPage.checkToCheckBoxOrRadioByID(driver, "Gender_Female");
		
		
		log.info("Input day of birth");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.DATE_OF_BIRTH, "DateOfBirth");
		
		log.info("Input company name");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.COMPANY, "Company");
		
		log.info("Select customer role");
		customerPage.selectCustomerRole(CustomerData.Customer.CUSTOMER_ROLE);
		
		
		log.info("Input admin comment");
		customerPage.sendKeyToTextAreaByID(driver, CustomerData.Customer.ADMIN_COMMENT, "AdminComment");
		
		log.info("Click Save button");
		customerPage.clickToButtonByName(driver, "save");
		
		log.info("Verify create customer successfully");
		verifyTrue(customerPage.isAlertSuccessDisplayed());
		
	}
	
	@Test
	public void Test_02_Seach_Customer_Email() {
		log.info("Refresh page");
		customerPage.refreshCurrentPage(driver);
		
		log.info("Input keyword to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.EMAIL, "SearchEmail");
		
		
		log.info("Click search button");
		customerPage.clickToButtonByClassName(driver, "btn-search");
		
		
		log.info("Verify only one customer is displayed");
		verifyTrue(customerPage.isCustomerDisplayed(CustomerData.Customer.EMAIL));
		
	}
	
	@Test
	public void Test_03_Search_Firstname_Lastname() {
		log.info("Refresh page");
		customerPage.refreshCurrentPage(driver);
		
		log.info("Input keyword to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.FIRST_NAME, "SearchFirstName");
		
		log.info("Input keyword to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.LAST_NAME, "SearchLastName");
		
		log.info("Click search button");
		customerPage.clickToButtonByClassName(driver, "btn-search");
		
		log.info("Verify only one customer is displayed");
		verifyTrue(customerPage.isCustomerDisplayed(CustomerData.Customer.FIRST_NAME +" " + CustomerData.Customer.LAST_NAME));
	}
	
	@Test
	public void Test_04_Search_With_Company() {
		log.info("Refresh page");
		customerPage.refreshCurrentPage(driver);
		
		log.info("Input keyword to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.COMPANY, "SearchCompany");
		
		log.info("Click search button");
		customerPage.clickToButtonByClassName(driver, "btn-search");
		
		log.info("Verify only one customer is displayed");
		verifyTrue(customerPage.isCustomerDisplayed(CustomerData.Customer.COMPANY));
	}
	
	@Test
	public void Test_05_Search_With_Full_Data() {
		log.info("Refresh page");
		customerPage.refreshCurrentPage(driver);
		
		log.info("Input email to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.EMAIL, "SearchEmail");
		
		log.info("Input first name to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.FIRST_NAME, "SearchFirstName");
		
		log.info("Input last name to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.LAST_NAME, "SearchLastName");
		
		log.info("select month");
		customerPage.selectOptionByText(driver, CustomerData.Customer.MONTH, "SearchMonthOfBirth");
		
		log.info("select day");
		customerPage.selectOptionByText(driver, CustomerData.Customer.DAY, "SearchDayOfBirth");
		
		log.info("Input company to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.COMPANY, "SearchCompany");
		
		log.info("Click search button");
		customerPage.clickToButtonByClassName(driver, "btn-search");
		
		log.info("Verify only one customer is displayed");
		verifyTrue(customerPage.isCustomerDisplayed(CustomerData.Customer.EMAIL));
	}
	
	@Test
	public void Test_06_Edit_Customer() {
		log.info("Refresh page");
		customerPage.refreshCurrentPage(driver);
		
		log.info("Input keyword to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Customer.EMAIL, "SearchEmail");
		
		log.info("Click search button");
		customerPage.clickToButtonByClassName(driver, "btn-search");
		
		log.info("Click to Edit button");
		customerPage.clickToEditButton();
		
		log.info("Input email");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditCustomer.EDIT_EMAIL, "Email");
		
		
		log.info("Input password");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditCustomer.EDIT_PASSWORD, "Password");
		
		
		log.info("Input first name");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditCustomer.EDIT_FIRST_NAME, "FirstName");
		
		log.info("Input last name");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditCustomer.EDIT_LAST_NAME, "LastName");
		
		log.info("Select gender");
		customerPage.checkToCheckBoxOrRadioByID(driver, "Gender_Female");
		
		
		log.info("Input day of birth");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditCustomer.EDIT_DATE_OF_BIRTH, "DateOfBirth");
		
		log.info("Input company name");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditCustomer.EDIT_COMPANY, "Company");
		
		log.info("Select customer role");
		customerPage.selectCustomerRole(CustomerData.EditCustomer.EDIT_CUSTOMER_ROLE);
		
		
		log.info("Input admin comment");
		customerPage.sendKeyToTextAreaByID(driver, CustomerData.EditCustomer.EDIT_ADMIN_COMMENT, "AdminComment");
		
		log.info("Click Save button");
		customerPage.clickToButtonByName(driver, "save");
		
		log.info("Verify success message is displayed");
		customerPage.isAlertSuccessDisplayed();
	}
	
	@Test
	public void Test_07_Add_New_Address() {
		log.info("Refresh page");
		customerPage.refreshCurrentPage(driver);
		
		log.info("Input keyword to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditCustomer.EDIT_EMAIL, "SearchEmail");
		
		log.info("Click search button");
		customerPage.clickToButtonByClassName(driver, "btn-search");
		
		log.info("Click to Edit button");
		customerPage.clickToEditButton();
		
		log.info("Open form data");
		customerPage.openFormData("customer-address");
		
		log.info("Click to Add new address button");
		customerPage.clickToButtonByText("Add new address");
		
		log.info("Input FirstName to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Address.FIRST_NAME, "Address_FirstName");
		
		log.info("Inpt LastName to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Address.LAST_NAME, "Address_LastName");
		
		log.info("Input Email to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Address.EMAIL, "Address_Email");
		
		log.info("Input company to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Address.COMPANY, "Address_Company");
		
		log.info("Select country");
		customerPage.selectOptionByText(driver, CustomerData.Address.COUNTRY, "Address.CountryId");
		
		log.info("Input city to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Address.CITY, "Address_City");
		
		log.info("Input address 1");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Address.ADDRESS_1, "Address_Address1");
		
		log.info("Input address 2");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Address.ADDRESS_2, "Address_Address2");
		
		log.info("Input Zipcode to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Address.ZIPCODE, "Address_ZipPostalCode");
		
		log.info("Input Phone number to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Address.PHONE_NUMBER, "Address_PhoneNumber");
		
		log.info("Input Fax number to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.Address.FAX_NUMBER, "Address_FaxNumber");
		
		log.info("Click Save button");
		customerPage.clickToButtonByText("Save");
		
		log.info("Verify success message is displayed");
		customerPage.isAlertSuccessDisplayed();
	}
	
	@Test
	public void Test_08_Edit_Customer_Address() {
		
		log.info("Click to Customers");
		customerPage = (CustomerPageObject) homePage.openChildMenu(driver, "Customers");
		
		log.info("Input keyword to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditCustomer.EDIT_EMAIL, "SearchEmail");
		
		log.info("Click search button");
		customerPage.clickToButtonByClassName(driver, "btn-search");
		
		log.info("Click to Edit button");
		customerPage.clickToEditButton();
		
		log.info("Open form data");
		customerPage.openFormData("customer-address");
		
		log.info("Click to edit address");
		customerPage.clickToEditButtonInAddress(CustomerData.Address.EMAIL);
		
		log.info("Input FirstName to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditAddress.EDIT_FIRST_NAME, "Address_FirstName");
		
		log.info("Inpt LastName to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditAddress.EDIT_LAST_NAME, "Address_LastName");
		
		log.info("Input Email to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditAddress.EDIT_EMAIL, "Address_Email");
		
		log.info("Input company to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditAddress.EDIT_COMPANY, "Address_Company");
		
		log.info("Select country");
		customerPage.selectOptionByText(driver, CustomerData.EditAddress.EDIT_COUNTRY, "Address.CountryId");
		
		log.info("Input city to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditAddress.EDIT_CITY, "Address_City");
		
		log.info("Input address 1");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditAddress.EDIT_ADDRESS_1, "Address_Address1");
		
		log.info("Input address 2");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditAddress.EDIT_ADDRESS_2, "Address_Address2");
		
		log.info("Input Zipcode to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditAddress.EDIT_ZIPCODE, "Address_ZipPostalCode");
		
		log.info("Input Phone number to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditAddress.EDIT_PHONE_NUMBER, "Address_PhoneNumber");
		
		log.info("Input Fax number to textbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditAddress.EDIT_FAX_NUMBER, "Address_FaxNumber");
		
		log.info("Click Save button");
		customerPage.clickToButtonByText("Save");
		
		log.info("Verify success message is displayed");
		customerPage.isAlertSuccessDisplayed();
	}
	
	@Test
	public void Test_09_Delete_Custemer_Address() {
		log.info("Click to Customers");
		customerPage = (CustomerPageObject) homePage.openChildMenu(driver, "Customers");
		
		log.info("Input keyword to searchbox");
		customerPage.sendKeyToTextBoxByID(driver, CustomerData.EditAddress.EDIT_EMAIL, "SearchEmail");
		
		log.info("Click search button");
		customerPage.clickToButtonByClassName(driver, "btn-search");
		
		log.info("Click to Edit button");
		customerPage.clickToEditButton();
		
		log.info("Open form data");
		customerPage.openFormData("customer-address");
		
		log.info("Click to Delete button");
		customerPage.clickToDeleteAddressButton(CustomerData.EditAddress.EDIT_EMAIL);
		
		log.info("Verify success message is displayed");
		customerPage.isAlertSuccessDisplayed();
	}
	
	@AfterClass
	public void afterClass() {
		
	}
}
