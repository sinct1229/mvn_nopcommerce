package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.CustomerInfoPageUIs;

public class CustomerInforPageObject extends BasePage{
	WebDriver driver;

	public CustomerInforPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public Object getValueOfFieldByID(String ...id) {
		return getValueOfElement(driver, CustomerInfoPageUIs.TEXTBOX, id);
	}
	
	public Object getValueOfFieldByName(String ...name) {
		return getValueOfElement(driver, CustomerInfoPageUIs.OPTION, name);
	}
}
