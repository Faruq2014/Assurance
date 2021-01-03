package locators.Xpath;

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

/*create any type of xpath and then use following. 
 * normally we use it for <p> or <a>, specially when reliable class or id is not available.
 * @author Faruq
 *
 */
public class XpathXesFollowingImageSlider {
	
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
	public void followingTest() throws InterruptedException {	
		WebElement zip=driver.findElement(By.xpath("(//*[@id='item-0']//following::a[1])[1]"));
		System.out.println(zip.getText());
		zip.click();
		
	}
		
		//@Test(priority=2)
		public void followingTest2() throws InterruptedException {	
			WebElement zip=driver.findElement(By.xpath("(//*[@id='item-1']//following::a[1])[1]"));
			System.out.println(zip.getText());
			zip.click();
			
		}
		
	
	@AfterTest
	public void finishTest() {
		if (driver!=null) {
			driver.quit();
		}
	}

	

}
