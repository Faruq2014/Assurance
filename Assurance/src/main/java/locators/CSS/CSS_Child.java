package locators.CSS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CSS_Child {
	
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
	
		//@Test(priority=0)
	    public void regular_CSS_Class_Test() throws InterruptedException {	
		
		WebElement child1=driver.findElement(By.cssSelector("div[class*='utility-links']>div>a:nth-of-type(1)"));	
		//WebElement child1=driver.findElement(By.cssSelector("div[class*='utility-links']>div>a:first-child"));
		System.out.println(child1.getText());
		
		WebElement child2=driver.findElement(By.cssSelector("div[class*='utility-links']>div>a:nth-of-type(2)"));
		System.out.println(child2.getText());
		//child2.click();
		
		WebElement child3=driver.findElement(By.cssSelector("div[class*='utility-links']>div>a:nth-of-type(3)"));
		System.out.println(child3.getText());
		//child3.click();
		
		//WebElement child4=driver.findElement(By.cssSelector("div[class*='utility-links']>div>a:nth-of-type(4)"));
		WebElement child4=driver.findElement(By.cssSelector("div[class*='utility-links']>div>a:last-child"));
		System.out.println(child4.getText());
		//child4.click();
	    }
	    
	    
		//@Test(priority=1)
	    public void Child_MoseHver_CSS_Class_Test() {	
	
	WebElement child1=driver.findElement(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li:nth-of-type(1)"));	
	//WebElement child1=driver.findElement(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li>a:first-child"));
	System.out.println(child1.getText());
	
	WebElement child2=driver.findElement(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li:nth-of-type(2)"));
	System.out.println(child2.getText());
	//child2.click();
	
	WebElement child3=driver.findElement(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li:nth-of-type(3)"));
	System.out.println(child3.getText());
	//child3.click();
	
	WebElement child4=driver.findElement(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li:nth-of-type(4)"));
	//WebElement child4=driver.findElement(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li:last-child"));
	System.out.println(child4.getText());
	child4.click();
	
		}
		
		
		//@Test(priority=2)
	    public void GChild1_MoseHver_dropDown_CSS_Class_Test() {	
		
			WebElement child1=driver.findElement(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li:nth-of-type(1)"));	
			//WebElement child1=driver.findElement(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li>a:first-child"));
			System.out.println(child1.getText());
		 child1.click(); // child1 has to be clicked first in order to gchild to be working. 
		 
		//WebElement Gchild1=driver.findElement(By.cssSelector("ul[class *='dropdown-menu']>li>a:first-child"));
		WebElement Gchild1=driver.findElement(By.cssSelector("ul[class *='dropdown-menu']>li:nth-of-type(1)"));	
		System.out.println(Gchild1.getText());
		//Gchild1.click();
		
		WebElement Gchild2=driver.findElement(By.cssSelector("ul[class *='dropdown-menu']>li:nth-of-type(2)"));	
		System.out.println(Gchild2.getText());
		//Gchild2.click();
		
		WebElement Gchild3=driver.findElement(By.cssSelector("ul[class *='dropdown-menu']>li:nth-of-type(3)"));	
		System.out.println(Gchild3.getText());
		//Gchild3.click();
		
		//WebElement Gchild4=driver.findElement(By.cssSelector("ul[class *='dropdown-menu']>li:nth-of-type(4)"));
		WebElement Gchild4=driver.findElement(By.cssSelector("ul[class *='dropdown-menu']>li:last-child"));
		System.out.println(Gchild4.getText());
		Gchild4.click();
		
			}
		
		@Test(priority=3)
	    public void GChild2_MoseHver_dropDown_CSS_Class_Test() throws InterruptedException {	
		
			WebElement child2=driver.findElement(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li:nth-of-type(2)"));	
			System.out.println(child2.getText());
			//child2.click();
		//WebElement Gchild1=driver.findElement(By.cssSelector("ul[class *='dropdown-menu']>li>a:nth-of-type(1)"));
		//WebElement Gchild1=driver.findElement(By.cssSelector("ul[class *='dropdown-menu']>li:nth-of-type(2)"));
		 WebElement Gchild1=driver.findElement(By.linkText("My Account Login"));
		System.out.println(Gchild1.getText());
		Actions action = new Actions(driver);
		action.moveToElement(child2).build().perform();
		Thread.sleep(1000);
		action.moveToElement(Gchild1).click().build().perform();
		
		//Gchild1.click();
		}
			
	//@AfterTest
	public void finishTest() {
		if (driver!=null) {
			driver.quit();
		}
	}

	

}
