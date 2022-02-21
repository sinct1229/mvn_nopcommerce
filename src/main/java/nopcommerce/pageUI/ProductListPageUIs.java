package nopcommerce.pageUI;

import commons.BasePageUIs;

public class ProductListPageUIs extends BasePageUIs{

	public static final String AJAX = "//div[@class = 'ajax-products-busy']";
	public static final String SUB_MENU = "//ul[@class = 'list']//a[text() = '%s']";
	public static final String PRODUCT_PRICE = "//div[@class = 'prices']//span[contains(@class, 'price')]";
	public static final String NEXT_PAGE = "//li[@class = 'next-page']";
	public static final String PAGE = "//li[@class = 'individual-page']//a[text() = '%s']";
	public static final String PREVIOUS_PAGE = "//li[@class = 'previous-page']";
	public static final String PAGING = "//div[@class ='pager']";

}
