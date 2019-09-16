package com.tvsm2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UpdatePage {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

    public UpdatePage(AppiumDriver<MobileElement> driver2) {
    	wait= new WebDriverWait(driver2, 15);
    	this.driver=driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
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
