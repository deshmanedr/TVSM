package com.tvsm2.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.tvsm2.Base.TestBaseClass;
import com.tvsm2.pages.StartPage;
import com.tvsm2.pages.LoginPage;
import com.tvsm2.pages.OTPVerificationPage;
import com.tvsm2.pages.UpdatePage;
import com.tvsm2.utils.Utils;

public class LoginTest extends TestBaseClass {

	LoginPage loginPage;
	Utils util;

	@Test
	public void Login_logout_Test() throws InterruptedException {
	     Login();
	     Logout();
	}

}
