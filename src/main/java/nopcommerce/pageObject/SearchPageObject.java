package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.SearchPageUIs;

public class SearchPageObject extends BasePage{
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isErrorMessageDisplayed(String message) {
		return isDisplayedElement(driver, SearchPageUIs.MESSAGE, message);
	}

	public boolean isProductDisplayed(String productName) {
		return isDisplayedElement(driver, SearchPageUIs.PRODUCT_TITLE, productName);
	}

}
