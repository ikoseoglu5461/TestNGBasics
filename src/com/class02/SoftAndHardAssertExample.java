package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.CommonMethods;

public class SoftAndHardAssertExample extends CommonMethods{
	
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
	}
	@Test
	public void OrangeHrmLoginScreen() {
		String title=driver.getTitle();
		String expectedTitle="OrangeHRM";
//		SoftAssert soft=new SoftAssert();
//		soft.assertEquals(title, expectedTitle);
//		System.out.println("Soft assert");
		Assert.assertEquals(title, expectedTitle);
		System.out.println("After hard assert");
	}
	@Test
	public void logo() {
		boolean logo=driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).isDisplayed();
		SoftAssert soft2=new SoftAssert();
		soft2.assertTrue(logo);
		System.out.println("Soft assert");
		soft2.assertAll();
		Assert.assertTrue(logo);
		
//		System.out.println("After hard assert");
		
	}
}
