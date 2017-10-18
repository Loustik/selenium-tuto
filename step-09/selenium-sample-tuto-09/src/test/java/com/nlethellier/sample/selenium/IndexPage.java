package com.nlethellier.sample.selenium;

import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends AbstractPage {

	/**
	 * @param drv A web driver.
	 * @param siteBase The root URI of a the expected site.
	 * @return Whether or not the driver is at the index page of the site.
	 */
	public static boolean isAtIndexPage(WebDriver drv, URI siteBase) {
		return drv.getCurrentUrl().equals(siteBase.toString());
	}

	private final WebDriver drv;
	private final URI siteBase;
	
	@FindBy(css = "a[href='send-data.jsp']")
	private WebElement createUserLinkWE;

	
	public WebElement getCreateUserLinkWE() {
		return createUserLinkWE;
	}
	
	public CreateUserPage navigateToCreateUserPage() {
		getCreateUserLinkWE().click();
		return new CreateUserPage(drv, siteBase);
	}

	
	public IndexPage(WebDriver drv, URI siteBase) {
		if (!isAtIndexPage(drv, siteBase)) { 
			throw new IllegalStateException(); 
		}
		
		this.drv = drv;
		this.siteBase = siteBase;

		PageFactory.initElements(drv, this);
	}
}
