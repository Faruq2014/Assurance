package com.Assurance.Topmost.SocialLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickOnTwitterLinkTest {
	 public WebDriver driver;
		
		@BeforeTest
		public void setup() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.navigate().to("https://www.assurancewireless.com/");
			driver.manage().window().maximize();
		} 
		@Test
		public void iconLinkTest() {
			WebElement tw=driver.findElement(By.xpath("(//i[@class='fa fa-twitter'])[1]"));
			System.out.println(tw.getText());
			driver.findElement(By.xpath("(//i[@class='fa fa-twitter'])[1]")).click();
			
		}
		@Test
		public void listTest() {
			driver.findElement(By.xpath("//div[@id='ccm-block-social-links45']/ul/li[2]")).click();
			WebElement twitter=driver.findElement(By.xpath("//div[@id='ccm-block-social-links45']/ul/li[2]"));
			System.out.println(twitter.getText());
		
		}

}
