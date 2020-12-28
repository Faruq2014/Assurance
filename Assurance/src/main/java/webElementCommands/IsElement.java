package webElementCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsElement {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.assurancewireless.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	} 
	
	@Test
	public void isSelected() {
		WebElement isSelected=driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]"));
		boolean b=isSelected.isSelected();
		System.out.println(b);
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.quit();
	}

}
