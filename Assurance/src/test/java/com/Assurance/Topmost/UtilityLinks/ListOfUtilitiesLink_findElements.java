package com.Assurance.Topmost.UtilityLinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListOfUtilitiesLink_findElements {
	public WebDriver driver;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.assurancewireless.com/");
	} 
	
		@Test
	public void printUtlitiesTextTest() throws InterruptedException {
		Thread.sleep(5000);
		
		List<WebElement> totalLinks= driver.findElements(By.xpath("//div[@class='topmost']/div/div/div"));
		//List<WebElement> totalLinks= driver.findElements(By.xpath("//div[@id='ccm-block-social-links45']/ul/li"));
		int list=totalLinks.size();
		System.out.println("total number of utilities link : "+list);
		for (int i=0; i<totalLinks.size();i++){
		      System.out.println("Radio button text:" + totalLinks.get(i).getAttribute("value"));
		      System.out.println("Utlities links text are:" + totalLinks.get(i).getText());
		      System.out.println("Utlities tagname are:" + totalLinks.get(i).getTagName());
		    }
	
	}
	
}
