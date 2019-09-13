package com.tvsm2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsPage {
	WebDriver driver ;
	 WebDriverWait wait;
	
		
		public SettingsPage(WebDriver driver2) {
			wait= new WebDriverWait(driver2, 15);
			this.driver=driver2;
			PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
		}
		
		@AndroidFindBy(id = "rlNavigateToVehicle")
	    private AndroidElement btnVehicleInfo;
		
		
		public void clickVehicleInformationBtn() {
			wait.until(ExpectedConditions.visibilityOf(btnVehicleInfo));
			btnVehicleInfo.click();
		}
}
