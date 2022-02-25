package nopcommerce.admin.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.admin.pageUI.ProductDetailPageUIs;

public class ProductDetailPageObject extends BasePage{
	WebDriver driver;

	public ProductDetailPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isProductDetailPageDisplayed() {
		return isDisplayedElement(driver, ProductDetailPageUIs.TITLE_DETAIL_PAGE);
	}
	

}
