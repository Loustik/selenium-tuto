package com.nlethellier.sample.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IndexPageIT extends AbstractIT {

	@Test
	public void testWeSeeHelloWorld() {
		getDriver().get(getWebsite().toString());

		new IndexPage(getDriver(), getWebsite());
	}
	
	@Test
	public void testWeSeeLoremIpsum() {
		getDriver().get(getWebsite().toString());
		Assert.assertTrue(getDriver().getPageSource().contains("Lorem Ipsum"));
	}
	
	@Test
	public void testPageTitle() {
		getDriver().get(getWebsite().toString());
		Assert.assertEquals("Selenium sample tuto", getDriver().getTitle());
	}
	
	@Test
	public void testGetElementById() {
		getDriver().get(getWebsite().toString());
		WebElement newParagraph = getDriver().findElement(By.id("new_paragraph"));
		Assert.assertEquals("This is a brand new paragraph", newParagraph.getText());
	}
}
