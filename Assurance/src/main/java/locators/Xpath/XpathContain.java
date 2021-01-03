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

public class XpathContain {
	
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
	
	/**
	 * Contains is a method used when the value of any attribute changes dynamically. 
	 * It can search an element with partial information. specially something change 
	 * at the beginning or at the end.
	 * @throws InterruptedException
	 */
	@Test
	public void contains() throws InterruptedException {
		/* //tag[contains(@attribute,'value')] */
		WebElement img=driver.findElement(By.xpath("//img[contains(@alt,'Assurance')]"));
		System.out.println(img.isEnabled());
		List<WebElement> LifeLine=driver.findElements(By.xpath("//div[contains(@id,'menu')]/ul/li"));
		System.out.println(LifeLine.size());
		
		/* //tag[contains(text(),'all the text or partial text')] 
		 * normally it is very common for a link.
		 * */
		WebElement ac=driver.findElement(By.xpath("(//a[contains(text(),'Annual')])[1]"));
		System.out.println(ac.getText());
		
		WebElement ls=driver.findElement(By.xpath("(//a[contains(text(),'Lifeline Serv')])[1]"));
		System.out.println(ls.getText());
	}
	
	@AfterTest
	public void finishTest() {
		if (driver!=null) {
			driver.quit();
		}
	}

	

}
