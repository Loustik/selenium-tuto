package com.nlethellier.sample.selenium;

import java.net.URI;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public abstract class AbstractITest extends TestCase {

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

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		getDrv().manage().deleteAllCookies();
		getDrv().get(siteBase.toString());
	}
	
	@After
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		getDrv().close();
	}
}
