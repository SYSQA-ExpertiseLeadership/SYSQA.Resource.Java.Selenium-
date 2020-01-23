package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utilities.DriverManager;

public class HomePage extends BasePage {
	
	public HomePage() {
		super();
		/* De home pagina is voor nu de eerste pagina  */
		DriverManager.NavigateTo("https://mvnrepository.com/");
	}
	// Operations
/* De operations sectie van de PageObject is een verzameling van handelingen die je op een pagina zou willen doen.
 * Door ze niet in je testcase maar in eigen methodes te verzamelen voorkom je veel duplicate code.
 * Je kunt een serie handelingen makkelijk herhalen en mocht er ooit iets veranderen (een extra veld bij een formulier bijvoorbeed)
 * kun je alle testcases eenvoudig aanpassen*/
	
	public ResultPage Search(String keyWord) {
		SearchBar().sendKeys(keyWord);
		SearchBar().sendKeys(Keys.ENTER);
		
		
		return new ResultPage();
	}
	
	// Properties
	/* De properties pagina bevat de eigenschappen van de webpagina die we zouden willen weten.
	 * Denk hierbij aan de titel van een artiekel of de hoeveelheid reacties op een zoekterm.
	 * Door methodes te definieren die het antwoord in een logisch 
	 * format oplevert hoeven we geen conversies meer te doen in onze testcases.
	 * Zo blijven onze testcases kort en leesbaar.*/
	
	public String pageTitle() {
		return _driver.getTitle();
	}
	
	// Elements
/* De Elements sectie is een deel van het PageObject dat we nooit direct in onze testcases gebruiken.
 * Hier verzamelen we methodes die een referentie opleveren naar een specefiek element op de pagina.
 * Omdat we de methode definieren hoeven we maar één selector in onze code te bewaren.
 * mocht een selector ooit veranderen hoeven we het alleen op deze plek aan te passen.
 * 
 * Mocht je ooit geneigd zijn om een element public te maken doe het dan niet.
 * Waarschijnlijk mis je een actie of moet je een actie aanpassen.*/
	
	
	/* Om elementen op te kunnen halen gebruiken we een methode met een naam voor het element dat we zoeken
	 * We maken de methode private zodat we nooit "perongeluk" dit element in onze testcases gerbuiken.*/
	private WebElement SearchBar() {
		return DriverManager.FindElement(By.cssSelector("input#query"));
	}
}
