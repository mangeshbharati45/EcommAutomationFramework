package com.qa.app.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.app.base.BaseTest;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void registrationSetup() {
		registrationPage = loginPage.navigateToRegistrationPage();
	}
	
	@Test
	public void doRegistrationTest() {
		Assert.assertTrue(registrationPage.userRegisteration("Mangesh", "QA", "3286548765", "Pass@1234", "yes"));
	}
}
