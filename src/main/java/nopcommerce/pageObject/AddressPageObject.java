package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.AddressPageUIs;

public class AddressPageObject extends BasePage{
	WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public Object getValueOfFieldByID(String ...id) {
		return getValueOfElement(driver, AddressPageUIs.TEXTBOX, id);
	}
	
	public Object getValueOfFieldByName(String ...name) {
		return getValueOfElement(driver, AddressPageUIs.OPTION, name);
	}

	public String getValueOfFieldByClassName(String className) {
		return getTextElement(driver, AddressPageUIs.TEXT, className);
	}

}
