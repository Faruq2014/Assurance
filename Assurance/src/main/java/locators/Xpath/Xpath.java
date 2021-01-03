package locators.Xpath;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {
	
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
	
	@Test
	public void regularXpath() throws InterruptedException {
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
		
		// regular xpath
		
		WebElement un=driver.findElement(By.xpath("//input[@id='min']"));//with id
		driver.findElement(By.xpath("//input[@name='min']"));//with name
		driver.findElement(By.xpath("//input[@class='form-control required']"));
		System.out.println(un.getTagName());
		////with class, it is a compound class value because of space between words of the value.
		// also has multiple class name.
		
		WebElement un1=driver.findElement(By.xpath("//input[@name='min'][@name='min']"));//with multipole
		un1.sendKeys("asdfghh");
	}

	

}
