package com.executeClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.elementRepository.LoginPage;
import com.elementRepository.ManagePages;

public class ExecuteManagePages extends BaseClass {
	LoginPage lp;
	ManagePages mp;

  @Test
  public void Tc1verifyManageOrdersText() {
	  lp=new LoginPage(driver);
	  mp=new ManagePages(driver);
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickLoginButton();
	  String actualtext=mp.getmanagePagesText();
	  String expectedText="Manage Pages";
	  Assert.assertEquals(actualtext, expectedText,"Page name does not matches");
  }
  @Test
  public void Tc2VerifyListPagesText() {
	  
	  lp=new LoginPage(driver);
	  mp=new ManagePages(driver);
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickLoginButton();
	  mp.clicManagerUserInfo();
	  String actualtext=mp.getListPagesText();
	  String expectedText="List Pages";
	  Assert.assertEquals(actualtext, expectedText);
	  
  }
  @Test
  
  public void Tc3VerifyRestPageLabelColor() {
	  
	  lp=new LoginPage(driver);
	  mp=new ManagePages(driver);
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickLoginButton();
	  mp.clicManagerUserInfo();
	  String actualColor=mp.getResetLabelColor();
	  String expectedColor="rgba(31, 45, 61, 1)";
	  Assert.assertEquals(actualColor, expectedColor,"Reset label color does not matches with expected value");
  }
}

