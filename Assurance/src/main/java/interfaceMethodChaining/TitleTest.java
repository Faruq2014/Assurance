package interfaceMethodChaining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TitleTest {


	public WebDriver driver;
		
		@BeforeTest
		public void setup() {
			WebDriverManager.chromedriver().setup();// 87.0.4280.20
			driver = new ChromeDriver();
			driver.get("https://www.assurancewireless.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		} 
		
		@Test
		public void titleTest() {
			String anyname=driver.getTitle();
			System.out.println(anyname);
		}
		@Test
		public void urlTest() throws InterruptedException {
			String url=driver.getCurrentUrl();
			System.out.println(url);
			System.out.println(driver.getCurrentUrl());
			WebElement fb=driver.findElement(By.xpath("(//i[@class='fa fa-facebook'])[1]"));
			System.out.println(fb.getText());
			driver.findElement(By.xpath("(//i[@class='fa fa-facebook'])[1]")).click();
			Thread.sleep(3000);
			
		}
	
		@AfterTest
		public void destroy() {
			driver.close();
			driver.quit();
		}
	
		
		
		
		
		
		
		
		
		
}
