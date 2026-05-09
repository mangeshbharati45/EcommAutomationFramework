package com.qa.app.tests;

import static com.qa.app.constants.AppConstants.ACCOUNT_PAGE_TITLE;
import static com.qa.app.constants.AppConstants.LOGIN_PAGE_FRACTION_URL;
import static com.qa.app.constants.AppConstants.LOGIN_PAGE_TITLE;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.app.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Feature("F50: Login")
@Epic("Epic 100: Design Login Page")
@Story("US 101: implement Login Page")
public class LoginPageTest extends BaseTest {
	
	@BeforeClass
	public void loginPageSetup() {
		loginPage = homePage.goToLoginPage();
	}
	
	@Owner("Mangesh")
	@Description("checking login page title")
	@Severity(SeverityLevel.NORMAL)
	@Test(description = "checking login page title")
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, "log");
	}
	
	@Owner("Mangesh")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(LOGIN_PAGE_FRACTION_URL));
	}
	
	@Owner("Mangesh")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Owner("Mangesh")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void loginTest() {
		 accountsPage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountsPage.getAccountsPageTitle(), ACCOUNT_PAGE_TITLE);
	}
}
