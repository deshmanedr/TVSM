package com.tvsm2.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AlmostTherePage {
	AndroidDriver<MobileElement> driver ;
	 WebDriverWait wait;
	
		
		public AlmostTherePage(AndroidDriver<MobileElement> driver) {
			wait= new WebDriverWait(driver, 15);
			this.driver=driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		@AndroidFindBy(id = "bt_add_bike")
	    private AndroidElement btnSaveProceed;
		
		public void clickSaveAndProceedBtn() {
			wait.until(ExpectedConditions.visibilityOf(btnSaveProceed));
			btnSaveProceed.click();
		}
		
		
}
