package com.tvsm2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StartPage {
	  WebDriverWait wait;
	  WebDriver driver = null;

	
	public StartPage(WebDriver driver2) {
		wait= new WebDriverWait(driver2, 15);
		this.driver=driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
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
