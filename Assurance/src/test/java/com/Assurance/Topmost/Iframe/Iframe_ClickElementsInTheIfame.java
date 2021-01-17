package com.Assurance.Topmost.Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe_ClickElementsInTheIfame {
	public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();// 87.0.4280.20
		driver = new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
	} 
	
	@Test(priority=1)
	public void iFrameTestLinkOne() throws InterruptedException {
			 Thread.sleep(5000); 
			 driver.switchTo().frame(0);
			 WebElement ele=driver.findElement(By.xpath("//*[@id='u_0_1']"));
			System.out.println("Link one text "+ele.getText());	 
		driver.findElement(By.xpath("//*[@id='u_0_1']")).click();
	
		}
	
	//@Test(priority=2)
	public void iFrameTestLinkTwo() throws InterruptedException {
			 Thread.sleep(5000); 
			 driver.switchTo().frame(0);
			 WebElement ele=driver.findElement(By.xpath("//*[@id='u_0_2']"));
			System.out.println("Link Two text "+ele.getText());	 
		driver.findElement(By.xpath("//*[@id='u_0_2']")).click();
		}

}
