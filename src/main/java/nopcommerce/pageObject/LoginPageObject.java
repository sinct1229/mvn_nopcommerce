package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.LoginPageUIs;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public boolean isErrorMessageDisplayedByText(String message) {
		waitForElementVisible(driver, LoginPageUIs.MESSAGE_INPUT_EMPTY, message);
		return isDisplayedElement(driver, LoginPageUIs.MESSAGE_INPUT_EMPTY, message);
	}

	public boolean isSummaryErrorMessageDisplayed(String invalidEmail) {
		return isDisplayedElement(driver, LoginPageUIs.SUMMARY_ERROR, invalidEmail);
	}

	
}
