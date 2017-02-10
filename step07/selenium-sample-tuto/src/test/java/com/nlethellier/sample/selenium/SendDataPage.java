
package com.nlethellier.sample.selenium;

import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendDataPage {
	public static boolean isAtSendDataPage(WebDriver drv, URI siteBase) {
		return drv.getCurrentUrl().equals(siteBase.toString() + "send-data.jsp");
	}

	private final WebDriver drv;
	private final URI siteBase;

	@FindBy(css = "form[name='send-data'] input[name='firstname']")
	private WebElement firstnameWE;

	@FindBy(css = "form[name='send-data'] input[name='lastname']")
	private WebElement lastnameWE;

	@FindBy(css = "form[name='send-data'] input[name='age']")
	private WebElement ageWE;

	@FindBy(css = "form[name='send-data'] input[type='submit']")
	private WebElement submitWE;

	public SendDataPage(WebDriver drv, URI siteBase) {
		if (!isAtSendDataPage(drv, siteBase)) { throw new IllegalStateException(); }
		PageFactory.initElements(drv, this);
		this.drv = drv;
		this.siteBase = siteBase;
	}

	public SendDataPage submit(String firstname, String lastname, String age) {
		firstnameWE.sendKeys(firstname);
		lastnameWE.sendKeys(lastname);
		ageWE.sendKeys(age);
		submitWE.click();
		return new SendDataPage(drv, siteBase);
	}
}
