package com.executeClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.elementRepository.LoginPage;
import com.elementRepository.ManageOrders;

public class ExecuteManageOrders extends BaseClass{
	LoginPage lp;
	ManageOrders order;
  @Test
  public void verifySearchButtonText() { 
	  lp=new LoginPage(driver);
	  order=new ManageOrders(driver);
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickLoginButton();
	  order.clickManageOrders();
	  String actualSearchLabelColor=order.getSearchButtonTextColor();
	  System.out.println(actualSearchLabelColor);
	  String expectedSearchLabelColor= "rgba(255, 255, 255, 1)";
	  Assert.assertEquals(actualSearchLabelColor, expectedSearchLabelColor);	  
  }
}
