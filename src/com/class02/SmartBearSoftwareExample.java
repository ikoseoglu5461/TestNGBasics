package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class SmartBearSoftwareExample extends CommonMethods{
	
	@BeforeClass 
	public void setUp() {
		setUpDriver("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		
	}
	@Test(priority=0)
	public void loginScrenTitle() {
		String loginScrenTitle= driver.getTitle();
		String expectedTitle="Web Orders Login";
		
		if(loginScrenTitle.equals(expectedTitle)) {
			System.out.println("This is the right title");
		}else {
			System.out.println("This is the wrong title");
		}
	}
	@Test(priority=2)
	public void login () {
		sendText(driver.findElement(By.xpath("//input[contains(@id,'username')]")), "Tester");
		sendText(driver.findElement(By.xpath("//input[contains(@id,'password')]")), "test");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]")).click();
		
	}
	@Test(priority=3)
	public void webOrders () {
		WebElement webOrderTitle=driver.findElement(By.xpath("//h1[text()='Web Orders']"));
		if (webOrderTitle.isDisplayed()) {
			System.out.println("WebOrderTitle is Displayed");
		}else {
			System.out.println("WebOrderTitle is  NOT Displayed");
		}
	}
	@AfterClass 
	public void close() {
		driver.close();
	}
}
