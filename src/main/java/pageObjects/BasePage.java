package pageObjects;

import org.openqa.selenium.WebDriver;

import utilities.DriverManager;
/* Sommige dingen zijn op alle paginas van toepassing. 
 * Deze klasse is een verzamel plek voor die gedeelde eigenschappen.
 * Om onze code overzichtelijk te houden willen we zo min mogelijk hier in stoppen. 
 * 
 * We maken deze classe abstract om duidelijk te maken dat deze klasse niet bedoeld is om in onze scripts te kunenn gebruiken*/
abstract class BasePage {
	WebDriver _driver;
	public BasePage() {
		/* Iedere pagina moet de browser kunnen beinvloeden.
		 * vandaar dat we hier in de 'BasePage' een referentie naar de driver vastleggen.
		 * In iedere klasse die BasePage extend kunnen we nu de '_driver' variabele gebruiken*/
		_driver = DriverManager.getDriverInstance();
	}
}
