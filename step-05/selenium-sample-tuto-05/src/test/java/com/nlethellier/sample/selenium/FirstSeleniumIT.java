package com.nlethellier.sample.selenium;

import java.net.URI;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class FirstSeleniumIT extends TestCase{
	
	@Autowired
	private URI website;
	
	@Autowired
	private WebDriver driver;

	public URI getWebsite() {
		return website;
	}

	public WebDriver getDriver() {
		return driver;
	}


	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		getDriver().manage().deleteAllCookies();
		getDriver().get(getWebsite().toString());
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
	
}
