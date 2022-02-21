package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import nopcommerce.pageObject.PageGeneratorManager;

public class BasePage {

	private WebDriverWait explicit;
	Select select;
	JavascriptExecutor jE;
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement findElementByXpath(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public String getDynamicLocator(String locator, String... params) {
		return String.format(locator, (Object[]) params);
	}
	
	public void clickToElement(WebDriver driver, String locator, String... params) {
		waitForElementClickable(driver, locator, params);
		findElementByXpath(driver, getDynamicLocator(locator, params)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value, String... params) {
		findElementByXpath(driver, getDynamicLocator(locator, params)).clear();
		findElementByXpath(driver, getDynamicLocator(locator, params)).sendKeys(value);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		findElementByXpath(driver, locator).clear();
		findElementByXpath(driver, locator).sendKeys(value);
	}

	public void selectItemInDropdownByText(WebDriver driver, String locator, String text) {
		select = new Select(findElementByXpath(driver, locator));
		select.selectByVisibleText(text);
	}
	
	public void selectItemInDropdownByText(WebDriver driver, String locator, String text, String ...params) {
		select = new Select(findElementByXpath(driver, getDynamicLocator(locator, params)));
		select.selectByVisibleText(text);
	}

	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		select = new Select(findElementByXpath(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public void sleepInSecond(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		sleepInSecond(1);
		findElementByXpath(driver, parentLocator).click();
		sleepInSecond(1);

		explicit = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		List<WebElement> allItems = explicit
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jE = (JavascriptExecutor) driver;
				jE.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	public void selectItemInEditableDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedTextItem) {
		findElementByXpath(driver, parentLocator).click();
		sleepInSecond(1);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				if (item.isDisplayed()) { 
					item.click();
				}	else { 
					jE.executeScript("arguments[0].scrollIntoView(true);", item);
					item.click();
				}
				break;
			}
		}
	}

	public String getTextElement(WebDriver driver, String locator, String... params) {
		return findElementByXpath(driver, getDynamicLocator(locator, params)).getText();
	}

	public String getValueOfElement(WebDriver driver, String locator, String... params) {
		return findElementByXpath(driver, getDynamicLocator(locator, params)).getAttribute("value");
	}
	
	public boolean isChecked(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isSelected();
	}
	
	public boolean isChecked(WebDriver driver, String locator, String...params) {
		return findElementByXpath(driver, getDynamicLocator(locator, params)).isSelected();
	}

	public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
		if (!findElementByXpath(driver, locator).isSelected())
			findElementByXpath(driver, locator).click();
	}

	public void uncheckTheCheckBox(WebDriver driver, String locator) {
		if (findElementByXpath(driver, locator).isSelected())
			findElementByXpath(driver, locator).click();
	}

	public boolean isDisplayedElement(WebDriver driver, String locator, String... params) {
		return findElementByXpath(driver, getDynamicLocator(locator, params)).isDisplayed();
	}

	public void scrollToElement(WebDriver driver, String locator, String... params) {
		jE = (JavascriptExecutor) driver;
		jE.executeScript("arguments[0].scrollIntoView(true);",
				findElementByXpath(driver, getDynamicLocator(locator, params)));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jE = (JavascriptExecutor) driver;
		boolean status = (boolean) jE.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				findElementByXpath(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		explicit = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		explicit.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		explicit = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		explicit.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... params) {
		explicit = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		explicit.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, params))));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicit = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		explicit.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator, String... params) {
		explicit = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		explicit.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}
	
	public void waitForElementPresence(WebDriver driver, String locator) {
		explicit = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		explicit.until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
	}

	public void waitForAlertPresent(WebDriver driver, String locator) {
		explicit = new WebDriverWait(driver, GlobalConstants.LONG_TIME);
		explicit.until(ExpectedConditions.alertIsPresent());
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public boolean isElementUndisplay(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIME);
		List<WebElement> elements = findElementsByXpath(driver, locator);
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIME);
		if (elements.size() == 0)
			return true;
		else if (elements.size() > 0 && !elements.get(0).isDisplayed())
			return true;
		return false;
	}
	
	public boolean isElementUndisplay(WebDriver driver, String locator, String...params) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIME);
		List<WebElement> elements = findElementsByXpath(driver, getDynamicLocator(locator, params));
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIME);
		if (elements.size() == 0)
			return true;
		else if (elements.size() > 0 && !elements.get(0).isDisplayed())
			return true;
		return false;
	}
	
	public void scrollToTopPage(WebDriver driver) {
		jE = (JavascriptExecutor) driver;
		jE.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

	}
	
	public void scrollToBottomPage(WebDriver driver) {
		jE = (JavascriptExecutor) driver;
		jE.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}
	
	public Set<Cookie> getAllCookies(WebDriver driver){
		return driver.manage().getCookies();
	}

	public void setCookie(WebDriver driver, Set<Cookie> allCookies) {
		for(Cookie cookie:allCookies) {
			driver.manage().addCookie(cookie);
		}
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	// --------------------
	
	public BasePage clickToHeaderButton(WebDriver driver, String name) {
		clickToElement(driver, BasePageUIs.HEADER_BUTTON, name);
		switch (name) {
		case "Register":
			return PageGeneratorManager.getRegisterPage(driver);
		case "Log in":
			return PageGeneratorManager.getLoginPage(driver);
		case "My account":
			return PageGeneratorManager.getMyAccountPage(driver);
		case "Log out":
			return PageGeneratorManager.getDashboardPage(driver);
		default:
			return PageGeneratorManager.getDashboardPage(driver);
		}
	}

	public void clickToButtonByName(WebDriver driver, String name) {
		scrollToElement(driver, BasePageUIs.BUTTON_BY_NAME, name);
		waitForElementClickable(driver, BasePageUIs.BUTTON_BY_NAME, name);
		clickToElement(driver, BasePageUIs.BUTTON_BY_NAME, name);
	}
	
	public void clickToButtonByClassName(WebDriver driver, String className) {
		scrollToElement(driver, BasePageUIs.BUTTON_BY_CLASS, className);
		waitForElementClickable(driver, BasePageUIs.BUTTON_BY_CLASS, className);
		clickToElement(driver, BasePageUIs.BUTTON_BY_CLASS, className);
	}

	public void checkToCheckBoxOrRadioByID(WebDriver driver, String id) {
		if( isChecked(driver, BasePageUIs.GENDER_CHECKBOX, id)!= true) {
			clickToElement(driver, BasePageUIs.GENDER_CHECKBOX, id);
		}
		
	}
	
	public void sendKeyToTextBoxByID(WebDriver driver, String value, String id) {
		sendkeyToElement(driver, BasePageUIs.TEXTBOX, value, id);
	}
	
	public void sendKeyToTextAreaByID(WebDriver driver, String value, String id) {
		sendkeyToElement(driver, BasePageUIs.TEXTAREA, value, id);
	}
	

	public void selectOptionByText(WebDriver driver, String value, String...params) {
		selectItemInDropdownByText(driver, BasePageUIs.DROPDOWN, value, params);
	}
	
	public BasePage openPageInFooterByName(WebDriver driver, String pageName) {
		scrollToBottomPage(driver);
		clickToElement(driver, BasePageUIs.FOOTER_MENU, pageName);
		switch (pageName) {
		case "Search":
			return PageGeneratorManager.getSearchPage(driver);

		default:
			return PageGeneratorManager.getDashboardPage(driver);
		}
		
	}
	
	






























}
