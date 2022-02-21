package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUI.MyAccountPageUIs;

public class MyAccountPageObject extends BasePage{

	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public BasePage openMenuByText(String name) {
		clickToElement(driver, MyAccountPageUIs.MENU_OPTION, name);
		switch (name) {
		case "Customer info":
			return PageGeneratorManager.getCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneratorManager.getAddressPage(driver);
		case "Change password":
			return PageGeneratorManager.getChangePasswordPage(driver);
		default:
			return PageGeneratorManager.getMyAccountPage(driver);
		}
		
	}

	public boolean isReviewAddedSuccessfully(String titleReview) {
		return isDisplayedElement(driver, MyAccountPageUIs.EXISTED_REVIEW, titleReview);
	}
}
