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

public class LifeLineServicesLink {
	
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
	public void innerMenuLinksTest() throws InterruptedException {
		List<WebElement> LifeLine=driver.findElements(By.xpath("//div[contains(@id,'menu')]/ul/li[1]/ul/li/a"));
		System.out.println(LifeLine.size());
		for (int i=0; i<LifeLine.size();i++){
		     
		      System.out.println("inner menu text are:" + LifeLine.get(i).getText());
		      System.out.println("inner menu tag are:" + LifeLine.get(i).getTagName());
		     
		    }
	}
		
		@Test(priority=2)
		public void helpCenterLinksTest() throws InterruptedException {
			List<WebElement> helpCenter=driver.findElements(By.xpath("//div[contains(@id,'menu')]/ul/li[2]/ul/li/a"));
			System.out.println(helpCenter.size());
			for (int i=0; i<helpCenter.size();i++){
			     
			      System.out.println("inner menu text are:" + helpCenter.get(i).getText().toString());
			      System.out.println("inner menu tag are:" + helpCenter.get(i).getTagName());
			     
			    }
	}
		
		
		@Test(priority=3)
		public void annuelCertificateTest() throws InterruptedException {
			//WebElement ac=driver.findElement(By.xpath("//div[contains(@id,'menu')]/ul/li[3]/a"));
			WebElement ac=driver.findElement(By.xpath("(//a[contains(text(),'Annual')])[1]"));
			System.out.println(ac.getText());
	}
	
	@AfterTest
	public void finishTest() {
		if (driver!=null) {
			driver.quit();
		}
	}

	

}
