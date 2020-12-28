package webElementCommands;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InputBox {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.assurancewireless.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	} 
	@Test
	public void inputWebElementTest() throws InterruptedException {
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
	
	// how to write on input box
	driver.findElement(By.id("min")).sendKeys("345566666");
	
	// how to clear from input box
	driver.findElement(By.id("min")).clear();
	driver.findElement(By.id("min")).sendKeys("7023334444");
	// how to write on input box
	driver.findElement(By.name("vkey")).sendKeys("12334");
	driver.findElement(By.name("vkey")).clear();
	driver.findElement(By.name("vkey")).sendKeys("4321");
	
	
	
	// how mant ways to submit on submit button 
	//driver.findElement(By.id("submit")).submit();
	//driver.findElement(By.id("submit")).click();
	//driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
	
	// how about if you do not have a submit button.
	driver.findElement(By.name("vkey")).sendKeys(Keys.ENTER);// vkey is the password locator.
	Thread.sleep(3000);
	driver.quit();
	}

}
