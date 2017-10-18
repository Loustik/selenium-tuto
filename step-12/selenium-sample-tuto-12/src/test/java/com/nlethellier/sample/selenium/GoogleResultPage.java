package com.nlethellier.sample.selenium;

import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {

	/**
	 * @param drv A web driver.
	 * @param siteBase The root URI of a the expected site.
	 * @return Whether or not the driver is at the index page of the site.
	 */
	public static boolean isAtGoogleResultPage(WebDriver drv, URI siteBase) {
		return drv.getCurrentUrl().equals(siteBase.toString());
	}

	private final WebDriver drv;
	private final URI siteBase;
	
	@FindBy(css = "div[id='resultStats']")
	private WebElement nbResultsWE;

	
	public WebElement getNbResultsWE() {
		return nbResultsWE;
	}
	
	public GoogleResultPage(WebDriver drv, URI siteBase) {
		if (!isAtGoogleResultPage(drv, siteBase)) { 
			throw new IllegalStateException(); 
		}
		
		this.drv = drv;
		this.siteBase = siteBase;

		PageFactory.initElements(drv, this);
	}
}
