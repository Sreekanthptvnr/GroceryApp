package com.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generalUtilities.GeneralUtility;

public class ManagePages {
	WebDriver driver;
	GeneralUtility utility = new GeneralUtility();

	public ManagePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='http://groceryapp.uniqassosiates.com/admin/list-page']/preceding-sibling::div//preceding-sibling::div/p")
	WebElement ManagePagesText;

	@FindBy(xpath = "//a[@href='http://groceryapp.uniqassosiates.com/admin/list-page']/child::i[@class='fas fa-arrow-circle-right']")
	WebElement managePageMoreInfo;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement listPages;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;

	public String getmanagePagesText() {

		return utility.getStringText(ManagePagesText);

	}

	public void clicManagerUserInfo() {
		managePageMoreInfo.click();

	}

	public String getListPagesText() {

		return utility.getStringText(listPages);
	}

	public String getResetLabelColor() {
		return utility.getLabelcolor(resetButton);

	}

}
