package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.WishlistPageUIs;

public class WishlistPageObject extends BasePage {
	WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isProductDisplayedInWishlistPage(String product) {
		return isDisplayedElement(driver, WishlistPageUIs.PRODUCT_NAME, product);
	}

	public boolean isMessageDisplayed(String message) {
		return isDisplayedElement(driver, WishlistPageUIs.MESSAGE, message);
	}

}
