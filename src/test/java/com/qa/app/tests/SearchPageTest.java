package com.qa.app.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.app.base.BaseTest;

public class SearchPageTest extends BaseTest {
	
	@Test
	public void productSearchForLoginUserTest() {
		loginPage = homePage.goToLoginPage();
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		searchPage = accountsPage.doSearch("macbook");
		int actResultsCount = searchPage.getResultsProductCount();
		Assert.assertEquals(actResultsCount, 6);
	}
	
	@Test
	public void productSearchForGuestUserTest() {
		searchPage = homePage.doSearch("macbook");
		int actResultsCount = searchPage.getResultsProductCount();
		Assert.assertEquals(actResultsCount, 6);
	}
	
	

	
}
