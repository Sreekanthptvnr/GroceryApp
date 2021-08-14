package com.executeClasses;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.elementRepository.LoginPage;
import com.generalUtilities.ExplicitWait;

public class ExecuteLogin extends BaseClass {
	LoginPage lp;
	
	@Test(groups = {"UI Test"})
	public void testcase1VerifyLogin() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUserNamefromExcel(1,0);
		lp.enterPasswdfromExcel(1, 1);
		lp.waitLoginBtnToClickable();
		lp.clickLoginButton();
		String actualResult = lp.getUserNameText();
		String expectedResult = "Admin";
		Assert.assertEquals(actualResult, expectedResult, "Username not matches");
	}

	@Test(groups = { "UI Test" })
	public void testcase2VerifyLoginBtnText() {
		lp = new LoginPage(driver);
		String actualLgnBtnText = lp.getLgnBtnText();
		String expectedLgnBtnText = "Sign In";
		Assert.assertEquals(actualLgnBtnText, expectedLgnBtnText, "SignIn button text mismatch");
	}

	@Test
	public void testcase3VerifyLoginPageText() {
		lp = new LoginPage(driver);
		String actualLgnPgText = lp.getLoginPageText();
		String ExpectedLgnPgText = "Sign in to start your session";
		Assert.assertEquals(actualLgnPgText, ExpectedLgnPgText,
				"Text in the Login page does not matches with the expected value");
	}

	@Test
	public void testcase4Verify7martLogoDisplay() throws Exception {
//		capture.failureScreenShotCapture(driver, null);
		lp = new LoginPage(driver);
		Boolean actualResponse = lp.is7martLogodisplayed();
		Assert.assertTrue(actualResponse, "7mart logo is not displayed");
	}

	@Test
	public void testcase5VerifyRemeberMeCheckBoxSelection()  {
		lp = new LoginPage(driver);
		lp.clickRemeberMeCheckBox();
		Boolean actualChkbxResponse = lp.isRemberMecheckBoxSelected();
		Assert.assertTrue(actualChkbxResponse, "Remeber Me checkbox is not checked");
	}
}
