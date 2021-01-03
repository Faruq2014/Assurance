package locators.Attribute;

import java.util.Iterator;
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


public class Attribute_LinkText {
	
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
	    public void coverage_LinkText_Test() throws InterruptedException {	
		WebElement coverage=driver.findElement(By.linkText("Coverage Map"));
		System.out.println(coverage.getText());
	    }
		@Test(priority=1)
	    public void lifeLine_Test() throws InterruptedException {	
		WebElement lifeLine=driver.findElement(By.linkText("What is Lifeline"));
		System.out.println(lifeLine.getText());
	    }
		
		@Test(priority=2)
	    public void  clickOnLink_Test() throws InterruptedException {
			// it is not a link text, it is a paragraph text. 
		//WebElement owl=driver.findElement(By.linkText("Enter your zip code for your state offer:"));
		//org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element:
		//System.out.println(owl.getText());
		driver.findElement(By.linkText("here")).click();
		driver.navigate().back();
	    }
		
		@Test(priority=3)
	    public void  clickOnPartialLink_Test() throws InterruptedException {
		WebElement fcc=driver.findElement(By.partialLinkText("FCC Public Service"));
		System.out.println(fcc.getText());
		fcc.click();
		driver.navigate().back();// to go previous page
	    }
		
		
		@Test(priority=4)
	    public void logIN_partialLinkText_Test() throws InterruptedException {	
			driver.findElement(By.partialLinkText("Add Minutes And ")).click();
			
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
			
			driver.findElement(By.partialLinkText("Forgot Pass")).click();
	    }
		
	@AfterTest
	public void finishTest() {
		if (driver!=null) {
			driver.quit();
		}
	}

	

}
