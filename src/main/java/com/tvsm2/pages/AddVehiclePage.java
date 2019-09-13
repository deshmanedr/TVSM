package com.tvsm2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author Vikrant Punde
 *
 */
public class AddVehiclePage {
	WebDriver driver ;
	 WebDriverWait wait;
	 AlmostTherePage atp;
	
		
		/**
		 * @param driver2
		 */
		public AddVehiclePage(WebDriver driver2) {
			wait= new WebDriverWait(driver2, 15);
			this.driver=driver2;
			PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
		}
		
		@AndroidFindBy(xpath = "//*[@id='et_chassis_number']")
	    private AndroidElement txtCassisNumber;

		@AndroidFindBy(xpath = "//*[@id='dd']")
	    private AndroidElement btnVerify;


		public void enterChassisNumber(String cn) {
			wait.until(ExpectedConditions.visibilityOf(txtCassisNumber));
			txtCassisNumber.sendKeys(cn);
		}
		
		public void clickVerifyBtn() {
			wait.until(ExpectedConditions.visibilityOf(btnVerify));
			btnVerify.click();
		}
		
		public void firstTimeVehicleAdd() {
			atp = new AlmostTherePage(driver);
			wait.until(ExpectedConditions.visibilityOf(txtCassisNumber));
			txtCassisNumber.sendKeys("XY1234567890AWERTS");
			wait.until(ExpectedConditions.visibilityOf(btnVerify));
			btnVerify.click();
			atp.clickSaveAndProceedBtn();
		}
}
