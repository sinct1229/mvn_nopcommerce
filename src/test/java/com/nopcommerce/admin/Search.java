package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.adminData.SearchData;

import commons.BaseTest;
import commons.GlobalConstants;
import nopcommerce.admin.pageObject.HomePageObject;
import nopcommerce.admin.pageObject.LoginPageObject;
import nopcommerce.admin.pageObject.PageGeneratorManager;
import nopcommerce.admin.pageObject.ProductDetailPageObject;
import nopcommerce.admin.pageObject.ProductPageObject;

public class Search extends BaseTest{
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	ProductPageObject productPage;
	ProductDetailPageObject productDetail;
	
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
		
		log.info("Click to Catalog");
		homePage.openParentMenuByText("Catalog");
		
		log.info("Click to Products");
		productPage = (ProductPageObject) homePage.openChildMenu(driver, "Products");
	}
	
	@Test
	public void Test_01_Search_By_Product_Name() {
		log.info("Open block Search");
		productPage.openFormData("search-row", "opened");
		
		log.info("Input keyword to product name field");
		productPage.sendKeyToTextBoxByID(driver, SearchData.PRODUCT, "SearchProductName");
		
		log.info("click to Search button");
		productPage.clickToButtonByClassName(driver, "btn-search");
		
		
		log.info("Verify " + SearchData.PRODUCT + " is displayed");
		verifyTrue(productPage.isProductDisplayed(SearchData.PRODUCT));

	}
	
	@Test
	public void Test_02_Search_Name_ParentCate_NoSubCate() {
		log.info("Click to Products");
		productPage.openChildMenu(driver, "Products");
		
		log.info("Input keyword to product name field");
		productPage.sendKeyToTextBoxByID(driver, SearchData.SearchOption.PRODUCT, "SearchProductName");
		
		log.info("Select Parent Category");
		productPage.selectOptionByText(driver, SearchData.SearchOption.PARENT_CATE, "SearchCategoryId");
		
		log.info("Click to Search button");
		productPage.clickToButtonByClassName(driver, "btn-search");
		
		log.info("Verify table result is empty");
		verifyTrue(productPage.isMessmageDisplayed(SearchData.SearchOption.DATA_EMPTY));
	}
	
	
	@Test
	public void Test_03_Search_Name_Parent_Sub() {
		log.info("Click to Products");
		productPage.openChildMenu(driver, "Products");
		
		log.info("Input keyword to product name field");
		productPage.sendKeyToTextBoxByID(driver, SearchData.SearchOption.PRODUCT, "SearchProductName");
		
		log.info("Select Parent Category");
		productPage.selectOptionByText(driver, SearchData.SearchOption.PARENT_CATE, "SearchCategoryId");
		
		log.info("Check to Sub categories");
		productPage.checkToCheckBoxOrRadioByID(driver, "SearchIncludeSubCategories");
		
		log.info("Click to Search button");
		productPage.clickToButtonByClassName(driver, "btn-search");
		
		log.info("Verify " + SearchData.PRODUCT + " is displayed");
		verifyTrue(productPage.isProductDisplayed(SearchData.SearchOption.PRODUCT));
	}
	
	@Test
	public void Test_04_Search_Name_Child_Category() {
		log.info("Click to Products");
		productPage.openChildMenu(driver, "Products");
		
		log.info("Input keyword to product name field");
		productPage.sendKeyToTextBoxByID(driver, SearchData.SearchOption.PRODUCT, "SearchProductName");
		
		log.info("Select Child Category");
		productPage.selectOptionByText(driver, SearchData.SearchOption.CHILD_CATE, "SearchCategoryId");
		
		log.info("Click to Search button");
		productPage.clickToButtonByClassName(driver, "btn-search");
		
		log.info("Verify " + SearchData.PRODUCT + " is displayed");
		verifyTrue(productPage.isProductDisplayed(SearchData.SearchOption.PRODUCT));
		
	}
	
	@Test
	public void Test_05_Search_With_Manufacturer() {
		log.info("Click to Products");
		productPage.openChildMenu(driver, "Products");
		
		log.info("Input keyword to product name field");
		productPage.sendKeyToTextBoxByID(driver, SearchData.SearchOption.PRODUCT, "SearchProductName");
		
		log.info("Select manufacturer");
		productPage.selectOptionByText(driver, SearchData.SearchOption.MANUFACTURER, "SearchManufacturerId");
		
		log.info("Click to Search button");
		productPage.clickToButtonByClassName(driver, "btn-search");
		
		log.info("Verify table result is empty");
		verifyTrue(productPage.isMessmageDisplayed(SearchData.SearchOption.DATA_EMPTY));
		
	}
	
	@Test
	public void Test_06_Go_To_Product_SKU() {
		log.info("Click to Products");
		productPage.openChildMenu(driver, "Products");
		
		log.info("Input SKU");
		productPage.sendKeyToTextBoxByID(driver, SearchData.SKU, "GoDirectlyToSku");
		
		log.info("Click to Go button");
		productPage.clickToButtonByName(driver, "go-to-product-by-sku");
		productDetail = (ProductDetailPageObject) PageGeneratorManager.getProductDetailPage(driver);
		
		log.info("Verify product detail is displayed");
		verifyTrue(productDetail.isProductDetailPageDisplayed());
		
		
	}
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
		
	}

}
