package com.qa.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.app.utils.ElementUtil;
import static com.qa.app.constants.AppConstants.*;
import com.qa.app.utils.StringUtils;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private final By firstName = By.id("input-firstname");
	private final By lastName = By.id("input-lastname");
	private final By email = By.id("input-email");
	private final By telephone = By.id("input-telephone");
	private final By password = By.id("input-password");
	private final By confirmpassword = By.id("input-confirm");

	private final By subscribeYes = By.xpath("//label[@class='custom-control-label' and text()='Yes']");
	private final By subscribeNo = By.xpath("//label[@class='custom-control-label' and text()='No']");

	private final By agreeCheckBox = By.xpath("//label[@class='custom-control-label' and text()='I have read and agree to the ']");
	private final By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private final By successMessg = By.cssSelector("div#content h1");

	private final By logoutLink = By.linkText("Logout");
	private final By registerLink = By.linkText("Register");
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public boolean userRegistration(String firstName, String lastName, 
			 String telephone, String password, String subscribe) {
		
		eleUtil.waitForElementVisible(this.firstName, DEFAULT_TIMEOUT).sendKeys(firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, StringUtils.getRandonEmailId());
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmpassword, password);
		
			if(subscribe.equalsIgnoreCase("yes")) {
				eleUtil.doClick(subscribeYes);
			} else {
				eleUtil.doClick(subscribeNo);
			}
			eleUtil.doClick(agreeCheckBox);
			eleUtil.doClick(continueButton);
			
			
			if(eleUtil.waitForElementVisible(successMessg, MEDIUM_DEFAULT_TIMEOUT).getText().contains(REGISTER_SUCCESS_MESSG)) {
				eleUtil.doClick(logoutLink);
				eleUtil.doClick(registerLink);
				return true;
			}
			return false;
	}

	

}
