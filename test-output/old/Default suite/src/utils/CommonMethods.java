package utils;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	public static WebDriver driver;
	
	public static void setUpDriver(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/ikoseoglu61/Selenium/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users//ikoseoglu61/Selenium/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser given is wrong");
		}
		driver.get(url);
		driver.manage().window().maximize();

	}
	
	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isSelected=false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(text)) {
				select.selectByVisibleText(text);
				System.out.println("Option with text "+text+" is selected");
				isSelected=true;
				break;
			}
			}
		if(!isSelected) {
				System.out.println("Option with text "+text+" is not available");
		}
	}
	public static void selectValueFromDD(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		if (options.size()>index) {
			select.selectByIndex(index);
		}else {
			System.out.println("Invalid index has been passed");
		}
		
	}
	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
		
	}
	/**
	 * Method will accept alert
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}
	public static void dissmisAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		}catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}
	/**
	 * Method will get text of an alert
	 * @throws NoAlertPresentException if alert is not present
	 * @return String text
	 */
	public static String getAlertText() {
		try {
			Alert alert=driver.switchTo().alert();
			return alert.getText();
		}catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
			return null;
		}
	}
	/**
	 * Method will switch control to the specified frame
	 * @param frame id or frame name
	 */
	public static void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		}catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
		
	}
	/**
	 * Method will switch control to the specified frame
	 * @param frame element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		}catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
		
	}
	/**
	 * Method will switch control to the specified frame
	 * @param frame index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		}catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
		
	}
}
