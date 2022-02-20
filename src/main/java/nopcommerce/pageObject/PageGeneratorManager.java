package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;


public class PageGeneratorManager {
	private static LoginPageObject loginPage;
	private static RegisterPageObject registerPage;
	private static DashboardPageObject dashboardPage;
	private static MyAccountPageObject myAccontPage;
	private static CustomerInforPageObject customerInfoPage;
	private static AddressPageObject addressPage;
	private static ChangePasswordPageObject changePasswordPage;
	
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		if (dashboardPage == null) {
			return new DashboardPageObject(driver);
		}
		return new DashboardPageObject(driver);
	}
	
	public static BasePage getLoginPage(WebDriver driver) {
		if (loginPage == null) {
			return new LoginPageObject(driver);
		}
		return new LoginPageObject(driver);
	}
	
	public static BasePage getRegisterPage(WebDriver driver) {
		if (registerPage == null) {
			return new RegisterPageObject(driver);
		}
		return new RegisterPageObject(driver);
	}

	public static BasePage getMyAccountPage(WebDriver driver) {
		if (myAccontPage == null) {
			return new MyAccountPageObject(driver);
		}
		return new MyAccountPageObject(driver);
		
	}

	public static BasePage getCustomerInfoPage(WebDriver driver) {
		if (customerInfoPage == null) {
			return new CustomerInforPageObject(driver);
		}
		return new CustomerInforPageObject(driver);
	}

	public static BasePage getAddressPage(WebDriver driver) {
		if (addressPage == null) {
			return new AddressPageObject(driver);
		}
		return new AddressPageObject(driver);
	}

	public static BasePage getChangePasswordPage(WebDriver driver) {
		if (changePasswordPage == null) {
			return new ChangePasswordPageObject(driver);
		}
		return new ChangePasswordPageObject(driver);
	}

}
