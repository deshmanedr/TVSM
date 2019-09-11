package com.tvsm2.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.tvsm2.Base.TestBaseClass;
import com.tvsm2.pages.AddVehiclePage;
import com.tvsm2.pages.AlmostTherePage;
import com.tvsm2.pages.HomePage;
import com.tvsm2.pages.SettingsPage;
import com.tvsm2.pages.VehicleInformationPage;

public class AddVehicleTest extends TestBaseClass{

	HomePage homePage ;
	AddVehiclePage addVehicle;
	AlmostTherePage almostThere;
	SettingsPage settings;
	VehicleInformationPage vehicleInfo;
	
	@Test
	public void add_vehicle_test() throws InterruptedException {
		initialiseObjects();
		Login();
		//homePage.selectAddedVehicle();
		homePage.selectAddVehicle();
		addVehicle.enterChassisNumber("XY1234567890AWERTX");
		addVehicle.clickVerifyBtn();
		almostThere.clickSaveAndProceedBtn();
		
	}

	@Test(dependsOnMethods="add_vehicle_test")
	public void delete_vehicle_test() throws InterruptedException {
		initialiseObjects();
		Login();
		homePage.selectLastAddedVehicle();
		homePage.selectSettings();
		settings.clickVehicleInformationBtn();
		vehicleInfo.clickRemoveVehicle();
		vehicleInfo.acceptDeleteConfirmPopUp();
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void logout() throws InterruptedException {
		Logout();
	}
	
	public void initialiseObjects() {
		settings = new SettingsPage(driver);
		addVehicle = new AddVehiclePage(driver);
		almostThere = new AlmostTherePage(driver);
		vehicleInfo= new VehicleInformationPage(driver);
		homePage = new HomePage(driver);
	}
	
}
