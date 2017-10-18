package com.nlethellier.sample.selenium;

import java.net.URI;
import java.net.URISyntaxException;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoogleResultPageIT extends AbstractIT {

	private static final String GOOGLE_BASE_URL = "http://www.google.fr";
	private static URI GOOGLE_BASE_URI;
	private GoogleResultPage googleResultPage;

	@Before
	public void init() {
		try {
			GOOGLE_BASE_URI = new URI(GOOGLE_BASE_URL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		googleResultPage = new GoogleResultPage(getDriver(), GOOGLE_BASE_URI);
		setWebsiteBaseUrl(GOOGLE_BASE_URI);
	}
	
	
	
	@Test
	public void testValuesAfterRedirection() {
		assertTrue(GoogleResultPage.isAtGoogleResultPage(getDriver(), GOOGLE_BASE_URI));
		String result = googleResultPage.getNbResultsWE().getText();
		Assert.assertThat(result, CoreMatchers.containsString("secondes"));
	}
	
}
