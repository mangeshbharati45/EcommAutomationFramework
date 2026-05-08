package com.qa.app.pages;

import static com.qa.app.constants.AppConstants.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.app.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locators:
	private final By myAccount = By.xpath("(//span[contains(text(),'My account')])[2]");
	private final By loginbtn = By.xpath("//span[contains(text(),' Login')]");
	private final By Registerbtn = By.xpath("//span[contains(text(),' Register')]");
	private final By search = By.name("search");
	private final By searchIcon = By.xpath("//button[text()='Search']");
	
	// 2. public page constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. public page actions/methods
	public String getHomePageTitle() {
		String title = eleUtil.waitForTitleIs(HOME_PAGE_TITLE, DEFAULT_TIMEOUT);
		System.out.println("home page title: " + title);
		return title;
	}
	
	public RegistrationPage navigateToRegistrationPage() {
		eleUtil.waitForElementVisible(myAccount, MEDIUM_DEFAULT_TIMEOUT);
		try {
			eleUtil.doMoveToElement(myAccount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eleUtil.doClick(Registerbtn);
		return new RegistrationPage(driver);
	}
	
	public LoginPage goToLoginPage() {
		eleUtil.waitForElementVisible(myAccount, MEDIUM_DEFAULT_TIMEOUT);
		try {
			eleUtil.doMoveToElement(myAccount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eleUtil.doClick(loginbtn);
		return new LoginPage(driver);
	}
	
	public SearchPage doSearch(String searchKey) {
		eleUtil.doSendKeys(search, searchKey);
		eleUtil.doClick(searchIcon);
		return new SearchPage(driver);
	}
}
