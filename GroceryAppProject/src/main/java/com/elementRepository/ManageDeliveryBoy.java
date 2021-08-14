package com.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generalUtilities.ExcelRead;
import com.generalUtilities.GeneralUtility;
import com.generalUtilities.javaScriptExecutor;
import com.github.javafaker.Faker;

public class ManageDeliveryBoy {
	WebDriver driver;
	GeneralUtility utility = new GeneralUtility();
	ExcelRead read;
	javaScriptExecutor js;
	
	public ManageDeliveryBoy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//i[@class='fas fa-arrow-circle-right']/parent::a[@href='http://groceryapp.uniqassosiates.com/admin/list-deliveryboy']")
	WebElement manageDeliveryBoyMorInfo;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement listDeliveryBoyTitle;

	@FindBy(xpath = "//i[@class='fas fa-edit']/parent::a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(name = "name")
	WebElement delBoyName;

	@FindBy(name = "email")
	WebElement deliBoyEmail;

	@FindBy(name = "phone")
	WebElement deliBoyPhone;

	@FindBy(name = "address")
	WebElement deliBoyAddress;

	@FindBy(name = "username")
	WebElement deliBoyUsrName;

	@FindBy(name = "password")
	WebElement deliBoypassWord;

	@FindBy(name = "create")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public void clickMoreInfo() {
		manageDeliveryBoyMorInfo.click();
	}

	public String getPageTitle() {
		return utility.getStringText(listDeliveryBoyTitle);

	}
	
	public void clickNewButton() {
		
		newButton.click();
		
	}
	public void enterName(String name) {
		
		delBoyName.sendKeys(name);
	}
	public void enterEmail(String email) {
		
		deliBoyEmail.sendKeys(email);
	}
	public void enterPhoneNum(int phoneNo) {
		
		deliBoyPhone.toString();
	}
	
	public void enterAddress(String address) {
		
		deliBoyAddress.sendKeys(address);
	}
  public void enterUserName(String usrName) {
	  
	  deliBoyUsrName.sendKeys(usrName);
  }
  
  public void enterPassword(String password) {
	  
	  deliBoypassWord.sendKeys(password);
  }
  
  public void clickSaveButton() {
	  
	  saveButton.click();
  }
  public void scrollDownJs() throws InterruptedException {
	  js=new javaScriptExecutor();
	  js.scrollDown(driver);
	  js.clickWithJs(saveButton, driver);
  }
 
}
