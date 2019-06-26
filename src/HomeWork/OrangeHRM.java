package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class OrangeHRM extends CommonMethods{
	
	/*TC 1: OrangeHRM Verify Successful Login
	 * Step 1: Open browser and navigate to OrangeHRM
	 * Step 2: Enter valid UID and valid PWD and click login button
	 * Step 3: Verify user successfully logged in
	 * TC 2: OrangeHRM Add Employee
	 * Step 1: Click on PIM link and Add Employee
	 * Step 2: Provide Details and Save
	 * Step 3: Verify Employee is added 
	 * TC 3: OrangeHRM Verify Employee Details
	 * Step 1: Click on PIM link and Employee List
	 * Step 2: Search for employee by it id
	 * Step 3: Verify Employee details are displayed 
	 * Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application
	 */
	
	@BeforeMethod
	public void login() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		sendText(driver.findElement(By.cssSelector("input[id*='txtUsername']")), "Admin");
		sendText(driver.findElement(By.cssSelector("input[id*='txtPassword']")), "NT1zgHXd@4");
		driver.findElement(By.cssSelector("input[id*='btnLogin']")).click();
	
	String title=driver.getTitle();
	String expectedTitle="Dahboard";
	if(title.equals(expectedTitle)) {
		System.out.println("Succesfully logid in");
	}else {
		System.out.println("Fails");
	}
}
	@Test
	public void addEmployee() {
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		sendText(driver.findElement(By.cssSelector("input[id*='firstName']")), "Ali");
		sendText(driver.findElement(By.cssSelector("input[id*='lastName']")), "Ak");
		WebElement location=driver.findElement(By.cssSelector("input[class*='select-dropdown']"));
		
		Select obj=new Select(location);
		obj.selectByVisibleText("Manhattan");
	}
	
}
