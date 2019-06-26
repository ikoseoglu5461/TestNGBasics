package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.CommonMethods;

public class Task1 extends CommonMethods {
	/*
	 * TC 1: OrangeHRM Title Validation TC 2: OrangeHRM Successful Login
	 * https://opensource-demo.orangehrmlive.com/ Please make sure to use the
	 * following: annotations:
	 * 
	 * @BeforeMethod
	 * 
	 * @AfterMethod
	 * 
	 * @Test What would you do if you do not want to execute any specific test case?
	 * What would you do if you want to execute any specific test case first?
	 */

	@BeforeMethod
	public void setUp() {
		setUpDriver("firefox", "https://opensource-demo.orangehrmlive.com/");
		boolean orange = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).isDisplayed();
		if (orange) {
			System.out.println("this is the right title");
		} else {
			System.out.println("this is the wrong title");
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}