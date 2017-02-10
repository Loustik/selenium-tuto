package com.nlethellier.sample.selenium;

import static org.junit.Assert.*;

import org.junit.Test;

public class SendDataPageIT extends AbstractIT {

	@Test
	public void testSubmit() {
		new IndexPage(getDrv(), getSiteBase()).sendData().submit("penelope", "fillon", "46");
	}

}
