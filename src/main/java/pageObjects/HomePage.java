package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utilities.DriverManager;

public class HomePage extends BasePage {

	public HomePage() {
		super();
		/*
		 * De home pagina is voor nu de eerste pagina. In de constructor geven we aan
		 * naar welke pagina de browser moet gaan. Let wel op dat iedere keer als we een
		 * homepagina object aanmaken de browser een nieuwe url invoert. Ook als we via
		 * een andere knop op de home pagina aan zouden komen.
		 */
		DriverManager.NavigateTo("https://mvnrepository.com/");
	}
	// Operations
	/*
	 * De operations sectie van de PageObject is een verzameling van handelingen die
	 * je op een pagina zou willen doen. Door ze niet in je testcase maar in eigen
	 * methodes te verzamelen voorkom je veel duplicate code. Je kunt een serie
	 * handelingen makkelijk herhalen en mocht er ooit iets veranderen (een extra
	 * veld bij een formulier bijvoorbeed) kun je alle testcases eenvoudig aanpassen
	 */

	public ResultPage Search(String keyWord) {
		SearchBar().sendKeys(keyWord);
		SearchBar().sendKeys(Keys.ENTER);

		/*
		 * Hier valt op dat we een instantie vane een nieuwe pagina terug geven hoewel
		 * we niet weten of we in de nieuwe pagina geintereseert zijn. Door aan het
		 * einde van iedere "Operation" een PageObject terug te geven kunnen we in onze
		 * testcase alle stappen achter elkaar uitvoeren (kijk in ExampleTests.java).
		 * Dit heeft als doel om onze testcases gemakkerlijker leesbaar te maken. We
		 * hoeven niet bij iedere stap een variabele aan te spreken maar kunnen de
		 * stappen achter elkaar lezen. naarDePagina().ZoekItem().SelecteerItem(). Met
		 * deze referentie weten we dat we op een andere pagina aangekomen zijn en
		 * kunnen we de operaties aan gaan roepen die bij die pagina horen.
		 */
		return new ResultPage();
	}

	public HomePage DoNothing() {
		/*
		 * Niet iedere actie brengt je naar een andere pagina. Bij het aanvinken van een
		 * box blijf je nogsteeds op de homepage. In dat soort gevallen kun je het
		 * 'This' sleutel woord gebruiken om een referentie naar de huidige pagina door
		 * te geven.
		 */
		return this;
	}

	// Properties
	/*
	 * De properties pagina bevat de eigenschappen van de webpagina die we zouden
	 * willen weten. Denk hierbij aan de titel van een artiekel of de hoeveelheid
	 * reacties op een zoekterm. Door methodes te definieren die het antwoord in een
	 * logisch format oplevert hoeven we geen conversies meer te doen in onze
	 * testcases. Zo blijven onze testcases kort en leesbaar.
	 */

	public String pageTitle() {
		return _driver.getTitle();
	}

	// Elements
	/*
	 * De Elements sectie is een deel van het PageObject dat we nooit direct in onze
	 * testcases gebruiken. Hier verzamelen we methodes die een referentie opleveren
	 * naar een specefiek element op de pagina. Omdat we de methode definieren
	 * hoeven we maar één selector in onze code te bewaren. mocht een selector ooit
	 * veranderen hoeven we het alleen op deze plek aan te passen.
	 * 
	 * Mocht je ooit geneigd zijn om een element public te maken doe het dan niet.
	 * Waarschijnlijk mis je een actie of moet je een actie aanpassen.
	 */

	/*
	 * Om elementen op te kunnen halen gebruiken we een methode met een naam voor
	 * het element dat we zoeken We maken de methode private zodat we nooit
	 * "perongeluk" dit element in onze testcases gerbuiken.
	 */
	private WebElement SearchBar() {
		return DriverManager.FindElement(By.cssSelector("input#query"));
	}
}
