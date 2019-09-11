package com.tvsm2.pages;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	AddVehiclePage avp;

	public HomePage(AndroidDriver<MobileElement> driver) {
		wait = new WebDriverWait(driver, 15);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "(//*[@id='up_down_arrows'])[1]")
	private AndroidElement btnUpDwnArrow1;

	@AndroidFindBy(xpath = "//*[@id='menu_add_new_bike']")
	private AndroidElement btnAddVehicle;
	
	@AndroidFindBy(xpath = "(//*[@id='up_down_arrows'])[last()]")
	private AndroidElement btnLastAddedVehicle;

	@AndroidFindBy(xpath = "//*[@text='Settings']")
	private AndroidElement icnSettings;
	
	@AndroidFindBy(xpath = "//*[@text='Edit Profile']")
	private AndroidElement btnEditProfile;

	public void selectAddVehicle() {

		
			try {
				wait.until(ExpectedConditions.visibilityOf(btnUpDwnArrow1));
				btnUpDwnArrow1.click();
			} catch (Exception e) {				
			}		
			
			try {
				wait.until(ExpectedConditions.visibilityOf(btnAddVehicle));
				btnAddVehicle.click();
			} catch (Exception e1) {
			}
			

	}

//	public void selectAddedVehicle() {
//		wait.until(ExpectedConditions.visibilityOf(btnUpDwnArrow));
//		btnUpDwnArrow.click();
//	}

	public void selectSettings() {
		wait.until(ExpectedConditions.visibilityOf(icnSettings));
		icnSettings.click();
	}

	public void verifyHomePageDisplayedElseAddVehicle() {
		avp=new AddVehiclePage(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(btnEditProfile));
		} catch (Exception e) {
			avp.firstTimeVehicleAdd();
		}		
	}

	public void selectLastAddedVehicle() {
		btnUpDwnArrow1.click();
		btnLastAddedVehicle.click();
	}
	
}
