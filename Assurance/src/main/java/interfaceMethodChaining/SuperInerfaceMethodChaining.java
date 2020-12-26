package interfaceMethodChaining;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuperInerfaceMethodChaining {
	


	WebDriver driver;

	@BeforeClass
	public void init() {

	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void superInterfaceTest() throws InterruptedException {
		findElements();
		findElement();
	}

	public SuperInerfaceMethodChaining findElements() throws InterruptedException {

		Thread.sleep(5000);
		
		//List<WebElement> totalLinks= driver.findElements(By.xpath("//div[@class='topmost']/div/div/div"));
		List<WebElement> totalLinks= driver.findElements(By.xpath("//div[@id='ccm-block-social-links45']/ul/li"));
		int list=totalLinks.size();
		System.out.println("total number of utilities link : "+list);
		for (int i=0; i<totalLinks.size();i++){
		     // System.out.println("Radio button text:" + totalLinks.get(i).getAttribute("value"));
		      System.out.println("Utlities links text are:" + totalLinks.get(i).getText());
		      System.out.println("Utlities tagname are:" + totalLinks.get(i).getTagName());
		    }
		return this;
	}

	public SuperInerfaceMethodChaining findElement() {
		driver.findElement(By.linkText("Coverage Map")).click();
		System.out.println("element text: "+driver.findElement(By.linkText("Coverage Map")).getText());
		return this;
	}
	
	@AfterTest
	public void finishTest() {
		driver.quit();
	}

}
