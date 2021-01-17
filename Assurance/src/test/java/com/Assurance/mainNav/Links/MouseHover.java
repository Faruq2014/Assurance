package com.Assurance.mainNav.Links;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {
	
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
	
	
	@Test(priority=1)
    public void myAccountLoginTest() throws InterruptedException {	
	
	WebElement child2=driver.findElement(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li:nth-of-type(2)"));	
	System.out.println(child2.getText());
	WebElement Gchild1=driver.findElement(By.linkText("My Account Login"));
	System.out.println(Gchild1.getText());
	
	Actions action = new Actions(driver);
	
	action.moveToElement(child2).build().perform();
	Thread.sleep(1000);
	action.moveToElement(Gchild1).click().build().perform();
	
	//Gchild1.click();
	}
	
	//@Test(priority=2)
    public void helpCenterTest() throws InterruptedException {	
	
	WebElement child2=driver.findElement(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li:nth-of-type(2)"));	
	System.out.println(child2.getText());
	WebElement Gchild1=driver.findElement(By.xpath("(//a[contains(text(),'Check Status')])[1]"));
	System.out.println(Gchild1.getText());
	Actions action = new Actions(driver);
	action.moveToElement(child2).build().perform();
	Thread.sleep(1000);
	action.moveToElement(Gchild1).click().build().perform();
	
	//Gchild1.click();
	}
	
	//@AfterTest
	public void destroy() {
		driver.quit();
	}

}
