package synchronization.ExplicitWait;

import java.time.Duration;

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

public class ElementsToBePresent {
	WebDriver driver;
	@BeforeTest
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("");
			
	}
	
	@Test
	public void elementsToBePresent() {
		
		Wait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele=driver.findElement(By.xpath("//*[@id='topmost']/div/div/div[3]//a[2]"));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) ele));
		ele.click();
		}
	
	@Test
	public void clickable() {
		
		WebDriver driver= new ChromeDriver();
		WebElement ele=driver.findElement(By.xpath("//*[@id='topmost']/div/div/div[3]//a[2]"));
		
		Wait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		
		
	}

}












