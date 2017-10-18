package com.nlethellier.sample.selenium;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SendDataPageIT extends AbstractIT {

	private SendDataPage sendDataPage;
	
	@Before
	public void init() {
		sendDataPage = new SendDataPage(getDriver(), getWebsite());
	}
	
//	@Test
//	public void testSubmit() {
//		sendDataPage.submit("penelope", "fillon", "46");
//	}
	
	@Test
	public void testFillInFirstName() {
		sendDataPage.getFirstnameWE().sendKeys("penelope");
	}
	
	@Test
	public void testFillInLastName() {
		sendDataPage.getFirstnameWE().sendKeys("fillon");
	}
	
	@Test
	public void testFillInAge() {
		sendDataPage.getFirstnameWE().sendKeys("46");
	}

}
