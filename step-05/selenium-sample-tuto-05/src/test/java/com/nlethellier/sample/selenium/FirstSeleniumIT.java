package com.nlethellier.sample.selenium;

import java.net.URI;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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

	@Override
	public void setUp() throws Exception {
		super.setUp();
		//website = new URI("http://localhost:8081/selenium-sample-tuto-05");
		//driver = new FirefoxDriver();
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


//import java.net.URI;
//import junit.framework.TestCase;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/applicationContext-test.xml" })
//public class FirstSeleniumIT extends TestCase{
//	
//	//@Autowired
//	private URI website;
//	
//	//@Autowired
//	private WebDriver driver;
//
//	@Override
//	public void setUp() throws Exception {
//		super.setUp();
//		website = new URI("http://localhost:8081/selenium-sample-tuto-05");
//		driver = new FirefoxDriver();
//		driver.get(website.toString());
//	}
//
////	@Override
////	public void tearDown() throws Exception {
////		super.tearDown();
////		driver.close();
////	}
//	
//	
//	@Test
//	public void testWeSeeLoremIpsum() {
//		
//		Assert.assertTrue(driver.getPageSource().contains("Lorem Ipsum"));
//	}
//	
//	@Test
//	public void testPageTitle() {
//		Assert.assertEquals("Selenium sample tuto", driver.getTitle());
//	}
//	
//	@Test
//	public void testGetElementById() {
//		WebElement newParagraph = driver.findElement(By.id("new_paragraph"));
//		Assert.assertEquals("This is a brand new paragraph", newParagraph.getText());
//	}
//	
//}

//import java.net.URI;
//import junit.framework.TestCase;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/applicationContext-test.xml" })
//public class FirstSeleniumIT extends TestCase {
//
//	@Autowired
//	private URI siteBase;
//
//	@Autowired
//	private WebDriver drv;
//
//	public URI getSiteBase() {
//		return siteBase;
//	}
//
//	public WebDriver getDrv() {
//		return drv;
//	}
//
//	@Override
//	public void setUp() throws Exception {
//		super.setUp();
//		getDrv().manage().deleteAllCookies();
//		getDrv().get(siteBase.toString());
//	}
//	
////	@Override
////	public void tearDown() throws Exception {
////		super.tearDown();
////		getDrv().close();
////	}
//	
//	
//	@Test
//	public void testWeSeeLoremIpsum() {
//		getDrv().get(getSiteBase().toString());
//		Assert.assertTrue(getDrv().getPageSource().contains("Lorem Ipsum"));
//	}
//	
//	@Test
//	public void testPageTitle() {
//		getDrv().get(getSiteBase().toString());
//		Assert.assertEquals("Selenium sample tuto", getDrv().getTitle());
//	}
//	
//	@Test
//	public void testGetElementById() {
//		getDrv().get(getSiteBase().toString());
//		WebElement newParagraph = getDrv().findElement(By.id("new_paragraph"));
//		Assert.assertEquals("This is a brand new paragraph", newParagraph.getText());
//	}
//	
//}
