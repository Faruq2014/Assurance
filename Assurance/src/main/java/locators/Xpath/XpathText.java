package locators.Xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathText {
	
	WebDriver driver;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.assurancewireless.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	} 
	
	@Test
	public void regularXpath() throws InterruptedException {
		WebElement CP=driver.findElement(By.xpath("//a[text()='Coverage Map']"));
		System.out.println(CP.isEnabled());
		WebElement lg1=driver.findElement(By.xpath("(//a[text()='My Account Login'])[1]"));
		System.out.println(lg1.isDisplayed());
		
		WebElement minutes=driver.findElement(By.xpath("(//a[text()='Add Minutes And Data'])[1]"));
		System.out.println(minutes.isSelected());
		
		WebElement zip=driver.findElement(By.xpath("//span[text()='Enter your zip code for your state offer:']"));
		System.out.println(zip.getText());
		
		
		
	}
	
	@AfterTest
	public void finishTest() {
		if (driver!=null) {
			driver.quit();
		}
	}

	

}
