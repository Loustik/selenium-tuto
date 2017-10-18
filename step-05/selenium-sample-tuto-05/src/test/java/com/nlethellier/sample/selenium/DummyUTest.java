package com.nlethellier.sample.selenium;

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
	public void testSumMethod() {
		MyMathApplication math = new MyMathApplication();
		Assert.assertEquals(7, math.sum(5, 2));
	}
}
