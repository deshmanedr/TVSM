package com.tvsm2.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tvsm2.pages.StartPage;
import com.tvsm2.pages.LoginPage;
import com.tvsm2.pages.OTPVerificationPage;
import com.tvsm2.pages.UpdatePage;

public class Utils {
	 public WebDriver driver;
	 UpdatePage update;
		StartPage homePage;
		LoginPage loginPage;
		OTPVerificationPage otpPage; 
		WebDriverWait wait;
	 
	public Utils(WebDriver driver2) {
		 this.driver=driver2;
		 wait = new WebDriverWait(driver2,15);
	 }
	 
	public String getOTP() throws InterruptedException{
		//Thread.sleep(10000);
		//driver.openNotifications();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'This is your one-time password- ')]")));
		String otp = driver.findElement(By.xpath("//*[contains(text(),'This is your one-time password- ')]")).getText().split("password- ")[1];
		
		//driver.hideKeyboard();
		return otp;
	}
	
}
