package interfaceMethodChaining;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverMethodChaining {
	
	WebDriver driver;

	@BeforeClass
	public void init() {

	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority=1)
	public void testing() throws InterruptedException {
		System.out.println("starting the test");
		driver.get("https://www.assurancewireless.com/");
		getCurrentUrl().getTitle().findElement().close();
		
		driver.get("https://www.assurancewireless.com/");
		findElements().getWindowHandle().quit();
		//getTitle();
	
	}
 @Test(priority=0)
	public void get(String url) {
		driver.get(url);
		//System.out.println(url);
	}

	public WebDriverMethodChaining getCurrentUrl() {
		System.out.println("the url is "+driver.getCurrentUrl());
		return this;
	}
	
	public WebDriverMethodChaining getTitle() {
		System.out.println("the title is: "+driver.getTitle());
		return this;
	}

	public WebDriverMethodChaining findElements() throws InterruptedException {

		Thread.sleep(5000);
		
		//List<WebElement> totalLinks= driver.findElements(By.xpath("//div[@class='topmost']/div/div/div"));
		List<WebElement> totalLinks= driver.findElements(By.xpath("//div[@id='ccm-block-social-links45']/ul/li"));
		int list=totalLinks.size();
		System.out.println("total number of utilities link : "+list);
		for (int i=0; i<totalLinks.size();i++){
		      System.out.println("Radio button text:" + totalLinks.get(i).getAttribute("value"));
		      System.out.println("Utlities links text are:" + totalLinks.get(i).getText());
		      System.out.println("Utlities tagname are:" + totalLinks.get(i).getTagName());
		    }
		return this;
	}

	public WebDriverMethodChaining findElement() {
		driver.findElement(By.linkText("Coverage Map")).click();
		return this;
	}

	public WebDriverMethodChaining getPageSource() {
		String pageSource=driver.getPageSource();
		System.out.println(pageSource);
		return this;
	}
	@Test(priority=2)
	public void close() {
		driver.close();
		
	}
	@Test(priority=3)
	public void quit() {
	driver.quit();
		
	}

	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebDriverMethodChaining getWindowHandle() throws InterruptedException {
		driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]")).click();
		/*
		 * now we have two window open by default courser is at main or parent window.
		 * in java there are three courser methods. iterator, enumerator, and ....
		 * for window handles method, most popular one is iterator.
		 * by default iterator only can go forward.
		 */
		Set<String>windowhadler=driver.getWindowHandles(); // creating window handles method
		
		Iterator<String>iterator=windowhadler.iterator(); // creating iterator menthod
		String parentWindow=iterator.next();
		System.out.println("this is parent window : "+ parentWindow);
		String ChildWindow=iterator.next();
		System.out.println("this is child window :"+ ChildWindow);
		driver.switchTo().window(ChildWindow);
		Thread.sleep(2000);
		String childTitle = driver.getTitle();
		System.out.println("Child window title is >>>>>>"+childTitle);
		driver.findElement(By.id("min")).sendKeys("345566666");
		driver.findElement(By.name("vkey")).sendKeys("qwe2334444");
		driver.findElement(By.id("submit")).submit();
		Thread.sleep(3000);
		
		return this;
	}

	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Navigation navigate() {
		//navigation interface method
		return null;
	}

	public Options manage() {
		//option interface
		return null;
	}



}
