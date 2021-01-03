package locators.Attribute;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


/**Name could be duplicate
 * there are not too many name in the dom. 
 * @author Faruq
 *
 */
public class Attribute_Name {
	
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
	
		@Test(priority=4)
	    public void logIN_ID_Test() throws InterruptedException {	
			driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]")).click();
			
			Set<String>windowhadler=driver.getWindowHandles(); // creating window handles method
			
			Iterator<String>iterator=windowhadler.iterator(); // creating iterator menthod
			String parentWindow=iterator.next();
			System.out.println("this is parent window : "+ parentWindow);
			String ChildWindow=iterator.next();
			System.out.println("this is child window :"+ ChildWindow);
			driver.switchTo().window(ChildWindow);
			Thread.sleep(2000);
			String childTitle = driver.getTitle();
			System.out.println("Child window title is >>>>>>"+childTitle);
			
			// regular name
			
			driver.findElement(By.name("min")).sendKeys("23445444");
			driver.findElement(By.name("vkey")).sendKeys("3545666");
			driver.findElement(By.name("submit")).submit();
			
	    }
		
		
	
	
	@AfterTest
	public void finishTest() {
		if (driver!=null) {
			driver.quit();
		}
	}

	

}
