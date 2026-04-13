package com.qa.app.constants;

import java.util.List;

public class AppConstants {

	public static final int DEFAULT_TIMEOUT = 5;
	public static final int MEDIUM_DEFAULT_TIMEOUT = 10;
	public static final int LONG_DEFAULT_TIMEOUT = 15;
		
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String LOGIN_PAGE_FRACTION_URL = "account/login";
	public static final String ACCOUNT_PAGE_FRACTION_URL = "account/account";

	public static final List<String> EXPECTED_HEADERS_LIST = List.of("My Account", "My Orders", "My Affiliate Account");
	
	public static final String REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
}
