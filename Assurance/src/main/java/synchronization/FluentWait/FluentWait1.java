	package synchronization.FluentWait;
	
	import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
	
	import org.openqa.selenium.By;
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
	
	public class FluentWait1 {
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
		
		//@Test(priority=0)
		public void clickOnCourasou() {
			System.out.println("open");
			WebElement csoul1=driver.findElement(By.xpath("//*[contains(text(),'Get Started')]"));
			Wait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(csoul1));
			System.out.println(csoul1.getText()+csoul1.getAttribute("innerHTML"));
	             csoul1.click();
	         
		}
		//@Test(priority=1)
		public void clickOnCourasoul() {
			System.out.println("open");
			WebElement csoul1=driver.findElement(By.xpath("//*[contains(text(),'Get Started')]"));
			FluentWait<WebDriver> Fwait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(20))
					  .pollingEvery(Duration.ofSeconds(4))
					  .ignoring(NoSuchElementException.class);
			Fwait.until(ExpectedConditions.elementToBeClickable(csoul1));
			System.out.println(csoul1.getText()+csoul1.getAttribute("innerHTML"));
	             csoul1.click();
	            
		}
		
		@Test(priority=2)
		public void clickOnCourasoul2() {
			System.out.println("open");
			WebElement csl2=driver.findElement(By.xpath("(//a[contains(text(),'Apply Now')])[2]"));
			//csl2.click();
			
			Wait<WebDriver> Fwait = new FluentWait<WebDriver>(driver) 
			.withTimeout(Duration.ofSeconds(20))
			  .pollingEvery(Duration.ofSeconds(4))
			  .ignoring(NoSuchElementException.class);
			WebElement ele= (WebElement) Fwait.until(ExpectedConditions.elementToBeClickable(csl2));
			ele.click();
			 WebElement zip=driver.findElement(By.cssSelector("[class*='main-zip apply-zip']"));
             zip.sendKeys("22309");
       //  Fwait.until(ExpectedConditions.elementSelectionStateToBe(zip, true));
         System.out.println(zip.getText());
        // zip.sendKeys("22309");
            
            System.out.println("done");
		
		}
		
		//@Test(priority=3)
		public void clickOnCourasoul3() {
			System.out.println("open");
			WebElement csl2=driver.findElement(By.xpath("(//a[contains(text(),'Apply Now')])[2]"));
			System.out.println(csl2.getText()+csl2.getAttribute("innerHTML"));
			WebDriverWait ewait= new WebDriverWait(driver,3);
		WebElement ele = (WebElement) ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Apply Now')])[2]")));
		//System.out.println(csl2.getText()+csl2.getAttribute("innerHTML"));
		ele.click();
		//ele.sendKeys("1233");
		
		}
	
	
	}
