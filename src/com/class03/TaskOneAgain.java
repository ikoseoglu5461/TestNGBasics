package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class TaskOneAgain extends CommonMethods {
	 
	@BeforeTest
	public void setUP() {
		setUpDriver("chrome", "https://www.saucedemo.com/");

	}

	@Test
	public void login() {
		sendText(driver.findElement(By.cssSelector("input[data-test*=username]")), "standard_user");
		sendText(driver.findElement(By.cssSelector("input[data-test*=password]")), "secret_sauce");
		driver.findElement(By.cssSelector("input[class*=btn_action]")).click();
		
		String actualTitle= driver.getTitle();
		String expectedTitle="Swag Labs";
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("This is the right title");
		}else {
			System.out.println("This is the wrong title");
		}
	}
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}

}
