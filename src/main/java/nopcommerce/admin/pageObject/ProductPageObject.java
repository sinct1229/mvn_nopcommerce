package nopcommerce.admin.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.admin.pageUI.ProductPageUIs;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isProductDisplayed(String productName) {
		waitForElementVisible(driver, ProductPageUIs.PRODUCT_NAME, productName);
		return isDisplayedElement(driver, ProductPageUIs.PRODUCT_NAME, productName);
	}

	public boolean isMessmageDisplayed(String message) {
		return isDisplayedElement(driver, ProductPageUIs.MESSAGE, message);
	}

	public void openFormData(String className, String classStatus) {
		if(!getElementAttribute(driver, ProductPageUIs.FORM, "class", className).contains(classStatus))
			clickToElement(driver, ProductPageUIs.FORM, className);
	}

}
