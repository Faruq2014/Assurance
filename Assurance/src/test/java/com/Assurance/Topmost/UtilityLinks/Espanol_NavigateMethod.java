package com.Assurance.Topmost.UtilityLinks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Espanol_NavigateMethod {

    public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.assurancewireless.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} 
	
	@Test
	 public void navigationTest() {
		  driver.findElement(By.xpath("(//a[contains(text(),'En Español')])[1]")).click();
		  System.out.println("Spanish title is "+driver.getTitle());
		  driver.navigate().back();
		  System.out.println("English titleis "+driver.getTitle());
		  driver.navigate().forward(); //System.out.println(driver.getPageSource());
		  
	 }
}
