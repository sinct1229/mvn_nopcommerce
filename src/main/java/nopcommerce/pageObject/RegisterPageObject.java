package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.RegisterPageUIs;

public class RegisterPageObject extends BasePage{
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isErrorMessageDisplayedByText(String message) {
		waitForElementVisible(driver, RegisterPageUIs.MESSAGE_INPUT_EMPTY, message);
		return isDisplayedElement(driver, RegisterPageUIs.MESSAGE_INPUT_EMPTY, message);
	}

	public boolean isExistedEMailErrorDisplayed(String existedEmail) {
		return isDisplayedElement(driver, RegisterPageUIs.SUMMARY_ERROR, existedEmail);
	}

	public boolean isSuccessMessageDisplayed(String registerSuccess) {
		return isDisplayedElement(driver, RegisterPageUIs.REGISTER_SUCCESS, registerSuccess);
	}
}
