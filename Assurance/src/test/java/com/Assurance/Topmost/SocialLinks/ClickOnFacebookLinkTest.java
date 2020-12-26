package com.Assurance.Topmost.SocialLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickOnFacebookLinkTest {
	 public WebDriver driver;
		
		@BeforeTest
		public void setup() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.navigate().to("https://www.assurancewireless.com/");
		} 
		@Test
		public void iconLinkTest() {
			driver.manage().window().maximize();
			WebElement fb=driver.findElement(By.xpath("(//i[@class='fa fa-facebook'])[1]"));
			System.out.println(fb.getText());
			driver.findElement(By.xpath("(//i[@class='fa fa-facebook'])[1]")).click();
			
		}
		@Test
		public void listTest() {
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//div[@id='ccm-block-social-links45']/ul/li[1]")).click();
			WebElement fb=driver.findElement(By.xpath("//div[@id='ccm-block-social-links45']/ul/li[1]"));
			System.out.println(fb.getText());
		
		}

}
