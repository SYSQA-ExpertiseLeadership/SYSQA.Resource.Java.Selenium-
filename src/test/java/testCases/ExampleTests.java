package testCases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import pageObjects.HomePage;
import pageObjects.ResultPage;
import utilities.DriverManager;

/* In deze file plaatsten we onze testcases.
 * Probeer je testcases op een logische manier over verschillende bestanden te verdelen 
 * (bijvoorbeeld alle tests voor ��n pagina bij elkaar).
 * 
 * Iedere test methode bestaat uit drie stappen:
 * ARRANGE, ACT en ASSERT
 * ARRANGE:
 * In deze stap doen we alle handelingen die nodig zijn om de test uit te kunnen voeren.
 * Denk hierbij aan het inloggen op de site, navigeren naar de pagina,
 * of in de database kijken wat het resultaat zou moeten zijn.
 * Aan het einde van deze stap zijn we klaar om de specefieke handeling uit te voeren die we willen testen.
 * 
 * ACT:
 * Nu dat alles klaar staat gaan we de handeling doen die we graag willen testen.
 * Hou deze stap zo klein mogelijk. 
 * Hoe meer handelingen hier gedaan worden hoe moeilijker het is te zeggen waar de fout zit.
 * Deze stap dient ook als documentatie voor jezelf en andere waar deze testcase om draait.
 * Test je het zoeken of het navigeren naar het zoeken?
 * 
 * ASSERT:
 * Hier vergelijk je de uitkomst met de gewenste uitkomst.
 * Als het goed is hoef je hier niets meer met de webpagina te doen.
 * Alleen de uitkomst ophalen en op een logische manier vergelijken
 * 
 * Ik vind het prettig om deze stappen als comments in de methode te zetten.
 * Hierme geef je voor jezelf en je collegas aan wat de belangrijke delen zijn van de testcase en wat slechts voorbereiding*/

public class ExampleTests {

	@Test
	public void FirstTestCase() {
		// Arrange
		HomePage home = new HomePage();

		// Act
		ResultPage page = home.Search("selenium");

		// Assert
		assertEquals(page.NumberOfResults(), 766);

	}

	@Test
	public void InconsistentTestCase() {
		// Arrange
		HomePage home = new HomePage();

		// Act
		ResultPage page = home.Search("Test");

		// Assert
		assertEquals(page.NumberOfResults(), 1373);

	}

	@After
	public void endTest() {
		DriverManager.Quit();
	}
}
