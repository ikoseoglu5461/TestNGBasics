package com.class04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class TaskOne extends CommonMethods{
/*Identify Priority of Test Cases
 * https://www.saucedemo.com/
 * 
 * TC 1: Saucedemo Username1(tag the groups - Smoke)
 * Step 1: Open browser and navigate to Saucedemo
 * Step 2: Enter username standard_user and enter password secret_sauce and click login button
 * Step 3: Verify user successfully logged in
 * 
 * TC 2: Saucedemo Username2(tag the groups - Regression)
 * Step 1: Open browser and navigate to Saucedemo
 * Step 2: Enter username problem_user and enter password secret_sauce and click login button
 * Step 3: Verify user successfully logged in
 * Note: Create BeforeMethod and AfterMethod annotations to open browser and logout from the application. Create a xml file and include smoke. 
 */
	
	@BeforeMethod(alwaysRun = true, groups = "Regression")
	public void setUP() {
		setUpDriver("chrome", "https://www.saucedemo.com/");	
	}
	@Test(groups ="Smoke")
	public void UserName1() {
	    
	  sendText(driver.findElement(By.id("user-name")), "standard_user");
	  sendText(driver.findElement(By.id("password")), "secret_sauce");
	  driver.findElement(By.className("btn_action")).click();
	  //Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
	  String actualTitle=driver.getTitle();
	  String expectedTitle="Swag Labs";
	  if(expectedTitle.equals(actualTitle)) {
		  System.out.println("UserName1 Right Title");
	  }else {
		  System.out.println("UserName1 Wrong Title");
	  }
	}
	@Test(groups ="Regression")
	public void UserName2() {
	    
	       sendText(driver.findElement(By.id("user-name")), "problem_user");
	       sendText(driver.findElement(By.id("password")), "secret_sauce");
	       driver.findElement(By.className("btn_action")).click();
	       Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
	    }
	@AfterMethod
	public void tearDown() {
	    driver.close();
	}
	}
