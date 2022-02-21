package com.nopcommerce.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import nopcommerce.pageObject.DashboardPageObject;
import nopcommerce.pageObject.PageGeneratorManager;
import nopcommerce.pageObject.ProductListPageObject;

public class Paging extends BaseTest{
	WebDriver driver;
	DashboardPageObject dashboardPage;
	ProductListPageObject productListPage;
	
	@Parameters({"browser","appURL"})
	@BeforeClass
	public void beforeClass(String browser, String appURL) {
		log.info("Pre-condition: Step 1 - Open browser '" + browser + "' navigate to '" + appURL + "'");
		driver = getBrowserDriver(browser, appURL);
		dashboardPage = (DashboardPageObject) PageGeneratorManager.getDashboardPage(getDriver());
		
		log.info("Open sub menu");
		productListPage = dashboardPage.clickToParentMenuByName("Computers ");
		productListPage.clickToSubMenu("Notebooks ");
	}
	
	@Test
	public void Test_01_Show_3_Products() {
		log.info("Click to sub menu");
		productListPage.clickToSubMenu("Notebooks ");
		
		log.info("Select option in filter");
		productListPage.selectSizeOfPage("3");
		
		log.info("Verify show 3 product in page");
		verifyTrue(productListPage.isProductDisplayed(3));
		
		log.info("Verify paging displayed");
		verifyTrue(productListPage.isNextIconPagingDisplayed());
		
		log.info("Click to page 2");
		productListPage.clickToPage2("2");
		
		log.info("Verify previous icon is displayed");
		verifyTrue(productListPage.isPreviousIconDisplayed());
	}
	
	@Test
	public void Test_02_Show_6_Products() {
		log.info("Click to sub menu");
		productListPage.clickToSubMenu("Notebooks ");
		
		log.info("Select option in filter");
		productListPage.selectSizeOfPage("6");
		
		log.info("Verify show 6 product in page");
		verifyTrue(productListPage.isProductDisplayed(6));
		
		log.info("Verify no paging exist");
		verifyFalse(productListPage.isPagingUndisplayed());
		
	}
	
	@Test
	public void Test_03_Show_9_Products() {
		log.info("Click to sub menu");
		productListPage.clickToSubMenu("Notebooks ");
		
		log.info("Select option in filter");
		productListPage.selectSizeOfPage("9");
		
		log.info("Verify show 9 product in page");
		verifyTrue(productListPage.isProductDisplayed(9));
		
		log.info("Verify paging displayed");
		verifyTrue(productListPage.isPagingUndisplayed());
		
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
		
	}
}
