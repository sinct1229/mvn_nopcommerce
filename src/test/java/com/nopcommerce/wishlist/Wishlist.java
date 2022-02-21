package com.nopcommerce.wishlist;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.WishlistData;

import commons.BaseTest;
import commons.GlobalConstants;
import nopcommerce.pageObject.AddressPageObject;
import nopcommerce.pageObject.DashboardPageObject;
import nopcommerce.pageObject.LoginPageObject;
import nopcommerce.pageObject.PageGeneratorManager;
import nopcommerce.pageObject.ProductDetailPageObject;
import nopcommerce.pageObject.WishlistPageObject;

public class Wishlist extends BaseTest{
	WebDriver driver;
	DashboardPageObject dashboardPage;
	LoginPageObject loginPage;
	AddressPageObject addressPage;
	ProductDetailPageObject productDetailPage;
	WishlistPageObject wishlistPage;
	
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
		
		dashboardPage.OpenProductDetail(WishlistData.PRODUCT_NAME);
		
		productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
	}
	
	@Test
	public void Test_01_Add_Product_To_Wishlist() {
		log.info("Click to wishlist button");
		productDetailPage.clickToButtonByClassName(driver, "add-to-wishlist-button");
		
		log.info("Verify success message is displayed");
		verifyTrue(productDetailPage.isSuccessMessageDisplayed());
		productDetailPage.closeBarNotification();
		
		log.info("Open wishlist page");
		wishlistPage = (WishlistPageObject) productDetailPage.openPageInFooterByName(driver, "Wishlist");
		
		log.info("Verify product is added to wishlist page");
		verifyTrue(wishlistPage.isProductDisplayedInWishlistPage(WishlistData.PRODUCT_NAME));
		
	}
	
	@Test
	public void Test_03_Remove_From_Wishlist() {
		
		log.info("Open wishlist page");
		wishlistPage = (WishlistPageObject) productDetailPage.openPageInFooterByName(driver, "Wishlist");
		
		log.info("Click to remove button");
		wishlistPage.clickToButtonByClassName(driver, "removefromcart");
		
		log.info("Verify The wishlist is empty! is displayed");
		verifyTrue(wishlistPage.isMessageDisplayed(WishlistData.EMPTY_MESSAGE));
		
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
