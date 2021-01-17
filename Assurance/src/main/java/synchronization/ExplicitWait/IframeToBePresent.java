package synchronization.ExplicitWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeToBePresent {
	
	WebDriver driver;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	     } 
	@Test
	public void iFrameTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	// it is very important to have waiting condition for frame.
		// implicit wait only help find element and find elements methods
		// page load only help to load the page.
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		driver.switchTo().frame(0);
		// without frame to be available method this will fail, because it is taking long time to load.
		 WebElement ele=driver.findElement(By.xpath("//*[@id='u_0_1']"));
		System.out.println("Link one text "+ele.getText());	 
		driver.findElement(By.xpath("//*[@id='u_0_1']")).click();
	
	}

}
