package nopcommerce.admin.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.admin.pageUI.HomePageUIs;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void openParentMenuByText(String menuName) {
		clickToElement(driver, HomePageUIs.PARENT_MENU, menuName);
		
	}

	
}
