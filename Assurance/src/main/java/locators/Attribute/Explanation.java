package locators.Attribute;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explanation {
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
		@Test(priority=0)
	    public void topmost_ID_Test() throws InterruptedException {	
		WebElement top=driver.findElement(By.id("topmost"));
		System.out.println(top.getText());
		driver.findElement(By.className("topmost"));
		driver.findElement(By.linkText("Coverage Map"));
		driver.findElement(By.partialLinkText("Coverage")).click();
	    }

}
