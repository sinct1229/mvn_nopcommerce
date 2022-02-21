package nopcommerce.pageUI;

import commons.BasePageUIs;

public class DashboardPageUIs extends BasePageUIs{
	public static final String CLOSE_BAR_NOTIFICATION = "//div[@id = 'bar-notification']//span[@class = 'close']";
	public static final String PARENT_MENU = "//ul[contains(@class , 'top-menu') and contains(@class , 'notmobile')]//a[text() = '%s']";
	public static final String REVIEW = "//div[@class = 'product-review-links']//a[text() = 'Add your review']";
	public static final String EXISTED_REVIEW = "//div[@class = 'review-title']//strong[text() = '%s']";
	public static final String PRODUCT_LINK = "//h2[@class = 'product-title']/a[text() = '%s']";

}
