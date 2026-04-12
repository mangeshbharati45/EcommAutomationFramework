package com.qa.app.pages;

import static com.qa.app.constants.AppConstants.*;

import org.openqa.selenium.WebDriver;

import com.qa.app.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccountsPageTitle() {
		String title = eleUtil.waitForTitleIs(ACCOUNT_PAGE_TITLE, DEFAULT_TIMEOUT);
		System.out.println("account page title: " + title);
		return title;
		
	}

	public String getAccountPageURL() {
		String url = eleUtil.waitForURLContains(ACCOUNT_PAGE_FRACTION_URL, DEFAULT_TIMEOUT);
		System.out.println("account page url: " + url);
		return url;
	}
}
