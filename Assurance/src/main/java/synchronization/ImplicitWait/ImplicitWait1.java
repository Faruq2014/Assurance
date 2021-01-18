package synchronization.ImplicitWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait1 {
	WebDriver driver;
	
	/**
	 * 
	 */
	@BeforeTest
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
		// implicit wait work for two methods, findElement, findElements
		// it's scope is global. 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// it's only work for page load and globally
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		// to set screen.
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void findElementTest() {
		driver.manage().window().maximize();
		WebElement fb=driver.findElement(By.xpath("(//i[@class='fa fa-facebook'])[1]"));
		System.out.println(fb.getText());
		driver.findElement(By.xpath("(//i[@class='fa fa-facebook'])[1]")).click();
		
	}
	
	@Test(priority=2)
	public void findElementsTest() throws InterruptedException {
		List<WebElement> helpCenter=driver.findElements(By.xpath("//div[contains(@id,'menu')]/ul/li[2]/ul/li/a"));
		System.out.println(helpCenter.size());
		for (int i=0; i<helpCenter.size();i++){
		     
		      System.out.println("inner menu text are:" + helpCenter.get(i).getText().toString());
		      System.out.println("inner menu tag are:" + helpCenter.get(i).getTagName());
		     
		    }
}
	
	
	
	

}
