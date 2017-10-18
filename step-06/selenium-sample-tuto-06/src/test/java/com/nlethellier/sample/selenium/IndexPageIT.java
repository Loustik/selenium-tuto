package com.nlethellier.sample.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IndexPageIT extends AbstractIT {

	@Test
	public void testWeSeeHelloWorld() {
		getDrv().get(getSiteBase().toString());

		new IndexPage(getDrv(), getSiteBase());
	}
	
	@Test
	public void testWeSeeLoremIpsum() {
		getDrv().get(getSiteBase().toString());
		Assert.assertTrue(getDrv().getPageSource().contains("Lorem Ipsum"));
	}
	
	@Test
	public void testPageTitle() {
		getDrv().get(getSiteBase().toString());
		Assert.assertEquals("Selenium sample tuto", getDrv().getTitle());
	}
	
	@Test
	public void testGetElementById() {
		getDrv().get(getSiteBase().toString());
		WebElement newParagraph = getDrv().findElement(By.id("new_paragraph"));
		Assert.assertEquals("This is a brand new paragraph", newParagraph.getText());
	}
}
