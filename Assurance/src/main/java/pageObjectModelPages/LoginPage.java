package pageObjectModelPages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage{
	
WebDriver driver;
WebDriverWait wait;
public LoginPage(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver, this);
}


@FindBy(xpath="(//a[contains(text(),'My Account Login')])[1]")  private WebElement  malLognin; 
 
public  WebElement myAccountLoginLink() {
	// WebElement link=driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]"));
	// link.click();.click();
	malLognin.click();
	return malLognin;
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

@FindBy(id="min") private WebElement uName;
public WebElement username(String enterYourUserName) {
	uName.sendKeys(enterYourUserName);
	return uName;
	
}


@FindBy(name="vkey") private WebElement password;
public WebElement passwordLink(String enterYourpassword) {
	password.sendKeys(enterYourpassword);
	return password;
	
}

@FindBy(id="submit")private WebElement Submit;
public WebElement submitFunctionalty() {       
	Submit.click();
	return Submit;
	
}

public WebElement loginRegresation(String enterUname, String enterPaas) {
	this.myAccountLoginLink();
	this.switchToChildWindow();
	this.username(enterUname);
	this.passwordLink(enterPaas);
	return this.submitFunctionalty();
}


}















