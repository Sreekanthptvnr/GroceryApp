package com.generalUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class ScreenShotCapture {

	public void failureScreenShotCapture(WebDriver driver,String methodName) throws IOException {
		
		TakesScreenshot scr=(TakesScreenshot)driver;
		File filename=scr.getScreenshotAs(OutputType.FILE);
		
		String scrFolder=System.getProperty("user.dir")+"//OutPutScreenShot";
		File f=new File(scrFolder);
		if(!f.exists()) {
			
			f.mkdir();
		}
		
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
        String pathname=System.getProperty("user.dir")+"//OutPutScreenShot//"+methodName+timeStamp+".png";
        
        File finalDest=new File(pathname);
        FileHandler.copy(filename, finalDest);
        
		
	}
}
