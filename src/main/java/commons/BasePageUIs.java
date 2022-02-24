package commons;

public class BasePageUIs {
	public static final String HEADER_BUTTON = "//div[@class = 'header-links']//li[string() = '%s']";
	public static final String BUTTON_BY_CLASS = "//button[contains(@class , '%s')]";
	public static final String BUTTON_BY_NAME = "//button[@name = '%s']";
	public static final String MESSAGE_INPUT_EMPTY = "//span[contains(string() , '%s')]";
	public static final String TEXTBOX ="//input[@id ='%s']";
	public static final String CHECKBOX_BY_ID = "//input[@id = '%s']";
	public static final String DROPDOWN = "//select[@name = '%s']";
	public static final String OPTION = "//select[@name = '%s']//option[@selected]";
	public static final String SUMMARY_ERROR = "//div[contains(string() , '%s')]";
	public static final String BAR_NOTIFICATION = "//div[contains(@class , 'success') and contains(string() , '%s')]";
	public static final String FOOTER_MENU = "//div[@class = 'footer']//a[text() = '%s']";
	public static final String PRODUCT_TITLE = "//h2[string() = '%s']";
	public static final String TEXTAREA = "//textarea[@id = '%s']";
	public static final String CHECKBOX_BY_NAME = "//input[@name = '%s']";
	public static final String LOGO = "//div[@class = 'header-logo']";
}
