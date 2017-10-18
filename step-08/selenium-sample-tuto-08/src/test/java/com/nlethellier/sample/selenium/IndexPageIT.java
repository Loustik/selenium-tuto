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
	public void testFormPageLinkPresence() {
		Assert.assertNotNull(indexPage.getSendDataLinkWE());
		Assert.assertEquals("a", indexPage.getSendDataLinkWE().getTagName());
		Assert.assertEquals("Send data", indexPage.getSendDataLinkWE().getText());
	}
	
	@Test
	public void testThatShouldFail() {
		Assert.assertNotNull(indexPage.getSendDataLinkWE());
		Assert.assertEquals("This is not the link title", indexPage.getSendDataLinkWE().getText());
	}
}
