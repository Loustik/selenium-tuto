package com.nlethellier.sample.selenium;

import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleQueryPage {

	/**
	 * @param drv A web driver.
	 * @param siteBase The root URI of a the expected site.
	 * @return Whether or not the driver is at the index page of the site.
	 */
	public static boolean isAtGoogleQueryPage(WebDriver drv, URI siteBase) {
		return drv.getCurrentUrl().equals(siteBase.toString());
	}

	private final WebDriver drv;
	private final URI siteBase;
	
	@FindBy(css = "input[name='lst-ib']")
	private WebElement inputWE;

	
	public WebElement getInputWE() {
		return inputWE;
	}
	
	@FindBy(css = "input[name='btnK']")
	private WebElement submitButtonWE;

	
	public WebElement getSubmitButtonWE() {
		return submitButtonWE;
	}
	
	public GoogleQueryPage(WebDriver drv, URI siteBase) {
		if (!isAtGoogleQueryPage(drv, siteBase)) { 
			throw new IllegalStateException(); 
		}
		
		this.drv = drv;
		this.siteBase = siteBase;

		PageFactory.initElements(drv, this);
	}
}
