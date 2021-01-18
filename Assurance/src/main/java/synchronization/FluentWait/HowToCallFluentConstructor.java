package synchronization.FluentWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToCallFluentConstructor {
	
	WebDriver driver;
	
	@BeforeTest
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
	}
	
	@Test
	public void courasulTest() throws InterruptedException {
		WebElement csoul1=driver.findElement(By.xpath("(//a[contains(text(),'Apply Now')])[2]"));
		
		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
			
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class)
				.ignoring(NullPointerException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage("this is exception message, it will only come if any of this exception come and still fail");
		
	       wait.until(ExpectedConditions.elementToBeClickable(csoul1)).click();
		
		//Thread.sleep(8000);
		
		csoul1.click();
		
	}
	
	

}
