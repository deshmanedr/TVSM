package com.tvsm2.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tvsm2.utils.Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OTPVerificationPage {
	WebDriverWait wait;
	AndroidDriver<MobileElement> driver = null;
	Utils util;

    public OTPVerificationPage(AndroidDriver<MobileElement> driver) {
    	wait= new WebDriverWait(driver, 15);
    		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
    
    @AndroidFindBy(xpath = "//*[@id='otp_one']")
    private AndroidElement OTPone;	
    
    @AndroidFindBy(xpath = "//*[@id='otp_two']")
    private AndroidElement OTPtwo;	
    
    @AndroidFindBy(xpath = "//*[@id='otp_three']")
    private AndroidElement OTPthree;	
    
    @AndroidFindBy(xpath = "//*[@id='otp_four']")
    private AndroidElement OTPfour;	
    
    @AndroidFindBy(xpath = "//*[@text='SUBMIT']")
    private AndroidElement btnSubmit;	
    
    public void enterOTP() throws InterruptedException {
    	util =new Utils(driver);
    	String otp= util.getOTP();
    	System.out.println("Your otp is:"+otp);
    	wait.until(ExpectedConditions.visibilityOf(OTPone));
    	OTPone.sendKeys(Character.toString(otp.charAt(0)));
    	wait.until(ExpectedConditions.visibilityOf(OTPtwo));
    	OTPtwo.sendKeys(Character.toString(otp.charAt(1)));
    	wait.until(ExpectedConditions.visibilityOf(OTPthree));
    	OTPthree.sendKeys(Character.toString(otp.charAt(2)));
    	wait.until(ExpectedConditions.visibilityOf(OTPfour));
    	OTPfour.sendKeys(Character.toString(otp.charAt(3)));
    }
    
    public void clickSubmit() {
    	wait.until(ExpectedConditions.visibilityOf(btnSubmit));
    	btnSubmit.click();
    }
    
}
