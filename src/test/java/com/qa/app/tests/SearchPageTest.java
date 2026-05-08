package com.qa.app.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.app.base.BaseTest;

public class SearchPageTest extends BaseTest {
	
	@BeforeClass
	public void searchSetup() {
		loginPage = homePage.goToLoginPage();
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void productSearchTest() {
		searchPage = accountsPage.doSearch("macbook");
		int actResultsCount = searchPage.getResultsProductCount();
		Assert.assertEquals(actResultsCount, 6);
	}

	
}
