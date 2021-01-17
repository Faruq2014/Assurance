package synchronization.ExplicitWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Timeout;

public class allertToBePresent {
	
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
		WebElement csl2=driver.findElement(By.xpath("(//a[contains(text(),'Apply Now')])[2]"));
		//csl2.click();
		
		  Wait<WebDriver> Fwait = new FluentWait<WebDriver>(driver) .withTimeout(Duration.ofSeconds(30))
		  .pollingEvery(Duration.ofSeconds(3))
		  .ignoring(NoSuchElementException.class);
		WebElement ele= (WebElement) Fwait.until(ExpectedConditions.elementToBeClickable(csl2));
		ele.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement zip= driver.findElement(By.cssSelector("[class*='main-zip apply-zip']"));
		
      zip.sendKeys("22309");
  
		
	}

}
