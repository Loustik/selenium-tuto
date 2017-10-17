package com.nlethellier.sample.selenium;

import java.net.URI;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DummyUTest {


	public DummyUTest() {
	}

	@Rule
  public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testSum() {
		MyMathApplication math = new MyMathApplication();
		Assert.assertEquals(math.sum(5, 2), 7);
	}
}
