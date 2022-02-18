package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DashboardPageObject extends BasePage{
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
}
