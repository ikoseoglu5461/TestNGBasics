package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class Task1 extends CommonMethods {
	
	/*TC 1: Swag Lab Title and Login Verification

@BeforeMethod should contain navigation to the URL and title verification

@Test should contain steps to login and “Product” word verification

@AfterMethod should logOut from the application and close the browser*/
	
	@BeforeMethod
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
		
		String title = driver.getTitle();
        String expTitle = "Swag Labs";
        if(title.equalsIgnoreCase(expTitle)) {
        System.out.println("this is the right title");
        }
        else {
            System.out.println("sorry this not the title");
        }
    }
	
	
	@Test
	public void login() throws InterruptedException {
		sendText(driver.findElement(By.xpath("//*[@id=\"user-name\"]")), "standard_user");
		Thread.sleep(2000);
		sendText(driver.findElement(By.xpath("//*[@id=\"password\"]")), "secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]")).click();
		
		WebElement pro = driver.findElement(By.cssSelector("#inventory_filter_container > div"));
        String returnedWord = pro.getText();
        String expWord ="Product";
        
        if(returnedWord.equalsIgnoreCase(expWord)) {
            System.out.println("word is correct");
        }else {
            System.out.println("word is wrong");
        }
    
	}

	@AfterMethod
	
	public void close() throws InterruptedException {
		
		driver.findElement(By.cssSelector("#menu_button_container > div > div:nth-child(3) > div > button")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#logout_sidebar_link")).click();
        Thread.sleep(2000);
		driver.close();
	}

}