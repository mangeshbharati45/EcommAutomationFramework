package com.qa.app.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.app.factory.DriverFactory;
import com.qa.app.pages.AccountsPage;
import com.qa.app.pages.HomePage;
import com.qa.app.pages.LoginPage;
import com.qa.app.pages.RegistrationPage;
import com.qa.app.pages.SearchPage;

public class BaseTest {

	WebDriver driver;
	
	DriverFactory df;
	protected Properties prop;
	
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected AccountsPage accountsPage;
	protected SearchPage searchPage;
	protected RegistrationPage registrationPage;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setup(@Optional String browserName) {

	    df = new DriverFactory();
	    prop = df.initProp();

	    if(browserName != null && !browserName.isEmpty()) {
	        prop.setProperty("browser", browserName);
	    }

	    driver = df.initDriver(prop);
	    homePage = new HomePage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
