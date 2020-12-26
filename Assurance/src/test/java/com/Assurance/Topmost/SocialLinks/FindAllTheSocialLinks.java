package com.Assurance.Topmost.SocialLinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAllTheSocialLinks {


   public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();// 87.0.4280.20
		driver = new ChromeDriver();
		driver.navigate().to("https://www.assurancewireless.com/");
	} 
	@Test
	public void FindAllTheLinkRegularLoopTest() {
		List<WebElement> socialLinks= driver.findElements(By.xpath("//div[@id='ccm-block-social-links45']/ul/li"));
		System.out.println("links are "+socialLinks.size());
		System.out.println("link from regular loop");
		for (int i = 0; i < socialLinks.size(); i++) {
			System.out.println(" regular loop :  "+socialLinks.get(i).getText());
			
		}
	}
	@Test
	public void FindAllForEachLoopTest() {
		List<WebElement> socialLinks= driver.findElements(By.xpath("//div[@id='ccm-block-social-links45']/ul/li"));
		System.out.println("links are "+socialLinks.size());
		for (WebElement webElement : socialLinks) {
			System.out.println("enhance loop  : "+webElement.getAttribute("value"));
		}
		
}
}