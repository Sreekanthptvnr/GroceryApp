package com.elementRepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.generalUtilities.GeneralUtility;
import com.github.javafaker.Faker;

public class AdminUsers {
	WebDriver driver;
	GeneralUtility utility = new GeneralUtility();
	Alert alert;

	public AdminUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//i[@class=' fa fa-users widget-stat-icon']/parent::div/preceding-sibling::div/p")
	WebElement adminUserLabel;

	@FindBy(xpath = "//a[@href='http://groceryapp.uniqassosiates.com/admin/list-admin']/child::i[@class='fas fa-arrow-circle-right']")
	WebElement adminUserMoreInfo;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBUtton;

	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "user_type")
	WebElement userTypeDropdown;

	@FindBy(name = "Create")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement userAlert;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement userAlreadyExistsAlert;

	@FindBy(xpath = "////h1[@class='m-0 text-dark']")
	WebElement adminUserLabel2;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(name = "un")
	WebElement searchUserName;

	@FindBy(name = "ut")
	WebElement searchUserTypeDrpdwn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	WebElement searchedUserName;

	@FindBy(name = "Search")
	WebElement usrNameSerachBtn;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-success btncss']")
	WebElement inactivateUser;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[3]/a/span")
	WebElement firstUserStatus;

	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deleteUserButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement userDeletionAlert;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td/a[2]")
	WebElement editButton;

	@FindBy(name = "Update")
	WebElement updateButton;

	public String getAdminUserLabelText() {

		return utility.getStringText(adminUserLabel);
	}

	public void clickAdminUserMoreInfo() {
		adminUserMoreInfo.click();
	}

	public void clickNewButton() {

		newBUtton.click();

	}

	public void enterUserName(String userNameValue) {

		userName.sendKeys(userNameValue);
	}

	public void enterPassword(String passwordValue) {

		password.sendKeys(passwordValue);
	}

	public void selectDropdown() {

		userTypeDropdown.click();
	}

	public void selectFromuserTypeDropdown(String value) {
		
		utility.selectFromDrpDwnByValue(userTypeDropdown, value);
	}

	public void clickSaveButton() {
		saveButton.click();

	}

	public String getUserAlertText() {
		return utility.getStringText(userAlert);
	}

	public void clickSearchButton() {

		searchButton.click();
	}

	public void enterSearchUsername(String searchUsername) {

		searchUserName.sendKeys(searchUsername);
	}

	public void clickSearchUserDrpDwn() {

		searchUserTypeDrpdwn.click();
	}

	public void selectFromSearchuserTypeDrpdwn(String displayValue) {
		utility.selectFromDrpDwnByValue(searchUserTypeDrpdwn, displayValue);
	}

	public String getTextSearchedUserName() {

		return utility.getStringText(searchedUserName);
	}

	public void clicksearchUserNameButton() {

		usrNameSerachBtn.click();
	}

	public void clickInactivateUser() {

		inactivateUser.click();
	}

	public String getFirstUsrStatus() {

		return utility.getStringText(firstUserStatus);
	}

	public void clickDeleteUser() {

		deleteUserButton.click();
	}

	public void acceptAlert() {

		alert = driver.switchTo().alert();
		alert.accept();
	}

	public String getUserDelAlertext() {

		return utility.getStringText(userDeletionAlert);
	}

	public void clickEditButton() {

		editButton.click();

	}

	public void updateUserName(String UpdatedUserName) {
		userName.clear();
		userName.sendKeys(UpdatedUserName);
	}

	public void updatePassword(String updatedPassword) {

		password.sendKeys(updatedPassword);
	}

	public void clickUpdateButton() {

		updateButton.click();
	}

	public String getUserUpdateAlerttxt() {
		return utility.getStringText(userAlert);

	}
	
}
