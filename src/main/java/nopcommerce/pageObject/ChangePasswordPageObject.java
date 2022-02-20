package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.ChangePasswordPageUIs;

public class ChangePasswordPageObject extends BasePage{
	WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isSuccessMessageDisplayed(String message) {
		return isDisplayedElement(driver, ChangePasswordPageUIs.BAR_NOTIFICATION, message);
	}
	
	public void closeBarNotification() {
		clickToElement(driver, ChangePasswordPageUIs.CLOSE_BAR_NOTIFICATION);
		waitForElementInvisible(driver, ChangePasswordPageUIs.CLOSE_BAR_NOTIFICATION);
		
	}

}
