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

public class Sort extends BaseTest{
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
	public void Test_01_Sort_A_To_Z() {
		log.info("Select option in filter");
		productListPage.selectValueInFilter("Name: A to Z");
		
		log.info("Verify sort successfully");
		verifyTrue(productListPage.isProductNameSortAscending());
	}
	
	@Test
	public void Test_02_Sort_Z_To_A() {
		log.info("Click to sub menu");
		productListPage.clickToSubMenu("Notebooks ");
		
		log.info("Select option in filter");
		productListPage.selectValueInFilter("Name: Z to A");
		
		log.info("Verify sort successfully");
		verifyTrue(productListPage.isProductNameSortDescending());
	}
	
	@Test
	public void Test_03_Sort_Low_To_High() {
		log.info("Click to sub menu");
		productListPage.clickToSubMenu("Notebooks ");
		
		log.info("Select option in filter");
		productListPage.selectValueInFilter("Price: Low to High");
		
		log.info("Verify sort successfully");
		verifyTrue(productListPage.isProductPriceSortAscending());
	}
	
	@Test
	public void Test_04_Sort_High_To_Low() {
		log.info("Click to sub menu");
		productListPage.clickToSubMenu("Notebooks ");
		
		log.info("Select option in filter");
		productListPage.selectValueInFilter("Price: High to Low");
		
		log.info("Verify sort successfully");
		verifyTrue(productListPage.isProductPriceSortDescending());
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
