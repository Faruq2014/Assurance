package pageObjectModelPages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageFactoryPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public PageFactoryPage(WebDriver driver) {
		super();
		this.driver = driver;
		//this.wait=wait;
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

	@FindBy(xpath="(//a[contains(text(),'My Account Login')])[1]") private WebElement login_Link;	
	public void clickOnLoginLink() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		wait.until(ExpectedConditions.elementToBeClickable(login_Link)).click();
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
	
	@FindBy(id="min") private WebElement userName;
    // class level data type
	public WebElement userNameFunctionaltyTest(String yourUserName) {       
		userName.sendKeys(yourUserName);
		//driver.findElement(By.id("submit")).submit();
		return userName;

	}
	
	@FindBy(name="vkey")private WebElement password;
	public WebElement passwordFunctionaltyTest(String yourPasswoed) {       
		password.sendKeys(yourPasswoed);
		//driver.findElement(By.id("submit")).submit();
		return password;
	}
	
	@FindBy(id="submit")private WebElement Submit;
	public WebElement submitFunctionaltyTest() {       
		Submit.click();
		return Submit;
		
	}
	
	public void homePageTitleTest() {
		String expecetedTitle= driver.getTitle();
		String actualTitle= "Lifeline Cell Phone Service Provider | Assurance Wireless";
		Assert.assertEquals(actualTitle, expecetedTitle);
		//Assert.assertSame(expecetedTitle.compareToIgnoreCase(expecetedTitle), "did not match");
	}
	
	public void homePgeUrlTest() {
		String actualUrl= driver.getCurrentUrl();
		String expectedURl="https://www.assurancewireless.com/";
		Assert.assertEquals(expectedURl,actualUrl, "Did not match");
	}
	
	public void landingPageValidationTest() {
		SoftAssert sa= new SoftAssert();
		String actualUrl= driver.getCurrentUrl();
		String expectedURl="https://myaccount.assurancewireless.com/myaccount/home.do";
		sa.assertEquals(expectedURl,actualUrl, "Did not match");
		sa.assertTrue(expectedURl.contains(actualUrl));
		sa.assertAll();
	}
	
	public WebElement loginRegrationTest(String enterYourUserName, String enterYourPassword) {
		this.clickOnLoginLink();
		this.switchToChildWindow();
		this.userNameFunctionaltyTest(enterYourUserName);
		this.passwordFunctionaltyTest(enterYourPassword);
		return this.submitFunctionaltyTest();
		
		
	}
	

}
