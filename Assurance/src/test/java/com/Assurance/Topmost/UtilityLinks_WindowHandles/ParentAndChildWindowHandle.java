package com.Assurance.Topmost.UtilityLinks_WindowHandles;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentAndChildWindowHandle {
	 public WebDriver driver;
		
		@BeforeTest
		public void setup() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.navigate().to("https://www.assurancewireless.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} 
		
		@Test
		public void parentAndChildWindowTest() throws InterruptedException {
			driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]")).click();
			/*
			 * now we have two window open by default courser is at main or parent window.
			 * in java there are three courser methods. iterator, enumerator, and ....
			 * for window handles method, most popular one is iterator.
			 * by default iterator only can go forward.
			 */
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
			driver.findElement(By.id("min")).sendKeys("345566666");
			driver.findElement(By.name("vkey")).sendKeys("qwe2334444");
			driver.findElement(By.id("submit")).submit();
			Thread.sleep(3000);
			
			
			driver.switchTo().window(parentWindow);
			
			driver.findElement(By.xpath("(//a[contains(text(),'En Español')])[1]")).click();
			  System.out.println("Spanish title is "+driver.getTitle());
			  driver.navigate().back();
			  System.out.println("English titleis "+driver.getTitle());
			
			
		}

}
