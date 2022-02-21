package com.nopcommerce.myAccount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.MyAccountData;

import commons.BaseTest;
import commons.GlobalConstants;
import nopcommerce.pageObject.AddressPageObject;
import nopcommerce.pageObject.DashboardPageObject;
import nopcommerce.pageObject.LoginPageObject;
import nopcommerce.pageObject.MyAccountPageObject;
import nopcommerce.pageObject.PageGeneratorManager;

public class Review extends BaseTest{
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
		
		log.info("Pre-condition: Step 3 - Login to site");
		
		loginPage.sendKeyToTextBoxByID(driver, GlobalConstants.EMAIL, "Email");
		
		loginPage.sendKeyToTextBoxByID(driver, GlobalConstants.PASSWORD, "Password");
		
		loginPage.clickToButtonByClassName(driver, "login-button");
		
		dashboardPage = PageGeneratorManager.getDashboardPage(driver);
		
	}
	
	@Test
	public void Test_01_Add_Review_Success() {
		log.info("Open detail of a product");
		dashboardPage.OpenProductDetail(MyAccountData.Review.PRODUCT);
		
		log.info("click to text Add review");
		dashboardPage.clickToAddYourReview();
		
		log.info("Input title");
		dashboardPage.sendKeyToTextBoxByID(driver, MyAccountData.Review.TITLE_REVIEW, "AddProductReview_Title");
		
		log.info("Input content review");
		dashboardPage.sendKeyToTextAreaByID(driver, MyAccountData.Review.TEXT_REVIEW, "AddProductReview_ReviewText");
		
		log.info("Rating");
		dashboardPage.checkToCheckBoxOrRadioByID(driver, "addproductrating_4");
		
		log.info("Click To Submit review");
		dashboardPage.clickToButtonByClassName(driver, "write-product-review-button");
		
		log.info("Verify add review successfully");
		verifyTrue(dashboardPage.isReviewAddedSuccessfully(MyAccountData.Review.TITLE_REVIEW));
		
		log.info("Open my account page");
		myAccountPage = (MyAccountPageObject) dashboardPage.clickToHeaderButton(driver, "My account");
		
		log.info("Open my review page");
		myAccountPage.openMenuByText("My product reviews");
		
		log.info("Verify add review successfully");
		verifyTrue(myAccountPage.isReviewAddedSuccessfully(MyAccountData.Review.TITLE_REVIEW));
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
