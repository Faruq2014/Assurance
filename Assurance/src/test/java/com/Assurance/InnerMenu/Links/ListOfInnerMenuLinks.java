package com.Assurance.InnerMenu.Links;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListOfInnerMenuLinks {
	
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
	public void innerMenuLinksTest() throws InterruptedException {
		List<WebElement> LifeLine=driver.findElements(By.xpath("//div[contains(@id,'menu')]/ul/li"));
		System.out.println(LifeLine.size());
		for (int i=0; i<LifeLine.size();i++){
		     
		      System.out.println("inner menu text are:" + LifeLine.get(i).getText());
		     
		    }
	
	}
	
	@AfterTest
	public void finishTest() {
		if (driver!=null) {
			driver.quit();
		}
	}

	

}
