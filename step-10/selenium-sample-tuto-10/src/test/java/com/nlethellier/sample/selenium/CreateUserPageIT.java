package com.nlethellier.sample.selenium;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;


public class CreateUserPageIT extends AbstractIT {

	private CreateUserPage createUserPage;
	
	@Before
	public void init() {
		createUserPage = new IndexPage(getDriver(), getWebsiteBaseUrl()).navigateToCreateUserPage();
	}
	
	
	@Test
	public void testFillInFirstName() {
		createUserPage.getFirstnameWE().sendKeys("penelope");
		Assert.assertEquals("penelope", createUserPage.getFirstnameWE().getAttribute("value"));
	}
	
	@Test
	public void testFillInLastName() {
		createUserPage.getLastnameWE().sendKeys("fillon");
		Assert.assertEquals("fillon", createUserPage.getLastnameWE().getAttribute("value"));
	}
	
	@Test
	public void testFillInAge() {
		createUserPage.getAgeWE().sendKeys("46");
		Assert.assertEquals("46", createUserPage.getAgeWE().getAttribute("value"));
	}

	@Test
	public void testSubmit() {
		createUserPage.submit("jean-pierre", "FOUCAULT", "12 ans");
	}
}

