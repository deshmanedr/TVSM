package com.tvsm2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class UpdatePage {
	WebDriverWait wait;
	AndroidDriver<MobileElement> driver = null;

    public UpdatePage(AndroidDriver driver) {
    	wait= new WebDriverWait(driver, 15);
    	this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	  @AndroidFindBy(xpath = "//*[@text='LATER']")
	    private AndroidElement btnLater;	  
	  
	  @AndroidFindBy(xpath = "//*[@id='iv_next']")
	    private AndroidElement btnNext;
	  
	  public void GoToHomePage() {
		  wait.until(ExpectedConditions.visibilityOf(btnLater));
		  btnLater.click();
		  wait.until(ExpectedConditions.visibilityOf(btnNext));
		  btnNext.click();
		  wait.until(ExpectedConditions.visibilityOf(btnNext));
		  btnNext.click();		 		  		  		  
    
	  }
}
