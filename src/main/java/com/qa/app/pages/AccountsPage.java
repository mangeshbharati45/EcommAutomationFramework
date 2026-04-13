package com.qa.app.pages;

import static com.qa.app.constants.AppConstants.ACCOUNT_PAGE_FRACTION_URL;
import static com.qa.app.constants.AppConstants.ACCOUNT_PAGE_TITLE;
import static com.qa.app.constants.AppConstants.DEFAULT_TIMEOUT;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.app.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private final By headers = By.cssSelector("div#content>div>h2");
	private final By search = By.name("search");
	private final By searchIcon = By.xpath("//button[text()='Search']");
	
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
	
	public List<String> getAccountsPageHeaders() {
		List<WebElement> headerList = eleUtil.getElements(headers);
		List<String> headerValList = new ArrayList<String>();
		for(WebElement e: headerList) {
			String text = e.getText();
			headerValList.add(text);
		}
		System.out.println("Account Page headers "+headerValList);
		return headerValList;		
	}
	
	public SearchPage doSearch(String searchKey) {
		eleUtil.doSendKeys(search, searchKey);
		eleUtil.doClick(searchIcon);
		return new SearchPage(driver);
	}
}
