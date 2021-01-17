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
import io.netty.util.Timeout;

public class FluentWait3 {
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
	
	@Test(priority=1)
	public void clickOnCourasoul2() {
		System.out.println("open");
		WebElement csl2=driver.findElement(By.xpath("(//a[contains(text(),'Apply Now')])[2]"));
		//csl2.click();
		
		  Wait Fwait = new FluentWait(driver) .withTimeout(Duration.ofSeconds(30))
		  .pollingEvery(Duration.ofSeconds(3))
		  .ignoring(Timeout.class);
		WebElement ele= (WebElement) Fwait.until(ExpectedConditions.elementToBeClickable(csl2));
		ele.click();
		
		 WebElement zip=driver.findElement(By.cssSelector("[class*='main-zip apply-zip']"));
         System.out.println(zip.getText());
           zip.sendKeys("22309");   
        System.out.println("done");
	
	}

}
