package com.qa.app.pages;

import static com.qa.app.constants.AppConstants.DEFAULT_TIMEOUT;
import static com.qa.app.constants.AppConstants.LOGIN_PAGE_FRACTION_URL;
import static com.qa.app.constants.AppConstants.LOGIN_PAGE_TITLE;
import static com.qa.app.constants.AppConstants.MEDIUM_DEFAULT_TIMEOUT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.app.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locators:
	private final By email = By.id("input-email");
	private final By password = By.id("input-password");
	private final By loginBtn = By.xpath("//input[@value='Login']");
	private final By forgotPwdLink = By.linkText("Forgotten Password");
	private final By registerLink = By.linkText("Register");

	// 2. public page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. public page actions/methods
	@Step("Login Page Title")
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleIs(LOGIN_PAGE_TITLE, DEFAULT_TIMEOUT);
		System.out.println("login page title: " + title);
		return title;
	}
	
	@Step("Login Page Url")
	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContains(LOGIN_PAGE_FRACTION_URL, DEFAULT_TIMEOUT);
		System.out.println("login page url: " + url);
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.isElementDisplayed(forgotPwdLink);
			
	}
	
	public AccountsPage doLogin(String username, String pwd) {
		System.out.println("user credentials: " + username + ":" + pwd);
		eleUtil.waitForElementVisible(email, MEDIUM_DEFAULT_TIMEOUT).sendKeys(username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}
	
//	public RegistrationPage navigateToRegistrationPage() {
//		eleUtil.doClick(registerLink);
//		return new RegistrationPage(driver);
//	}
}
