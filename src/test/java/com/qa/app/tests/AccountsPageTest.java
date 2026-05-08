package com.qa.app.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.app.base.BaseTest;
import static com.qa.app.constants.AppConstants.*;

import java.util.List;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetup() {
		loginPage = homePage.goToLoginPage();
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void accountsPageTitleTest() {
		String title = accountsPage.getAccountsPageTitle();
		Assert.assertEquals(title, ACCOUNT_PAGE_TITLE);
	}
	
	@Test
	public void loginPageURLTest() {
		String actURL = accountsPage.getAccountPageURL();
		Assert.assertTrue(actURL.contains(ACCOUNT_PAGE_FRACTION_URL));
	}
	
	@Test
	public void accountPageHeaderTest() {
		List<String> actHeaderList = accountsPage.getAccountsPageHeaders();
		Assert.assertEquals(actHeaderList, EXPECTED_HEADERS_LIST);
	}

}
