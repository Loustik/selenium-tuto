package com.nlethellier.sample.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IndexPageIT extends AbstractIT {

	@Test
	public void testWeSeeHelloWorld() {
		getDrv().get(getSiteBase().toString());

		new IndexPage(getDrv(), getSiteBase());
	}
}
