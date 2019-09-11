package com.tvsm2.Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testobject.appium.junit.TestObjectAppiumSuite;
import org.testobject.appium.junit.TestObjectAppiumSuiteWatcher;
import org.testobject.rest.api.appium.common.TestObject;

import com.tvsm2.pages.HomePage;
import com.tvsm2.pages.LoginPage;
import com.tvsm2.pages.OTPVerificationPage;
import com.tvsm2.pages.StartPage;
import com.tvsm2.pages.UpdatePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


@TestObject(testLocally = false, testObjectApiKey = "YOUR_API_KEY", testObjectSuiteId = 1)
@RunWith(TestObjectAppiumSuite.class)
public class TestBaseClass {
	public AndroidDriver<MobileElement> driver;

	DesiredCapabilities capabilities;
	HomePage hp;
	UpdatePage update;
	StartPage startPage;
	LoginPage loginPage;
	OTPVerificationPage otpPage;
	WebDriverWait wait;
	String env = System.getProperty("executionENV");

	/**
     * In this section, we will configure our SauceLabs credentials in order to run our tests on saucelabs.com
     */
	public static final String sauceUserName = "deshmanedr";
	public static final String sauceAccessKey = "94ccf993-6974-4232-ae42-637c5287a986";
    public static final String URL = "https://" + sauceUserName + ":" + sauceAccessKey + "@ondemand.saucelabs.com:443/wd/hub";

	@BeforeMethod
	public void run() throws MalformedURLException {

		if (env == "remote") {

		     capabilities = new DesiredCapabilities();
		    capabilities.setCapability("platformName", "Android");
		    capabilities.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
		    capabilities.setCapability("platformVersion", "4.4");
//		    capabilities.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");
		    capabilities.setCapability("browserName", "");
		    capabilities.setCapability("deviceOrientation", "portrait");
		    capabilities.setCapability("appiumVersion", "1.5.3");
		    capabilities.setCapability("app", new File("./application/TVSConnect_v1.36.52_AzureStage_21Aug.apk"));
		 
		     driver = new AndroidDriver<>(new URL(URL), capabilities);


		} else {
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("BROWSER_NAME", "Android");
			capabilities.setCapability("VERSION", "8.1.0");
			capabilities.setCapability("deviceName", "Mi A2");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage", "com.tvsm.connect");
			capabilities.setCapability("appActivity", "com.tvsm.connect.SplashActivity");
			capabilities.setCapability("autoGrantPermissions", "true");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}

	@AfterMethod(alwaysRun = true)
	public void quit() {
		driver.quit();
	}

	public AndroidDriver<MobileElement> getDriver() {
		return this.driver;
	}

	public void Login() throws InterruptedException {
		update = new UpdatePage(driver);
		startPage = new StartPage(driver);
		loginPage = new LoginPage(driver);
		otpPage = new OTPVerificationPage(driver);
		hp = new HomePage(driver);
		Thread.sleep(10000);

		update.GoToHomePage();
		startPage.clickLogin();
		loginPage.enterMobileNumber("8805992841");
		loginPage.clickLoginBtn();
		otpPage.enterOTP();
		otpPage.clickSubmit();
		hp.verifyHomePageDisplayedElseAddVehicle();
		Thread.sleep(10000);
	}

	public void Logout() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='imgBack']")).click();
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Logout']")));
		driver.findElement(By.xpath("//*[@id='imgBack']")).click();
		driver.findElement(By.xpath("//*[@text='Logout']")).click();
		driver.findElement(By.xpath("//*[@text='YES']")).click();
	}

}
