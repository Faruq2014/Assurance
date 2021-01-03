package locators.CSS;

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


public class CSS_Class {
	
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
	
		//@Test(priority=0)
	    public void regular_CSS_Class_Test() throws InterruptedException {	
		//WebElement topmost=driver.findElement(By.cssSelector(".topmost"));
		WebElement topmost=driver.findElement(By.cssSelector("div[class='topmost']"));
		System.out.println(topmost.getText());
	    }
		
		//@Test(priority=1)
	    public void css_StartWith_Class_Test() throws InterruptedException {	
		//^=starts-with  or  ^= Match a prefix
		WebElement tiney=driver.findElement(By.cssSelector("[class^='tinytext']"));		
		System.out.println(tiney.getText());
	    }
		
		//@Test(priority=2)
	    public void  CSS_EndsWith_Class_Test() throws InterruptedException {
			//$= Match a suffix or ends-with
			// homepage-hero hero
			WebElement owl=driver.findElement(By.cssSelector("[class$='-hero hero']"));
		System.out.println(owl.getText());
	    }
		
		//@Test(priority=3)
	    public void  CSS_Substring_Class_Test() throws InterruptedException {
			//*= Match a substring
			// nav navbar-nav navbar-right cosmos-navbar-right list-unstyled
			List<WebElement> dropdown=driver.findElements(By.cssSelector("[class*='cosmos-navbar-right']"));
			System.out.println(dropdown.size());
			for (WebElement webElement : dropdown) {
				System.out.println(webElement.getText());
			}
	    }
		
		
		
		//@Test(priority=4)
	    public void MultipleCSS() throws InterruptedException {	
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
