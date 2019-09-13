package com.tvsm2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VehicleInformationPage {
	WebDriver driver ;
	 WebDriverWait wait;
	
		
		public VehicleInformationPage(WebDriver driver2) {
			wait= new WebDriverWait(driver2, 15);
			this.driver=driver2;
			PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
		}
		
		@AndroidFindBy(xpath = "//*[@text='Remove Vehicle from App']")
	    private AndroidElement btnRemoveVehicle;
		
		@AndroidFindBy(xpath = "//*[@text='YES']")
	    private AndroidElement btnYes;
		
		
		public void clickRemoveVehicle() {
			wait.until(ExpectedConditions.visibilityOf(btnRemoveVehicle));
			btnRemoveVehicle.click();
		}
		
		public void acceptDeleteConfirmPopUp() {
			wait.until(ExpectedConditions.visibilityOf(btnYes));
			btnYes.click();
		}
		
}
