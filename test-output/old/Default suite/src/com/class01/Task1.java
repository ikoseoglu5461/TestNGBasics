package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class Task1 extends CommonMethods{
	/*TC 1: Swag Lab Title and Login Verification
	 * @BeforeMethod should contain navigation to the URL and title verification
	 * @Test should contain steps to login and “Product” word verification
	 * @AfterMethod should logOut from the application and close the browser
	 */
	
	@BeforeMethod
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
	}
	@Test
	public void Login() throws InterruptedException  {
		sendText(driver.findElement(By.xpath("//*[@id=\"user-name\"]")), "standard_user");
		Thread.sleep(3000);
		sendText(driver.findElement(By.xpath("//*[@id=\"password\"]")), "secret_sauce");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]")).click();
		Thread.sleep(3000);
		WebElement word=driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/div"));
		if(word.getText().equalsIgnoreCase("Products")) {
			System.out.println("Products word is present in the wen page!");
		}else {
			System.out.println("Products word is NOT present in the wen page!");
		}
		
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	

}
