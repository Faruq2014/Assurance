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


/**ID is Unique
 * ID is the most reliable 
 * if locators has, ID must use ID
 * @author Faruq
 *
 */
public class Attribute_ID {
	
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
		@Test(priority=0)
	    public void topmost_ID_Test() throws InterruptedException {
			//rehular way to find ID
		WebElement topmost=driver.findElement(By.id("topmost"));
		System.out.println(topmost.getText());
	    }
		
		@Test(priority=1)
	    public void ID_Test() throws InterruptedException {	
		WebElement sectionZip=driver.findElement(By.id("sectionzip"));
		System.out.println(sectionZip.getText());
	    }
		
		@Test(priority=2)
	    public void header_ID_Test() throws InterruptedException {	
		WebElement header1=driver.findElement(By.id("header1"));
		System.out.println(header1.getText());
		System.out.println(header1.getSize());
		System.out.println(header1.isEnabled());
	    }
		
		@Test(priority=3)
	    public void block_ID_Test() throws InterruptedException {	
		WebElement BLOCK_4033=driver.findElement(By.id("BLOCK_4033"));
		System.out.println(BLOCK_4033.getText());
		System.out.println(BLOCK_4033.getSize());
		System.out.println(BLOCK_4033.isEnabled());
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
			
			// regular ID
			
			driver.findElement(By.id("min")).sendKeys("23445444");
			//driver.findElement(By.name("vkey")).sendKeys("3545666");//no id
			
			List<WebElement> links=driver.findElements(By.id("small_links"));
			for (WebElement webElement : links) {
				System.out.println(webElement.getText());
			}
	    }
		
		
	@AfterTest
	public void finishTest() {
		if (driver!=null) {
			driver.quit();
		}
	}

	

}
