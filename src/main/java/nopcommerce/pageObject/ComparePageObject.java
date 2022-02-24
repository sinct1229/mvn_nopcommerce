package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.ComparePageUIs;

public class ComparePageObject extends BasePage{
	WebDriver driver;

	public ComparePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isProductAdded(String productCompare) {
		return isDisplayedElement(driver, ComparePageUIs.PRODUCT_NAME, productCompare);
		
	}
	

}
