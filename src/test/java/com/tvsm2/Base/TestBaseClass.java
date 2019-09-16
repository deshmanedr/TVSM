package com.tvsm2.Base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tvsm2.pages.HomePage;
import com.tvsm2.pages.LoginPage;
import com.tvsm2.pages.OTPVerificationPage;
import com.tvsm2.pages.StartPage;
import com.tvsm2.pages.UpdatePage;
import com.tvsm2.utils.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestBaseClass  {
	public AndroidDriver<MobileElement> driver;
//	public AppiumDriver<MobileElement> driver;
	DesiredCapabilities caps;
	HomePage hp;
	UpdatePage update;
	StartPage startPage;
	LoginPage loginPage;
	OTPVerificationPage otpPage;
	WebDriverWait wait;
	String env = System.getProperty("executionENV");

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	/**
	 * In this section, we will configure our SauceLabs credentials in order to run
	 * our tests on saucelabs.com
	 */
	public static final String USERNAME = "deshmanedr";
	public static final String ACCESS_KEY = "94ccf993-6974-4232-ae42-637c5287a986";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	
	
	
	@BeforeSuite
	public void initExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/MyOwnReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		//extent.setSystemInfo("OS", "Mac Sierra");
		//extent.setSystemInfo("Host Name", "Krishna");
		extent.setSystemInfo("Environment", "QA");
	//	extent.setSystemInfo("User Name", "Dinesh Deshmane");
		htmlReporter.config().setDocumentTitle("TVS MDT sample report");
		htmlReporter.config().setReportName("TVS MDT");

	}
	
	
	@BeforeMethod
	public void run() throws MalformedURLException {

//		if (env == "remote") {
		
		
//			// for emulator
//			caps = DesiredCapabilities.android();
//			caps.setCapability("name", "TVSM Sample Test");
//			caps.setCapability("appiumVersion", "1.9.1");
//			caps.setCapability("deviceName","Android Emulator");
//			caps.setCapability("deviceOrientation", "portrait");
//			caps.setCapability("browserName", "");
//			caps.setCapability("platformVersion","8.0");
//			caps.setCapability("platformName","Android");
//			caps.setCapability("app", "sauce-storage:TVSConnect_v1.36.52_AzureStage_21Aug.apk");  
//			caps.setCapability("appPackage", "com.tvsm.connect");
//			caps.setCapability("appActivity", "com.tvsm.connect.SplashActivity");
//			driver = new AndroidDriver<>(new URL(URL), caps);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			
			
			// for real device
			DesiredCapabilities caps = DesiredCapabilities.android();
			caps.setCapability("name", "TVSM Sample Test"); // test name
			caps.setCapability("appiumVersion", "1.14.0"); // appium version
			caps.setCapability("deviceOrientation", "portrait");
			caps.setCapability("app", "sauce-storage:TVSConnect.apk."); // apk or ipa uploaded to sauce temp storage
			caps.setCapability("appPackage", "com.tvsm.connect");       // app package
			caps.setCapability("appActivity", "com.tvsm.connect.SplashActivity");  // app activity
				
			caps.setCapability("testobject_api_key", "083D5A39FAD945F5800713594D0DA217");  // test object key from Sauce Lab
			String URL ="https://us1-manual.app.testobject.com/wd/hub";  // url where your physical device is present
			caps.setCapability("deviceName", "Motorola_Moto_G6_free");   // your device name
			caps.setCapability("noReset", "false");  
			caps.setCapability("cacheId", "16d2a5ccd7a");   			// your cache ID
			caps.setCapability("testobject_app_id", "1");  				// your application id which you uploaded to sauce cloud manually 
		    caps.setCapability("autoGrantPermissions", true);
			driver = new AndroidDriver<>(new URL(URL), caps);
			
			
		
	/*	} else {
			caps = new DesiredCapabilities();
			caps.setCapability("BROWSER_NAME", "Android");
			caps.setCapability("VERSION", "8.1.0");
			caps.setCapability("deviceName", "Mi A2");
			caps.setCapability("platformName", "Android");
			caps.setCapability("appPackage", "com.tvsm.connect");
			caps.setCapability("appActivity", "com.tvsm.connect.SplashActivity");
			caps.setCapability("autoGrantPermissions", "true");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}*/
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = Utils.getScreenshot(driver);
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			test.fail(result.getThrowable());
			test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
		extent.flush();
		driver.quit();
	}

//	public WebDriver getDriver() {
//		return this.driver;
//	}

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

	public AndroidDriver<MobileElement> getDriver() {
		return (AndroidDriver<MobileElement>) this.driver;
	}
}
