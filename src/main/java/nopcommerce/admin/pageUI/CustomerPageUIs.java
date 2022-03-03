package nopcommerce.admin.pageUI;

import commons.BasePageUIs;

public class CustomerPageUIs extends BasePageUIs{
	public static final String  CUSTOMER_ROLE_DROPDOWN = "//label[@id = 'SelectedCustomerRoleIds_label']/ancestor::div[@class = 'col-md-3']/following-sibling::div//div[contains(@class, 'k-multiselect-clearable')]";
	public static final String CUSTOMER_ROLE_VALUE = "//ul[@id = 'SelectedCustomerRoleIds_taglist']/li";
	public static final String SUCCESS__ALERT = "//div[contains(@class, 'alert-success')]";
	public static final String COLUMN_TABLE = "//table[@id = 'customers-grid']//td[normalize-space() = '%s']";
	public static final String EDIT_BUTTON = "//td//a[text() = 'Edit']";
	public static final String FORM_DATA = "//div[@id = '%s']";
	public static final String BUTTON_BY_TEXT = "//button[normalize-space() = '%s']";
	public static final String EDIT_ADDRESS_BUTTON = "//td[normalize-space() = '%s']/following-sibling::td//a[normalize-space() = 'Edit']";
	public static final String DELETE_ADDRESS_BUTTON = "//td[normalize-space() = '%s']/following-sibling::td//a[normalize-space() = 'Delete']";
}
