package com.class05;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class TaskOneAgain extends CommonMethods{
/*TC 1: Saucedemo Username1(Data Provider - Quantity:, Customer name:, Street: City:, State: ,Zip:, Card:, Card Nr:, Expire date )
 * Step 1: Open browser and navigate to smartbearsoftwareStep 
 * 2: Enter valid username, password and click login buttonStep 
 * 3: Verify user successfully logged inStep 
 * 4: Click on OrderStep 
 * 5: Make an order for two user,enter all the information for both users
 * (Quantity:, Customer name:,Street: City:, State: ,Zip:,Card:,Card Nr:, Expire date)Step 
 * 6: Take ScreenShot before submitting each user
 * 
 */
	@BeforeMethod
	public void login() {
		setUpDriver("chrome", "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
		driver.findElement(By.cssSelector("input[name*=\"username\"]")).sendKeys("Tester");
		driver.findElement(By.cssSelector("input[name*=\"password\"]")).sendKeys("test");
		driver.findElement(By.cssSelector("input[type*=\"submit\"]")).click();
		
		String actualTitle="Web Orders";
		String expectedTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("User Login Succesfully");
		}else {
			System.out.println("User did NOT Login Succesfully");
		}
	}
	@DataProvider(name="setOfData")
	public Object [] [] setUpData(){
		
		Object [] [] data = new Object[2][9]	;
		
		data[0][0]="100";
		data[0][1]="John Smith";	
		data[0][2]="123 street ";
		data[0][3]="Ashburn";	
		data[0][4]="Va";
		data[0][5]="20147";	
		data[0][6]="Visa";
		data[0][7]="0000";	
		data[0][8]="00/00";	
		
		
		data[1][0]="200";
		data[1][1]="Mary Smith";	
		data[1][2]="123 street ";
		data[1][3]="Ashburn";	
		data[1][4]="Va";
		data[1][5]="20147";	
		data[1][6]="MasterCard";
		data[1][7]="0001";	
		data[1][8]="01/00";	
		
				
	    return data;
	}
	@Test(dataProvider = "setOfData")
	public void testUsers(String quantity, String customerName, String street, String city, String state, String zip, String card , String cardNr, String date) {
		driver.findElement(By.linkText("Order")).click();
		driver.findElement(By.cssSelector("input[name*=\"Quantity\"]")).sendKeys(quantity);
		driver.findElement(By.cssSelector("input[name*=\"Name\"]")).sendKeys(customerName);
		driver.findElement(By.cssSelector("input[name*=\"TextBox2\"]")).sendKeys(street);
		driver.findElement(By.cssSelector("input[name*=\"TextBox3\"]")).sendKeys(city);
		driver.findElement(By.cssSelector("input[name*=\"TextBox4\"]")).sendKeys(state);
		driver.findElement(By.cssSelector("input[name*=\"TextBox5\"]")).sendKeys(zip);
		driver.findElement(By.xpath("//input[contains(@value,'"+card+"')]")).click();
		driver.findElement(By.cssSelector("input[name*=\"TextBox6\"]")).sendKeys(cardNr);
		driver.findElement(By.cssSelector("input[name*=\"TextBox1\"]")).sendKeys(date);
		
		if(customerName.contains("John Smith")) {
			takeScreenshot("taskOneAgain", "smartbearsoftwareUserOneAgain");
		}else {
			takeScreenshot("taskOneAgain", "smartbearsoftwareUserTwoAgain");
			
		}
		driver.findElement(By.cssSelector("a[id*=\"InsertButton\"]")).click();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
