package com.Assurance.mainNav.Links;

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

public class NavigationLinksTest {
	
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
	public void lifeLineLinksTest() {
		System.out.println("<<<<<<<<<<Life Line Service>>>>>>>>>>>");
	List<WebElement> links=driver.findElements(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li:nth-of-type(1)>ul>li>a"));
	//List<WebElement> links=driver.findElements(By.linkText("Lifeline Service"));
	int size=links.size();
	for (int i = 0; i <size; i++) {
		WebElement ele=links.get(i);
		System.out.println(ele.getAttribute("innerHTML"));
		//System.out.println(ele.getText());
		
	}

	
	}
	@Test(priority=2)
	public void helpCenterLinksTest() {
		
		System.out.println("<<<<<<<<<<<<Help Center>>>>>>>>>>");
	List<WebElement> links=driver.findElements(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li:nth-of-type(2)>ul>li>a"));
	//List<WebElement> links=driver.findElements(By.linkText("Lifeline Service"));
	int size=links.size();
	for (int i = 0; i <size; i++) {
		WebElement ele=links.get(i);
		System.out.println(ele.getAttribute("innerHTML"));
		//System.out.println(ele.getText());
		
	}

	}
	
	@AfterTest
	public void destroy() {
		driver.quit();
	}

}
