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

	public ProductListPageObject clickToParentMenuByName(String menu) {
		clickToElement(driver, DashboardPageUIs.PARENT_MENU, menu);
		return PageGeneratorManager.getProductListPage(driver);
	}

	public void OpenProductDetail(String productTitle) {
		scrollToElement(driver, DashboardPageUIs.PRODUCT_LINK, productTitle);
		clickToElement(driver, DashboardPageUIs.PRODUCT_LINK , productTitle);
	}

	public void clickToAddYourReview() {
		clickToElement(driver, DashboardPageUIs.REVIEW);
		
	}

	public boolean isReviewAddedSuccessfully(String titleReview) {
		return isDisplayedElement(driver, DashboardPageUIs.EXISTED_REVIEW, titleReview);
	}
}
