package com.class01;

import org.testng.annotations.BeforeMethod;

import utils.CommonMethods;

public class SwagLabTask extends CommonMethods{
	/*TC 1: Swag Lab Title and Login Verification

	@BeforeMethod should contain navigation to the URL and title verification

	@Test should contain steps to login and “Product” word verification

	@AfterMethod should logOut from the application and close the browser*/
		
	@BeforeMethod
	public void setUpUrl() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
		
		
	}
	

}
