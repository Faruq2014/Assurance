package com.Assurance.Topmost.UtilityLinks_WindowHandles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAllUtilitiesLink {

   public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.assurancewireless.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} 
	
	@Test
	public void lifLineService_WhatIsLifeLine() throws InterruptedException {
		String title=driver.getTitle();
		System.out.println("the title is "+ title);
		
		// coverage map is a unique link text.
		driver.findElement(By.linkText("Coverage Map")).click();
		//driver.navigate().back(); // it is opening new window, so no option to go back ward.
		//driver.switchTo().parentFrame();
		
		
		//driver.findElement(By.className("My Account Login")).click();// not working because  
		// developer uses 'My Account Login' text more than one. it is not unique.
		driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]")).click();
		
		
		//driver.findElement(By.className("My Account Login")).click();// not working because  
				// developer uses 'My Account Login' text more than one. it is not unique.
		driver.findElement(By.xpath("(//a[contains(text(),'Add Minutes And Data')])[1]")).click();
	
		
		  driver.findElement(By.xpath("(//a[contains(text(),'En Español')])[1]")).click();
		  System.out.println("Spanish title is "+driver.getTitle());
		  driver.navigate().back();
		  System.out.println("English titleis "+driver.getTitle());
		  driver.navigate().forward(); //System.out.println(driver.getPageSource());
		  
		 
		
		
		
	}
	
	//@AfterTest
	public void teardown() {
		driver.quit();
	}



}
