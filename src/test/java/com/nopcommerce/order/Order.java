package com.nopcommerce.order;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.OrderData;

import commons.BaseTest;
import commons.GlobalConstants;
import nopcommerce.pageObject.AddressPageObject;
import nopcommerce.pageObject.CartPageObject;
import nopcommerce.pageObject.DashboardPageObject;
import nopcommerce.pageObject.LoginPageObject;
import nopcommerce.pageObject.PageGeneratorManager;
import nopcommerce.pageObject.ProductDetailPageObject;

public class Order extends BaseTest{
	WebDriver driver;
	DashboardPageObject dashboardPage;
	LoginPageObject loginPage;
	AddressPageObject addressPage;
	ProductDetailPageObject productDetailPage;
	CartPageObject cartPage;
	
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
		
		dashboardPage.OpenProductDetail(OrderData.PRODUCT);
		
		productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
	}
	

	@Test
	public void Test_01_Add_Product_To_cart() {
		
		log.info("Select processor");
		productDetailPage.selectOptionByText(driver, "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]", "product_attribute_1");
		
		
		log.info("Select RAM");
		productDetailPage.selectOptionByText(driver, "2 GB", "product_attribute_2");
		
		log.info("Select HDD");
		productDetailPage.checkToCheckBoxOrRadioByID(driver, "product_attribute_3_6");
		
		log.info("Select OS");
		productDetailPage.checkToCheckBoxOrRadioByID(driver, "product_attribute_4_8");
		
		
		log.info("Select Software");
		productDetailPage.checkToCheckBoxOrRadioByID(driver, "product_attribute_5_10");
		
		
		log.info("Click to Add to cart button");
		productDetailPage.clickToButtonByClassName(driver, "add-to-cart-button");
		
		log.info("Verify bar notification is displayed");
		productDetailPage.isSuccessMessageDisplayed();
		
		log.info("Close Bả notification");
		productDetailPage.closeBarNotification();
	}
	
	@AfterClass
	public void afterClass() {
		
	}
}
