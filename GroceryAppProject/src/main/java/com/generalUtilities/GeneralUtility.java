package com.generalUtilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtility {

	public String getStringText(WebElement element) {

		String StringText = element.getText();
		return StringText;
	}

	public Boolean isElementDisplayed(WebElement element) {
		Boolean reponseValue = element.isDisplayed();
		return reponseValue;

	}
	
	public Boolean isCheckBoxSelected(WebElement element) {
		Boolean checkBoxRespose=element.isSelected();
		return checkBoxRespose;
		
	}
	
	public String getLabelcolor(WebElement element) {
		
		String labelColor=element.getCssValue("color");
		return labelColor;
	}
	
	public void selectFromDrpDwnByIndex(WebElement element,int num) {
		
		Select select =new Select(element);
		select.selectByIndex(num);
		
		
	}
public void selectFromDrpDwnByValue(WebElement element,String value) {
		
		Select select =new Select(element);
		select.selectByValue(value);
		
		
	}
	
	
	
	}

