package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.CartPageUIs;

public class CartPageObject extends BasePage{
	WebDriver driver;

	public CartPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isShoppingCartDisplayed() {
		return isDisplayedElement(driver, CartPageUIs.TITLE_PAGE);
	}

	
}
