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


public class Css_ID {
	
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
	    public void Regular_CSS_ID_Test() throws InterruptedException {	
		//WebElement topmost=driver.findElement(By.cssSelector("div[id='topmost']"));
	    	//#=id, #stands for id
		WebElement topmost=driver.findElement(By.cssSelector("#topmost"));
		System.out.println(topmost.getText());
	    }
		
	   
		@Test(priority=1)
	    public void ID_StartWith_Test() throws InterruptedException {	
        //^=starts-with  or  ^= Match a prefix
		WebElement sectionZip=driver.findElement(By.cssSelector("[id^='sectionzip']"));		
		System.out.println(sectionZip.getText());
	    }
		
		
		@Test(priority=2)
	    public void CSS_ID_EndsWith_Test() throws InterruptedException {	
		//$= Match a suffix or ends-with
		WebElement header1=driver.findElement(By.cssSelector("[id$='header1']"));
		System.out.println(header1.getText());
		System.out.println(header1.getSize());
		System.out.println(header1.isEnabled());
	    }
		
		
		@Test(priority=3)
	    public void CSS_ID_SubStringTest() throws InterruptedException {	
	    	//*= Match a substring
	    	//CSS: a[id*='id_pattern'] 
			//BLOCK_4033
		WebElement BLOCK_4033=driver.findElement(By.cssSelector("[id*='BLOCK_40']"));
		System.out.println(BLOCK_4033.getText());
		System.out.println(BLOCK_4033.getSize());
		System.out.println(BLOCK_4033.isEnabled());
	    }
		
		
		@Test(priority=4)
	    public void MultipleCSS_ID_Test() throws InterruptedException {	
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
			
			// Multiple css together
			//CSS: input[name='min'][type='text']
			driver.findElement(By.cssSelector("input[name='min'][type='text']")).sendKeys("23445444");
			driver.findElement(By.cssSelector("input[name='vkey'][type='password']")).sendKeys("5444");
			driver.findElement(By.cssSelector("button[id='submit'][name='submit']")).submit();
		  
			//#=id, #stands for id
			List<WebElement> links=driver.findElements(By.cssSelector("#small_links"));
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
