package com.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generalUtilities.GeneralUtility;

public class ManageOrders {
	WebDriver driver;
	GeneralUtility utility = new GeneralUtility();
	public ManageOrders(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//ul[@class='nav nav-pills nav-sidebar flex-column']/li[3]/a")
	WebElement manageOrdersElement;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement SearchButton;
	
	public void clickManageOrders() {
		
		manageOrdersElement.click();
	}
	
	
	public String getSearchButtonTextColor() {
		
		return utility.getLabelcolor(SearchButton);
	}
	

}
