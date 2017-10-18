
package com.nlethellier.sample.selenium;

import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserResultPage extends AbstractPage {
	
	/**
	 * @param drv A web driver.
	 * @param siteBase The root URI of a the expected site.
	 * @return Whether or not the driver is at the page holding the result.
	 */
	public static boolean isAtCreateUserResultPage(WebDriver drv, URI siteBase) {
		return drv.getCurrentUrl().equals(siteBase.toString() + "create-user-results.jsp");
	}

	private final WebDriver drv;
	private final URI siteBase;

	@FindBy(xpath = "p[name='result']")
	private WebElement resultSentenceWE;

	public WebElement getResultSentenceWE() {
		return resultSentenceWE;
	}

	public CreateUserResultPage(WebDriver drv, URI siteBase) {
		if (!isAtCreateUserResultPage(drv, siteBase)) { 
			throw new IllegalStateException(); 
		}
		
		this.drv = drv;
		this.siteBase = siteBase;

		PageFactory.initElements(drv, this);
	}

}
