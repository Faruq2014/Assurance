package com.Assurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TheTest {
public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();// 87.0.4280.20
		driver = new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
	} 
	
	@Test
	public void lifLineService_WhatIsLifeLine() {
		String title=driver.getTitle();
		System.out.println("the title is "+ title);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
