package com.nlethellier.sample.selenium;

import java.net.URI;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public abstract class AbstractIT extends TestCase {

	@Autowired
	private URI websiteBaseUrl;
	
	@Autowired
	private WebDriver driver;

	public URI getWebsiteBaseUrl() {
		return websiteBaseUrl;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		getDriver().manage().deleteAllCookies();
		getDriver().get(getWebsiteBaseUrl().toString());
	}
}
