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
public class XpathXesFollowing {
	
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
		WebElement zip=driver.findElement(By.xpath("//*[@class='feature-area left-feature']//following::p[1]"));
		System.out.println(zip.getText());
		
	}
		@Test(priority=2)
		public void followingTest2() throws InterruptedException {	
			WebElement zip=driver.findElement(By.xpath("//*[@class='feature-area left-feature']//following::p[2]"));
			System.out.println(zip.getText());
			
		}
		
		@Test(priority=3)
		public void followingTest3() throws InterruptedException {	
			WebElement zip=driver.findElement(By.xpath("//a[contains(text(),'here')]//following::p[1]"));
			System.out.println(zip.getText());
			
		}
		
		@Test(priority=4)
		public void followingTest4() throws InterruptedException {	
			List<WebElement> zip=driver.findElements(By.xpath("//*[@id='ccm-block-social-links78']//following::p[1]/a"));
			System.out.println(zip.size());
			for (int i = 0; i < zip.size(); i++) {
				System.out.println(zip.get(i).getText());
			}
			
		}
		
		@Test(priority=5)
		public void followingTest5() throws InterruptedException {	
			List<WebElement> zip=driver.findElements(By.xpath("//*[@id='ccm-block-social-links78']//following::p[3]/a"));
			System.out.println(zip.size());
			for (int i = 0; i < zip.size(); i++) {
				System.out.println(zip.get(i).getText());
			}
			
		}
		
		@Test(priority=6)
		public void followingTest6() throws InterruptedException {	
			List<WebElement> zip=driver.findElements(By.xpath("//*[@id='ccm-block-social-links78']//following::p[5]/a"));
			System.out.println(zip.size());
			for (int i = 0; i < zip.size(); i++) {
				System.out.println(zip.get(i).getText());
			}
			
		}
	
			
			@AfterTest
			public void finishTest() {
				if (driver!=null) {
					driver.quit();
				}
			}

	

}
