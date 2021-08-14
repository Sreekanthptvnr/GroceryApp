package com.generalUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	WebDriverWait wait;
	

	public void elementToBeClickable(WebElement element,WebDriver driver) {

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void textToBePresentInElement(WebElement element, String text,WebDriver driver) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));

	}

	public void attributeContains(WebElement element, String attribute, String value,WebDriver driver) {

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));

	}

}
