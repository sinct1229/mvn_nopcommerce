package nopcommerce.pageObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commons.BasePage;
import nopcommerce.pageUI.ProductListPageUIs;

public class ProductListPageObject extends BasePage {
	WebDriver driver;
	public ProductListPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void selectValueInFilter(String string) {
		selectItemInDropdownByText(driver, ProductListPageUIs.DROPDOWN, string, "products-orderby");
		waitForElementInvisible(driver, ProductListPageUIs.AJAX);

	}


	public void clickToSubMenu(String menu) {
		clickToElement(driver, ProductListPageUIs.SUB_MENU, menu);
		
	}
	
	public boolean isProductNameSortAscending() {
		List<WebElement> productNameElements = findElementsByXpath(driver, ProductListPageUIs.PRODUCT_TITLE);
		List<String> productNameText = new ArrayList<String>();
		for(WebElement productName:productNameElements) {
			productNameText.add(productName.getText());
		}
		List<String> productNameClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameClone);
		return productNameText.equals(productNameClone);
	}

	public boolean isProductNameSortDescending() {
		List<WebElement> productNameElements = findElementsByXpath(driver, ProductListPageUIs.PRODUCT_TITLE);
		List<String> productNameText = new ArrayList<String>();
		for(WebElement productName:productNameElements) {
			productNameText.add(productName.getText());
		}
		List<String> productNameClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameClone);
		Collections.reverse(productNameClone);
		return productNameText.equals(productNameClone);
	}

	public boolean isProductPriceSortDescending() {
		List<WebElement> productPriceElements = findElementsByXpath(driver, ProductListPageUIs.PRODUCT_PRICE);
		List<Float> productPriceText = new ArrayList<Float>();
		for(WebElement productPrice:productPriceElements) {
			productPriceText.add(Float.parseFloat(productPrice.getText().replace("$", "").replace(",", "")));
		}
		List<Float> productPriceClone = new ArrayList<Float>(productPriceText);
		Collections.sort(productPriceClone);
		Collections.reverse(productPriceClone);
		return productPriceText.equals(productPriceClone);
	}

	public boolean isProductPriceSortAscending() {
		List<WebElement> productPriceElements = findElementsByXpath(driver, ProductListPageUIs.PRODUCT_PRICE);
		List<Float> productPriceText = new ArrayList<Float>();
		for(WebElement productPrice:productPriceElements) {
			productPriceText.add(Float.parseFloat(productPrice.getText().replace("$", "").replace(",", "")));
		}
		List<Float> productPriceClone = new ArrayList<Float>(productPriceText);
		Collections.sort(productPriceClone);
		return productPriceText.equals(productPriceClone);
	}

	public void selectSizeOfPage(String string) {
		selectItemInDropdownByText(driver, ProductListPageUIs.DROPDOWN, string, "products-pagesize");
		//waitForElementInvisible(driver, ProductListPageUIs.AJAX);
		
	}

	public boolean isProductDisplayed(int string) {
		int count = findElementsByXpath(driver, ProductListPageUIs.PRODUCT_TITLE).size();
		if(count<= string)
			return true;
		return false;
		
	}
	
	public boolean isNextIconPagingDisplayed() {
		return isDisplayedElement(driver, ProductListPageUIs.NEXT_PAGE);
	}

	public void clickToPage2(String string) {
		clickToElement(driver,ProductListPageUIs.PAGE, string);
		
	}

	public boolean isPreviousIconDisplayed() {
		return isDisplayedElement(driver, ProductListPageUIs.PREVIOUS_PAGE);
	}
	public boolean isPagingUndisplayed() {
		return isElementUndisplay(driver, ProductListPageUIs.PAGING);
	}
}
