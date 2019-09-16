package com.tvsm2.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.tvsm2.Base.TestBaseClass;
import com.tvsm2.pages.LoginPage;
import com.tvsm2.utils.Utils;


public class LoginTest extends TestBaseClass {

	LoginPage loginPage;
	Utils util;

	@Test
	public void Login_logout_Test() throws InterruptedException {
		test = extent.createTest("Login Test");
	     Login();
	     Logout();
	     Assert.assertTrue(true);
	}

}
