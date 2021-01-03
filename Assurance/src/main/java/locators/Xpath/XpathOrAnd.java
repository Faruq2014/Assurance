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

public class XpathOrAnd {
	
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
	public void OrXpath() throws InterruptedException {
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
		
		// or xpath, it will click one or the other. make sure all of them indicate one xpath
		
		WebElement uname=driver.findElement(By.xpath("//input[@name='min'] | //input[@id='min']"));//regular or
		uname.sendKeys("7034445555");
		driver.findElement(By.xpath("//input[@name='min'] | //input[@id='min']|//input[class='form-control required']"));//regular or
		driver.findElement(By.xpath("//input[@name='min'or @id='min']"));// another or
		driver.findElement(By.xpath("//input[@name='min'or @id='min' or class='form-control required']"));
		////with class, it is a compound class value because of space between words of the value.
		// also has multiple class name.
	}

	@Test(priority=1)
	public void andXpath() throws InterruptedException {
		/*
		 * driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]"))
		 * .click();
		 * 
		 * Set<String>windowhadler=driver.getWindowHandles(); // creating window handles
		 * method
		 * 
		 * Iterator<String>iterator=windowhadler.iterator(); // creating iterator
		 * menthod String parentWindow=iterator.next();
		 * System.out.println("this is parent window : "+ parentWindow); String
		 * ChildWindow=iterator.next(); System.out.println("this is child window :"+
		 * ChildWindow); driver.switchTo().window(ChildWindow); Thread.sleep(2000);
		 * String childTitle = driver.getTitle();
		 * System.out.println("Child window title is >>>>>>"+childTitle);
		 */	
		// and must be true. that means both condition must be  pointing to one element.
		
		driver.findElement(By.xpath("//input[@name='vkey'and @type='password']")).sendKeys("12345");// and
		
	}

}
