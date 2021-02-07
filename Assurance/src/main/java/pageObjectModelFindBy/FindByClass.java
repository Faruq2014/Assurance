package pageObjectModelFindBy;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindByClass {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="(//a[contains(text(),'My Account Login')])[1]") private WebElement login_Link;
	public void linkTest() {
			login_Link.click();
		
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
	
	@FindBys({
		@FindBy(id="min"),
				@FindBy(name="min")
	})
	private List<WebElement> bothcriteria;

	public void bothCriteria() {
		
	}
}
