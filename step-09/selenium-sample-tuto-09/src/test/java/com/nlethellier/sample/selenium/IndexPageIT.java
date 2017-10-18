package com.nlethellier.sample.selenium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IndexPageIT extends AbstractIT {

	private IndexPage indexPage;

	@Before
	public void init() {
		indexPage = new IndexPage(getDriver(), getWebsiteBaseUrl());
	}
	
	
	@Test
	public void testWeSeeLoremIpsum() {
		Assert.assertTrue(getDriver().getPageSource().contains("Lorem Ipsum"));
	}
	
	@Test
	public void testPageTitle() {
		Assert.assertEquals("Selenium sample tuto", getDriver().getTitle());
	}
	
	@Test
	public void testGetElementById() {
		WebElement newParagraph = getDriver().findElement(By.id("new_paragraph"));
		Assert.assertEquals("This is a brand new paragraph", newParagraph.getText());
	}
	
	@Test
	public void testCreateUserLinkPresence() {
		Assert.assertNotNull(indexPage.getCreateUserLinkWE());
		Assert.assertEquals("a", indexPage.getCreateUserLinkWE().getTagName());
		Assert.assertEquals("Create user", indexPage.getCreateUserLinkWE().getText());
	}
	
	@Test
	public void testNavigateToSendDataPage() {
		indexPage.navigateToCreateUserPage();
		assertTrue(CreateUserPage.isAtCreateUserPage(getDriver(), getWebsiteBaseUrl()));
	}
}
