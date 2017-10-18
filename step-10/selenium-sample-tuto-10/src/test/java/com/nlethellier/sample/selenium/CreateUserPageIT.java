package com.nlethellier.sample.selenium;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;


public class CreateUserPageIT extends AbstractIT {

	private CreateUserPage createUserPage;
	
	@Before
	public void init() {
		createUserPage = new IndexPage(getDriver(), getWebsiteBaseUrl()).navigateToCreateUserPage();
	}
	
	
	@Test
	public void testFillInFirstName() {
		createUserPage.getFirstnameWE().sendKeys("penelope");
		Assert.assertEquals("penelope", createUserPage.getFirstnameWE().getAttribute("value"));
	}
	
	@Test
	public void testFillInLastName() {
		createUserPage.getLastnameWE().sendKeys("fillon");
		Assert.assertEquals("fillon", createUserPage.getLastnameWE().getAttribute("value"));
	}
	
	@Test
	public void testFillInAge() {
		createUserPage.getAgeWE().sendKeys("46");
		Assert.assertEquals("46", createUserPage.getAgeWE().getAttribute("value"));
	}

	@Test
	public void testSubmit1() {
		createUserPage.submit("Chuck", "NORRIS", "499 ans");
	}
	
	@Test
	public void testSubmit2() {
		createUserPage.submit("Jean-Pierre", "FOUCAULT", "12 ans");
	}
	
	@Test
	public void testSubmit3() {
		createUserPage.submit("Bob", "L'éponge", "et son ami Patrick");
	}
	
	@Test
	public void testSubmit4() {
		createUserPage.submit("Merci Jean-François", "pour la formation", "dans la PAF");
	}
	
	@Test
	public void testSubmit5() {
		createUserPage.submit("Selenium", "C'est", "Trop d'la balle");
	}
	
	@Test
	public void testSubmit6() {
		createUserPage.submit("Je place des C@R@ct€r€5 spéciaux", "dans le texte", "ce n'est pas un nombre");
	}
}

