package interfaceMethodChaining;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationInterface {
	


	WebDriver driver;

	@BeforeClass
	public void init() {

	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void navigation() {
		
	driver.navigate().to("https://www.assurancewireless.com/");
	driver.navigate().to("https://www.salesforce.com/");
	//recomanded to use page load time out. because driver exe. will not 
	// wait to load the whole page.
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
	 driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]")).click();
	   
	}
	
	
	@Test
	public void back() {
		driver.navigate().back(); 
		
	}
	@Test
	public void forward() {
		  driver.navigate().forward(); 
		
	}
	//@Test
	public void to(String url) {
		// all readey call this method at the navigation method
		
	}
	//@Test
	public void to(URL url) {
		// all readey call this method at the navigation method
		
	}
	@Test
	public void refresh() {
		   driver.navigate().refresh();  
		
	}
	
	@AfterClass
	public void destroy() {
		if(driver!=null) {
			driver.quit();
		}
	}



}
