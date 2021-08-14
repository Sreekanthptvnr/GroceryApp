package com.executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.elementRepository.LoginPage;
import com.elementRepository.ManageDeliveryBoy;
import com.github.javafaker.Faker;

public class ExecuteManageDeliveryBoy extends BaseClass {
	Faker faker=new Faker();
	String name=faker.name().firstName();
	LoginPage lp;
	ManageDeliveryBoy db;
  @Test(enabled=false)
  public void navigateToListDeliveryBoyPage() throws IOException {
	  lp=new LoginPage(driver);
	  db=new ManageDeliveryBoy(driver);
	  lp.enterUserNamefromExcel(1, 0);
	  lp.enterPasswdfromExcel(1, 1);
	  lp.clickLoginButton();
	  db.clickMoreInfo();  
	  String actualTitle=db.getPageTitle();
	  String expectedTitle="List Delivery Boy";
	  Assert.assertEquals(actualTitle, expectedTitle,"Page title does not matches with the given value");
  }
  @Test
  public void createNewDelBoy() throws IOException, InterruptedException {
	  
	  lp=new LoginPage(driver);
	  db=new ManageDeliveryBoy(driver);
	  lp.enterUserNamefromExcel(1, 0);
	  lp.enterPasswdfromExcel(1, 1);
	  lp.clickLoginButton();
	  db.clickMoreInfo(); 
	  db.clickNewButton();
	  db.enterName(name);
	  db.enterEmail(name+"@gmail.com");
//	  db.enterPhoneNum(1234567);
	  db.enterAddress("Street123");
	  db.enterUserName(name+"gr");
	  db.enterPassword("Pass"+name);
	  db.scrollDownJs();
//	 
  }
}
