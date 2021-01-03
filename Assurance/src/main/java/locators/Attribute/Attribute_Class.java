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


/**class is a direct locators
 * class could be duplicat
 * there are lots of html and bootstrap class key word to be consider.
 * @author Faruq
 *
 */
public class Attribute_Class {
	
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
	    public void topmost_Class_Test() throws InterruptedException {	
		WebElement topmost=driver.findElement(By.className("topmost"));
		System.out.println(topmost.getText());
	    }
		@Test(priority=1)
	    public void tinyText_Class_Test() throws InterruptedException {	
		WebElement tiney=driver.findElement(By.className("tinytext"));
		System.out.println(tiney.getText());
	    }
		
		@Test(priority=2)
	    public void  carousel_Class_Test() throws InterruptedException {	
		WebElement owl=driver.findElement(By.className("owl-carousel"));
		System.out.println(owl.getText());
	    }
		
		
		@Test(priority=4)
	    public void logIN_class_Test() throws InterruptedException {	
			driver.findElement(By.xpath("(//a[contains(text(),'Add Minutes And Data')])[1]")).click();
			
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
			
			// regular class
			
			//driver.findElement(By.className("form-control required")).sendKeys("23445444");
			//driver.findElement(By.className("form-control required")).sendKeys("3545666");
			//driver.findElement(By.className("btn btn-default")).submit();
			//org.openqa.selenium.InvalidSelectorException: Compound class names not permitted
			
			List<WebElement>footer= driver.findElements(By.className("grid_footer_le"));
			System.out.println("Footer size is: "+footer.size());
			for (WebElement webElement : footer) {
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
