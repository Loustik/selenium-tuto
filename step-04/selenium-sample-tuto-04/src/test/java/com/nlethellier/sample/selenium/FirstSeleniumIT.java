package com.nlethellier.sample.selenium;

import java.net.URI;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class FirstSeleniumIT extends TestCase{
	private URI website;
	private WebDriver driver;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		website = new URI("http://localhost:8081/selenium-sample-tuto-04");
		driver = new FirefoxDriver();
	}

	@Override
	protected void tearDown() throws Exception {
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
	
	@Test
	public void interactWithPage() {
		driver.get(website.toString());
		WebElement loremParagraph = driver.findElement(By.id("lorem"));
		loremParagraph.clear();
		loremParagraph.sendKeys("New Lorem Ipsum paragraph, edited by Selenium");
		Assert.assertEquals("New Lorem Ipsum paragraph, edited by Selenium", loremParagraph.getText());
	}
	
}
