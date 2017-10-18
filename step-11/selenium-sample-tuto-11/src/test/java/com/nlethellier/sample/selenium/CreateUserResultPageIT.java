package com.nlethellier.sample.selenium;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;


public class CreateUserResultPageIT extends AbstractIT {

	private CreateUserResultPage createUserResultPage;
	
	@Before
	public void init() {
		createUserResultPage = new IndexPage(getDriver(), getWebsiteBaseUrl()).navigateToCreateUserPage().submit("Patrice", "CAINE", "41");
	}
	
	
	@Test
	public void testRedirectionUrl() {
		assertTrue(CreateUserResultPage.isAtCreateUserResultPage(getDriver(), getWebsiteBaseUrl()));
	}
	
	@Test
	public void testValuesAfterRedirection() {
		String result = createUserResultPage.getResultSentenceWE().getAttribute("value");
		Assert.assertThat(result, CoreMatchers.containsString("Patrice CAINE"));
		Assert.assertThat(result, CoreMatchers.containsString("41 years old"));
	}
	
}

