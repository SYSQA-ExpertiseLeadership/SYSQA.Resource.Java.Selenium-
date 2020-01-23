package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Deze classe wordt verantwoordelijk voor het beheren van de selenium webdriver.
public class DriverManager {

	static {
		/* Deze syntax mag je vergeten.
		 * Wat staat is dat op het moment dat deze klasse wordt geladen deze code geactiveerd moet worden.
		 * Aangezien het instellen van de ChromePath altijd nodig is en voor geen 
		 * enkele testcase overgeslagen kan worden doen we het hier in de driver manager.*/
		SetChromePath();
	}
	
	private static WebDriver _driver;
	private static int _timeoutInSeconds = 10;

	/*
	 * Door een statische methode te mlaken die een referentie naar de Webdriver
	 * oplevert hoeven we die niet door de hele test door te blijven geven. Op
	 * iedere plek die we nodig hebben kunnen we deze methode aanroepen en de
	 * huidige sessie beinvloeden
	 */
	public static WebDriver getDriverInstance() {
		if (_driver == null) {
			_driver = new ChromeDriver();
		}
		return _driver;
	}

	/*
	 * Aan het einde van onze test willen de de huidige sesie kunenn afsluiten en
	 * met een verse browser beginnen
	 */
	public static void Quit() {
		if (_driver != null) {
			_driver.quit();
			_driver = null;
		}
	}

	/* De methodes hieronder lijken mischien wat overbodig. WebDrivers hebben imers zelf een FindElement(by) methode 
	 * Door deze in de DriverManager te stopen behalen we echter twee voordelen:
	 * 1: We kunnen een impliciete wait toevoegen waardoor we ons nergens anders meer 
	 * zorgen hoeven te maken over timing problemen.
	 * 2: We ontkopelen onze PageObject nog verder van de WebDriver classe.
	 * Mochten de mensen achter selenium ooit besluiten Webdrivers helemaal anders te doen.
	 * (Of wij besluiten dat we logging willen iedere keer als we een element zoeken)
	 * Weten we altijd precies op welke ene plek we onze aanpassingen moeten doen*/
	public static WebElement FindElement(By by) {
		WebDriverWait wait = new WebDriverWait(getDriverInstance(), _timeoutInSeconds);
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static List<WebElement> FindElements(By by) {
		WebDriverWait wait = new WebDriverWait(getDriverInstance(), _timeoutInSeconds);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	public static void NavigateTo(String url) {
		getDriverInstance().navigate().to(url);
	}

	private static void SetChromePath() {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
	}
}
