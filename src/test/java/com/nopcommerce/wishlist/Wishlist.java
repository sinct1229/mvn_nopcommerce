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
import nopcommerce.pageObject.CartPageObject;
import nopcommerce.pageObject.ComparePageObject;
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
	CartPageObject cartPage;
	ComparePageObject comparePage;
	
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
	public void Test_02_Add_To_Cart() {
		log.info("Click To checkbox add to cart");
		wishlistPage.checkToCheckBoxOrRadioByName(driver, "addtocart");
		
		log.info("Click to add to cart button");
		wishlistPage.clickToButtonByName(driver, "addtocartbutton");
		
		log.info("Move to Cart page");
		cartPage = (CartPageObject) PageGeneratorManager.getCartPage(driver);
		
		log.info("Verify 'Shopping cart' is displayed");
		verifyTrue(cartPage.isShoppingCartDisplayed());
		
		
	}
	
	@Test
	public void Test_03_Remove_From_Wishlist() {
		
		log.info("Open home page");
		dashboardPage = wishlistPage.openDashboardPage(driver);
		
		log.info("Open product detail");
		dashboardPage.OpenProductDetail(WishlistData.PRODUCT_NAME);
		productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
		
		log.info("Click to wishlist button");
		productDetailPage.clickToButtonByClassName(driver, "add-to-wishlist-button");
		
		log.info("Open wishlist page");
		wishlistPage = (WishlistPageObject) productDetailPage.openPageInFooterByName(driver, "Wishlist");
		
		log.info("Click to remove button");
		wishlistPage.clickToButtonByClassName(driver, "remove-btn");
		
		log.info("Verify The wishlist is empty! is displayed");
		verifyTrue(wishlistPage.isMessageDisplayed(WishlistData.EMPTY_MESSAGE));
		
	}
	
	@Test
	public void Test_04_Add_To_Compare() {
		log.info("Open home page");
		dashboardPage = wishlistPage.openDashboardPage(driver);
		
		log.info("Open product detail");
		dashboardPage.OpenProductDetail(WishlistData.PRODUCT_COMPARE_1);
		productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
		
		log.info("Click to Add to compare list button");
		productDetailPage.clickToButtonByClassName(driver, "add-to-compare-list-button");
		
		log.info("Close bar notification");
		productDetailPage.closeBarNotification();
		
		log.info("Open home page");
		dashboardPage = wishlistPage.openDashboardPage(driver);
		
		log.info("Open product detail");
		dashboardPage.OpenProductDetail(WishlistData.PRODUCT_COMPARE_2);
		productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
		
		log.info("Click to Add to compare list button");
		productDetailPage.clickToButtonByClassName(driver, "add-to-compare-list-button");
		
		log.info("Close bar notification");
		productDetailPage.closeBarNotification();
		
		log.info("Open compare product list page");
		comparePage = (ComparePageObject) productDetailPage.openPageInFooterByName(driver, "Compare products list");
		
		log.info("Verify " + WishlistData.PRODUCT_COMPARE_1 + " is added successfully");
		verifyTrue(comparePage.isProductAdded(WishlistData.PRODUCT_COMPARE_1));
		
		log.info("Verify " + WishlistData.PRODUCT_COMPARE_2 + " is added successfully");
		verifyTrue(comparePage.isProductAdded(WishlistData.PRODUCT_COMPARE_2));
		
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
