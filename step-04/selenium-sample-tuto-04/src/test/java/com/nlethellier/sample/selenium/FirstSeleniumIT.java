package com.nlethellier.sample.selenium;

import java.net.URI;
import junit.framework.TestCase;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumIT extends TestCase{
	private URI website;
	private WebDriver driver;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		website = new URI("http://localhost:8081/selenuim-sample-tuto");
		driver = new FirefoxDriver();
	}

	public void testWeSeeHelloWorld() {
		driver.get(website.toString());
		Assert.assertTrue(driver.getPageSource().contains("Lorem Ipsum"));
	}
}
