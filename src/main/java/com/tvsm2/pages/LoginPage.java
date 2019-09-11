package com.tvsm2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	 AndroidDriver<MobileElement> driver ;
	 WebDriverWait wait;
	
		
		public LoginPage(AndroidDriver<MobileElement> driver) {
			wait= new WebDriverWait(driver, 15);
			this.driver=driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		@AndroidFindBy(xpath = "//*[@id='edtmobilenmber']")
		private AndroidElement mobileNo;

		@AndroidFindBy(xpath = "//*[@text='LOGIN']")
		private AndroidElement btnLogin;
		
		public void enterMobileNumber(String mo) {
			wait.until(ExpectedConditions.visibilityOf(mobileNo));
			mobileNo.sendKeys("8805992841");
		}
		
		public void clickLoginBtn() {
			wait.until(ExpectedConditions.visibilityOf(btnLogin));
			btnLogin.click();
		}
		
		
		
		
		
}

