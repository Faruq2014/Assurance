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

public class XpathStartsWith {
	
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
	
	
	/**This method can be used when we are searching for web elements matching the start of 
	 * the text of the attributes passed. 
	 * The text() method can also be used which will match the starting of the text.
	 * @throws InterruptedException
	 */
	@Test(priority=1)
	public void startsWithTest() throws InterruptedException {
		/* //tag[starts-with(@attribute,'value')]
		 * it is better use partial value.
		 */
		WebElement zip=driver.findElement(By.xpath("//span[starts-with(@class,'zip-')]"));
		System.out.println(zip.getText());
		//main-zip zip
		WebElement zip1=driver.findElement(By.xpath("(//input[starts-with(@class,'main-zip')])[1]"));
		System.out.println(zip1.getLocation());
		
		
	}
	
	@Test(priority=2)
	public void startsWithTest2() throws InterruptedException {
		
		/* //tag[starts-with(text(),'all the text or partial text')] 
		 * normally it is very common for a link.
		 * */
    driver.findElement(By.xpath("//a[starts-with(text(),'apply')]")).click();
   WebElement zip= driver.findElement(By.xpath("(//*[starts-with(text(),'Enter your zip ')])[2]"));
   System.out.println(zip.getText());
 
	}
	
	@AfterTest
	public void finishTest() {
		if (driver!=null) {
			driver.quit();
		}
	}

	

}
