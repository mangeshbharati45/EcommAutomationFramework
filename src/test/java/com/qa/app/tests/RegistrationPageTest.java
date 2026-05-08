package com.qa.app.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.app.base.BaseTest;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void registrationSetup() {
		loginPage = homePage.goToLoginPage();
		registrationPage = loginPage.navigateToRegistrationPage();
	}
	
	@DataProvider
	public Object[][] getUserRegTestData() {
		return new Object[][] {
			{"Mangesh", "QA", "3286548765", "Pass@1234", "yes"},
			{"visha", "qe", "3284548765", "Pass@1234", "no"},
			{"Archana", "verma", "3281548765", "Pass@1234", "yes"},
		};
	}
	
	@Test(dataProvider = "getUserRegTestData")
	public void userRegistrationTest(String fname, String lname, String telephone, String password, String subscribe) {
		Assert.assertTrue(registrationPage.userRegistration(fname, lname, telephone, password, subscribe));
	}
}
