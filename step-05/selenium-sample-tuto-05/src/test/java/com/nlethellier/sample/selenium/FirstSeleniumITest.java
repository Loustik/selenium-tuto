package com.nlethellier.sample.selenium;

import java.net.URI;
import junit.framework.TestCase;

import org.junit.After;
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
public class FirstSeleniumITest extends TestCase{

	@Autowired
	private URI siteBase;

	@Autowired
	private WebDriver drv;

	public URI getSiteBase() {
		return siteBase;
	}

	public WebDriver getDrv() {
		return drv;
	}

	//@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		getDrv().manage().deleteAllCookies();
		getDrv().get(siteBase.toString());
	}
	
	//@After
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		getDrv().close();
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
