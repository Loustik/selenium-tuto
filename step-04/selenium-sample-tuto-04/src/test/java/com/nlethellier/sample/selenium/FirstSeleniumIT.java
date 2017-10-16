package com.nlethellier.sample.selenium;

import java.net.URI;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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

	@Test
	public void testWeSeeLoremIpsum() {
		driver.get(website.toString());
		Assert.assertTrue(driver.getPageSource().contains("Lorem Ipsum"));
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		driver.close();
	}
}
