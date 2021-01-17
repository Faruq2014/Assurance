package synchronization.FluentWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WithMessage {
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
	//@Test (priority=1)
	public void messageTest() {
	
			Wait<WebDriver> Fwait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofMillis(100))
			.pollingEvery(Duration.ofMillis(3))
			.withMessage("This is iframe message for fluent wait, because we can not find it")
			.ignoring(NoSuchFrameException.class);
		Fwait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		// without frame to be available method this will fail, because it is taking long time to load.
		 WebElement ele=driver.findElement(By.xpath("//*[@id='u_0_1']"));
		System.out.println("Link one text>>  "+ele.getText());	 
		//driver.findElement(By.xpath("//*[@id='u_0_1']")).click();// most of the time this link does not work
		//driver.findElement(By.xpath("//*[@id='u_0_1']/div/button")).click();
		driver.findElement(By.xpath("//*[@id='u_0_2']")).click();
	}
	
	@Test(priority=2)
	public void NegativeMessageTest() {
		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
	.withTimeout(Duration.ofSeconds(4))
	.pollingEvery(Duration.ofSeconds(2))
	.ignoring(ElementNotInteractableException.class)
	.withMessage("<<<<<Fluent neagtime message test, you can write appropriate error message here.>>>>>");
	WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[contains(text(),'Apply Now')])[2]"))));
    ele.click();
	}

}
