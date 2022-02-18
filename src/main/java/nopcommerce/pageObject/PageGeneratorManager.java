package nopcommerce.pageObject;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	private static LoginPageObject loginPage;
	private static RegisterPageObject registerPage;
	private static DashboardPageObject dashboardPage;
	
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		if (dashboardPage == null) {
			return new DashboardPageObject(driver);
		}
		return new DashboardPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if (loginPage == null) {
			return new LoginPageObject(driver);
		}
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if (registerPage == null) {
			return new RegisterPageObject(driver);
		}
		return new RegisterPageObject(driver);
	}

}
