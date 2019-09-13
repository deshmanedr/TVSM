package com.tvsm2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	 WebDriver driver ;
	 WebDriverWait wait;
	
		
		public LoginPage(WebDriver driver2) {
			wait= new WebDriverWait(driver2, 15);
			this.driver=driver2;
			PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
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

