package com.tvsm2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StartPage {
	  WebDriverWait wait;
	  AndroidDriver<MobileElement> driver = null;

	
	public StartPage(AndroidDriver<MobileElement> driver) {
		wait= new WebDriverWait(driver, 15);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[@text='LOGIN']")
	private AndroidElement btnLogin;

	@AndroidFindBy(id = "tvSignup")
	private AndroidElement btnSignUp;
	
	public boolean isHomePageDisplayed () {
		if(btnLogin.isDisplayed()&& btnSignUp.isDisplayed())
		return true;
		else
		return false;

	}
	
	public void clickLogin() {
		wait.until(ExpectedConditions.visibilityOf(btnLogin));
		btnLogin.click();
	}
}
