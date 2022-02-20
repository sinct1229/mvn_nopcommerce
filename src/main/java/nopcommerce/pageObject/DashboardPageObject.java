package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.DashboardPageUIs;

public class DashboardPageObject extends BasePage{
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public boolean isLogOutTextIsDisplayed() {
		return isDisplayedElement(driver, DashboardPageUIs.HEADER_BUTTON, "Log out");
	}

	public void closeBarNotification() {
		clickToElement(driver, DashboardPageUIs.CLOSE_BAR_NOTIFICATION);
		waitForElementInvisible(driver, DashboardPageUIs.CLOSE_BAR_NOTIFICATION);
		
	}
}
