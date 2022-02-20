package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.DashboardPageUIs;
import nopcommerce.pageUI.MyAccountPageUIs;

public class MyAccountPageObject extends BasePage{

	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public BasePage openMenuByText(String name) {
		waitForElementInvisible(driver, DashboardPageUIs.CLOSE_BAR_NOTIFICATION);
		clickToElement(driver, MyAccountPageUIs.MENU_OPTION, name);
		switch (name) {
		case "Customer info":
			return PageGeneratorManager.getCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneratorManager.getAddressPage(driver);
		default:
			return PageGeneratorManager.getMyAccountPage(driver);
		}
		
	}
}
