	package synchronization.FluentWait;
	
	import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class VisivilityAndInvisivility {
		
		WebDriver driver;
	
		
	@BeforeTest
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
	}
	@Test
	public void courasoulThreeTest() {
		
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		  .pollingEvery(Duration.ofSeconds(3)) .withTimeout(Duration.ofSeconds(30))
		  .withMessage("hello") .ignoring(Exception.class);
		  
		  System.out.println("<<<<<<<<<<First corasoul>>>>>>>>>>>>");
		  WebElement ele0=driver.findElement(By.xpath("(//*[@id='item-0']//following::p[1])[1]"));
		 System.out.println(wait.until(ExpectedConditions.visibilityOf(ele0)).getText());
		 wait.until(ExpectedConditions.invisibilityOf(ele0));
			
		 System.out.println("<<<<<<<<<<Second corasoul>>>>>>>>>>>>");
		WebElement ele1=driver.findElement(By.xpath("(//*[@id='item-1']//following::p[1])[1]"));
		System.out.println(wait.until(ExpectedConditions.visibilityOf(ele1)).getText());
		wait.until(ExpectedConditions.invisibilityOf(ele1));
		
		System.out.println("<<<<<<<<<<Third corasoul>>>>>>>>>>>>");
		WebElement ele2=driver.findElement(By.xpath("(//*[@id='item-2']//following::p[1])[1]"));
		System.out.println(wait.until(ExpectedConditions.visibilityOf(ele2)).getText());
		wait.until(ExpectedConditions.invisibilityOf(ele2));
		
		System.out.println("<<<<<<<<<<Fourth corasoul>>>>>>>>>>>>");
		WebElement ele3=driver.findElement(By.xpath("(//*[@id='item-3']//following::p[1])[1]"));
		System.out.println(wait.until(ExpectedConditions.visibilityOf(ele3)).getText());
	
		
		
		
	}
	}
