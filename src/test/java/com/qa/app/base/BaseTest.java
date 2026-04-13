package com.qa.app.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.app.factory.DriverFactory;
import com.qa.app.pages.AccountsPage;
import com.qa.app.pages.LoginPage;
import com.qa.app.pages.RegistrationPage;
import com.qa.app.pages.SearchPage;

public class BaseTest {

	WebDriver driver;
	
	DriverFactory df;
	protected Properties prop;
	
	protected LoginPage loginPage;
	protected AccountsPage accountsPage;
	protected SearchPage searchPage;
	protected RegistrationPage registrationPage;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
