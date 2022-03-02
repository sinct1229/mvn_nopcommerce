package nopcommerce.admin.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.admin.pageUI.CustomerPageUIs;

public class CustomerPageObject extends BasePage{
	WebDriver driver;

	public CustomerPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickToAddNewButton(String pageName) {
		clickToElement(driver, CustomerPageUIs.ADMIN_ADD_NEW_BUTTON, pageName);
		
	}

	public void selectCustomerRole(String string) {
		selectItemInCustomDropdown(driver, CustomerPageUIs.CUSTOMER_ROLE_DROPDOWN, CustomerPageUIs.CUSTOMER_ROLE_VALUE, string);
		
	}

	public boolean isAlertSuccessDisplayed() {
		return isDisplayedElement(driver, CustomerPageUIs.SUCCESS__ALERT);
	}

	public boolean isCustomerDisplayed(String string) {
		return isDisplayedElement(driver, CustomerPageUIs.COLUMN_TABLE, string);
	}
	
	
	

}
