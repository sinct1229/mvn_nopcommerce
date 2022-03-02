package nopcommerce.admin.pageUI;

import commons.BasePageUIs;

public class CustomerPageUIs extends BasePageUIs{
	public static final String  CUSTOMER_ROLE_DROPDOWN = "//label[@id = 'SelectedCustomerRoleIds_label']/ancestor::div[@class = 'col-md-3']/following-sibling::div//div[contains(@class, 'k-multiselect-clearable')]";
	public static final String CUSTOMER_ROLE_VALUE = "//ul[@id = 'SelectedCustomerRoleIds_taglist']/li";
	public static final String SUCCESS__ALERT = "//div[contains(@class, 'alert-success')]";
	public static final String EMAIL_IN_TABLE = "//table[@id = 'customers-grid']//td[normalize-space() = '%s']";
}
