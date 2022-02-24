package nopcommerce.pageUI;

import commons.BasePageUIs;

public class WishlistPageUIs extends BasePageUIs{
	public static final String PRODUCT_NAME = "//td[@class = 'product']/a[text() = '%s']";
	public static final String MESSAGE = "//div[@class = 'no-data' and normalize-space(.) = 'The wishlist is empty!']";
	public static final String PRODUCT_NAME_COMPARE = "//tr[@class = 'product-name']/td[string() = '%s']";
	public static final String PRODUCT_TITLE_RECENTLY_VIEWED = "//h2[@class = 'product-title']/a[text() = '%s']";
}
