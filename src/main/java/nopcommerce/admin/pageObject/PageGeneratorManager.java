package nopcommerce.admin.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneratorManager {
	private static HomePageObject homePage;
	private static LoginPageObject loginPage;
	private static ProductPageObject productPage;
	private static ProductDetailPageObject productDetailPage;
	private static CustomerPageObject customerPage;
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if(homePage == null)
			return new HomePageObject(driver);
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		if(loginPage == null)
			return new LoginPageObject(driver);
		return new LoginPageObject(driver);
	}

	public static BasePage getProductPage(WebDriver driver) {
		if(productPage == null)
			return new ProductPageObject(driver);
		return new ProductPageObject(driver);
	}
	
	public static BasePage getProductDetailPage(WebDriver driver) {
		if(productDetailPage == null)
			return new ProductDetailPageObject(driver);
		return new ProductDetailPageObject(driver);
	}

	public static BasePage getCustomerPage(WebDriver driver) {
		if(customerPage == null)
			return new CustomerPageObject(driver);
		return new CustomerPageObject(driver);
	}
	

}
