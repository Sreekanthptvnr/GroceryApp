package com.executeClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.elementRepository.AdminUsers;
import com.elementRepository.LoginPage;
import com.github.javafaker.Faker;

public class ExecuteAdminUsers extends BaseClass {
	LoginPage lp;
	AdminUsers au;
	@Test(priority=1)
	public void Tc1verifyAdminUserLabelText() {
		lp = new LoginPage(driver);
		au = new AdminUsers(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickLoginButton();
		String actualtext = au.getAdminUserLabelText();
		String expectedText = "Admin Users";
		Assert.assertEquals(actualtext, expectedText, "PageName does not matches with the expected value");
	}

	@Test(priority=2)

	public void Tc2navigateToAdminUsersPage() {
		lp = new LoginPage(driver);
		au = new AdminUsers(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickLoginButton();
		au.clickAdminUserMoreInfo();
	}

	@Test(priority=3)

	public void Tc3createNewAdminUser() {
		lp = new LoginPage(driver);
		au = new AdminUsers(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickLoginButton();
		au.clickAdminUserMoreInfo();
		au.clickNewButton();
		au.enterUserName("tester01");
		au.enterPassword("Password@123");
		au.selectDropdown();
		au.selectFromuserTypeDropdown("admin");
		au.clickSaveButton();
		String actualUserAlertText = au.getUserAlertText();
		String expectedUserAlertText = "×\n" + "Alert!\n" + "User Created Successfully";
		Assert.assertEquals(actualUserAlertText, expectedUserAlertText,
				"User creation alert does not matches,Hence user is not created");

	}

	@Test(priority=4)

	public void Tc4searchUser() {
		lp = new LoginPage(driver);
		au = new AdminUsers(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickLoginButton();
		au.clickAdminUserMoreInfo();
		au.clickSearchButton();
		au.enterSearchUsername("tester01");
		au.selectFromSearchuserTypeDrpdwn("admin");
		au.clicksearchUserNameButton();
		String actualUserName = au.getTextSearchedUserName();
		String expectedUserName = "tester01";
		Assert.assertEquals(actualUserName, expectedUserName, "UserName retrieved");

	}
	
	@Test(priority=5)
	
	public void Tc5searchAndUpdateUser() {
		lp = new LoginPage(driver);
		au = new AdminUsers(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickLoginButton();
		au.clickAdminUserMoreInfo();
		au.clickSearchButton();
		au.enterSearchUsername("tester01");
		au.selectFromSearchuserTypeDrpdwn("admin");
		au.clicksearchUserNameButton();
		au.clickEditButton();
		au.updateUserName("tester04");
		au.updatePassword("Password@124");
		au.clickUpdateButton();
		String actualUserUpdateAlert=au.getUserUpdateAlerttxt();
		String expectedUserUpdateAlert="×\n" + "Alert!\n" + "User Updated Successfully";
		Assert.assertEquals(actualUserUpdateAlert, expectedUserUpdateAlert,"User is not updated");
		
		
	}

	@Test(enabled=false)

	public void Tc6searchAndinactivateUser() {
		lp = new LoginPage(driver);
		au = new AdminUsers(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickLoginButton();
		au.clickAdminUserMoreInfo();
		au.clickSearchButton();
		au.enterSearchUsername("tester04");
		au.selectFromSearchuserTypeDrpdwn("admin");
		au.clicksearchUserNameButton();
		au.clickInactivateUser();
		String actualUserStatus = au.getFirstUsrStatus();
		String expectedUserStatus = "InActive";
		Assert.assertEquals(actualUserStatus, expectedUserStatus, "User is not Inactive");

	}

	@Test(priority=7)
	public void Tc7searchAndDeleteUser() {

		lp = new LoginPage(driver);
		au = new AdminUsers(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickLoginButton();
		au.clickAdminUserMoreInfo();
		au.clickSearchButton();
		au.enterSearchUsername("tester04");
		au.selectFromSearchuserTypeDrpdwn("admin");
		au.clicksearchUserNameButton();
		au.clickDeleteUser();
		au.acceptAlert();
		String actualUserDelAlert = au.getUserDelAlertext();
		String expectedUserDelAlert = "×\n" + "Alert!\n" + "User Deleted Successfully";
		Assert.assertEquals(actualUserDelAlert, expectedUserDelAlert);

	}
}
