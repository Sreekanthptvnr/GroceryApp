package com.executeClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.generalUtilities.ScreenShotCapture;

public class BaseClass {
	WebDriver driver;
	ScreenShotCapture capture;
	public static Properties prop;
	public static void testBasics() throws IOException {
		
		prop=new Properties();
		FileInputStream input= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop.load(input);
	}

	@BeforeMethod
	@Parameters("browser")
	public void launchBrowser(String browserName) throws IOException {
		testBasics();
		String URL=prop.getProperty("URL");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
			System.setProperty("Webdriver.chrome.driver",
					("user.dir") + "\\src\\main\\resources\\chrome\\chromedriver.exe");
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			System.setProperty("Webdriver.gecko.driver",
					("user.dir") + "\\src\\main\\resources\\gecko\\geckodriver.exe");
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			capture = new ScreenShotCapture();
			capture.failureScreenShotCapture(driver, result.getName());
		}
		driver.quit();
	}
}
