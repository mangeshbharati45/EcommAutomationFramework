package com.qa.app.tests;

import static com.qa.app.constants.AppConstants.HOME_PAGE_TITLE;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.app.base.BaseTest;

public class HomePageTest extends BaseTest {
	@Test
	public void HomePageTitleTest() {
		String actTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actTitle, HOME_PAGE_TITLE);
	}
}
