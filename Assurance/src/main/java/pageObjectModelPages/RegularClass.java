package pageObjectModelPages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegularClass {

	WebDriver driver;
	WebDriverWait wait;

	public RegularClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	public void homeUrlValidationTest() {
		String actualUrl= driver.getCurrentUrl();
		String expectedURl="https://www.assurancewireless.com/";
		Assert.assertEquals(expectedURl,actualUrl, "Did not match");
	}


	public WebElement clickOnLonginLink()  {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement link=driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(link)).click();
		return link; //specific data type.

	}
	public WebElement switchToChildWindow() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(11));    
		Set<String>windowhadler=driver.getWindowHandles(); // creating window handles method
		Iterator<String>iterator=windowhadler.iterator(); // creating iterator menthod
		String parentWindow=iterator.next();
		String ChildWindow=iterator.next();
		driver.switchTo().window(ChildWindow);
    
        String expectedURl="https://myaccount.assurancewireless.com/myaccount/home.do";
        wait.until(ExpectedConditions.urlContains(expectedURl));
		return null; // default data type
	}
           // class level data type
	public RegularClass loginFunctionalityTest(String yourUserName, String enterPassword) {       
		driver.findElement(By.id("min")).sendKeys(yourUserName);
		driver.findElement(By.name("vkey")).sendKeys(yourUserName);
		driver.findElement(By.id("submit")).submit();
		return this;

	}

	public void loginValidationTitleTest() {
		String actualTitle="Assurance Wireless";
		String expectedTtile= driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTtile, "Title did not match ");
	}

	public void logInUrlValidationTest() {
		String actualUrl= driver.getCurrentUrl();
		String expectedURl="https://myaccount.assurancewireless.com/myaccount/home.do";
		Assert.assertEquals(expectedURl,actualUrl, "Did not match");
	}

	public void closeApp() {
		if(driver!=null) {
			driver.quit();
		}
	
	}

}
