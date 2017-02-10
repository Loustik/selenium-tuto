package com.nlethellier.sample.selenium;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DummyUnitTest {

	public DummyUnitTest() {
	}

	@Rule
  public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testSum() {
		MyMathApplication math = new MyMathApplication();
		Assert.assertEquals(math.sum(5, 2), 7);
	}
}
