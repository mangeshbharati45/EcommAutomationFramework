package com.qa.app.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.app.base.BaseTest;
import static com.qa.app.constants.AppConstants.*;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetup() {
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

}
