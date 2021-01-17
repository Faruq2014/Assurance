package synchronization.FluentWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Clickable {
WebDriver driver;

@BeforeTest
public void openApp() {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get("https://www.assurancewireless.com/");
}

@Test
public void clickableTest() {
	
	Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			.ignoring(NoSuchElementException.class)
			.ignoring(NullPointerException.class)
			.ignoring(StaleElementReferenceException.class)
			.ignoring(TimeoutException.class)
			.ignoring(NoSuchFrameException.class)
			.ignoring(ElementNotInteractableException.class)
			.withMessage("sychronization need to be fixed")
			.withTimeout(Duration.ofSeconds(20))
			.pollingEvery(Duration.ofSeconds(5));
	WebElement c2=driver.findElement(By.xpath("(//*[@id='item-2']//following::a[1])[1]"));
	wait.until(ExpectedConditions.elementToBeClickable(c2)).click();
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
	//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("(//*[@class='modal-content'])[2]")));
	//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@id='zip-low-coverage-modal']")));
	//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@id='apply-now-zip-checker-modal']")));
	//driver.findElement(By.xpath("//div[@id='apply-now-zip-checker-modal']//following::input")).sendKeys("12222");
	driver.findElement(By.className("main-zip apply-zip")).sendKeys("22309");
	
}
}









