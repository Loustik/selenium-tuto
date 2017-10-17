package com.nlethellier.sample.selenium;

import java.net.URI;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumITest extends TestCase{
	private URI website;
	private WebDriver driver;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		website = new URI("http://localhost:8081/selenium-sample-tuto-04");
		driver = new FirefoxDriver();
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		driver.close();
	}
	
	
	@Test
	public void testWeSeeLoremIpsum() {
		driver.get(website.toString());
		Assert.assertTrue(driver.getPageSource().contains("Lorem Ipsum"));
	}
	
	@Test
	public void testPageTitle() {
		driver.get(website.toString());
		Assert.assertEquals("Selenium sample tuto", driver.getTitle());
	}
	
	@Test
	public void testGetElementById() {
		driver.get(website.toString());
		WebElement newParagraph = driver.findElement(By.id("new_paragraph"));
		Assert.assertEquals("This is a brand new paragraph", newParagraph.getText());
	}
	
}
