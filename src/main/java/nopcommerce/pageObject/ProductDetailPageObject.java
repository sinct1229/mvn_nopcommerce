package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.ProductDetailPageUIs;

public class ProductDetailPageObject extends BasePage {
	WebDriver driver;

	public ProductDetailPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isSuccessMessageDisplayed() {
		return isDisplayedElement(driver, ProductDetailPageUIs.BAR_NOTIFICATION, "The product has been added to your ");
	}

	public void closeBarNotification() {
		clickToElement(driver, ProductDetailPageUIs.CLOSE);
		sleepInSecond(1);
		
	}
}
