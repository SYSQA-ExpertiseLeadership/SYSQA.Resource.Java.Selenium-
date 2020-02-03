package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.DriverManager;

public class ResultPage extends BasePage {
	ResultPage() {
		super();
	}

	// Operations

	// Properties
	public int NumberOfResults() {
		return Integer.parseInt(ResultCounter().getText());
	}

	// Elements
	public WebElement ResultCounter() {
		return DriverManager.FindElement(By.cssSelector("#maincontent > h2 > b"));
	}
}
