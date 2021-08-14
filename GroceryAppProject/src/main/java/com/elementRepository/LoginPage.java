package com.elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.generalUtilities.ExcelRead;
import com.generalUtilities.ExplicitWait;
import com.generalUtilities.GeneralUtility;

public class LoginPage {
	WebDriver driver;
	GeneralUtility utility = new GeneralUtility();
	ExcelRead read;
	ExplicitWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//div[@class='wrapper']/nav/ul/li/a[@data-toggle='dropdown']")
	WebElement loggedInUsername;

	@FindBy(xpath = "//p[@class='login-box-msg']")
	WebElement loginPageText;

	@FindBy(xpath = "//div[@class='login-box']/div/a/b")
	WebElement logoImage;
	
	@FindBy(id="remember")
	WebElement remeberMeCheckBox;
	
	@FindBy(xpath="//label[@for='remember']")
	WebElement remeberMeLabel;

	public void enterUserName(String UserNameValue) {

		userName.sendKeys(UserNameValue);

	}
	
	public void enterUserNamefromExcel(int a,int b) throws IOException {
		read=new ExcelRead();
		String usernameValue=read.ReadStringData(a, b);	
		userName.sendKeys(usernameValue);

	}
	
	public void enterPasswdfromExcel(int a,int b) throws IOException {
		read=new ExcelRead();
		String pswdValue=read.ReadStringData(a, b);	
		password.sendKeys(pswdValue);

	}

	public void enterPassword(String PasswordValue) {

		password.sendKeys(PasswordValue);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public String getUserNameText() {
		return utility.getStringText(loggedInUsername);
	}

	public String getLgnBtnText() {
		return utility.getStringText(loginButton);

	}

	public String getLoginPageText() {
		return utility.getStringText(loginPageText);
	}

	public Boolean is7martLogodisplayed() {

		return utility.isElementDisplayed(logoImage);
	}
	public void clickRemeberMeCheckBox() {
		
		remeberMeLabel.click();
	}
	
	public Boolean isRemberMecheckBoxSelected() {
		
		return utility.isCheckBoxSelected(remeberMeCheckBox);
	}
	public void waitLoginBtnToClickable() {
		wait= new ExplicitWait();
		wait.elementToBeClickable(loginButton, driver);
		
	}
	
}
