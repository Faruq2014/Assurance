package webElementCommands;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetElement {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.assurancewireless.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//@Test
	public void getText() {
		WebElement login = driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]"));
		String loginText = login.getText();// getText() return string.
		System.out.println(loginText);
		// method chaining. because find element is super context interface retuen type
		// method.
		System.out.println(driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]")).getText());
		
		// trim will delete space from the front and behind from text.
		System.out.println(loginText.trim());// it is very important specially to use equals ignore case method.
		System.out.println(loginText.toUpperCase());

	}

	//@Test
	public void getTag() {
		// Tag is such as input, a, div, nav,ul,li, table.
		WebElement login = driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]"));
		String longinTag = login.getTagName();
		System.out.println(longinTag);
	}

	//@Test
	public void getAttribute() {
		// id, name, class, type, text, partial text and so on
		WebElement login = driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]"));
		
		String loginAttribute = login.getAttribute("href");
		String loginAttributeTarget = login.getAttribute("target");
		
		System.out.println("Attribute is  " + loginAttributeTarget);
		System.out.println("Attribute is  " + loginAttribute);
		System.out.println("ID>>>"+login.getAttribute("ID"));
		System.out.println("name>>>"+login.getAttribute("name"));
		System.out.println("class"+login.getAttribute("class"));
	}

	@Test
	public void getCSS() {
		// css is for styling the web site, values are color, padding, margin, border,
		WebElement login = driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]"));
		System.out.println("css font color" + login.getCssValue("color"));
		System.out.println("css font size" + login.getCssValue("font-size"));
		System.out.println("css font weight" + login.getCssValue("font-weight"));
		// System.out.println("css font size"+login.getCssValue("font-size"));
	}

	@Test
	public void gettEverything() throws InterruptedException {
		driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]")).click();

		Set<String> windowhadler = driver.getWindowHandles(); // creating window handles method

		Iterator<String> iterator = windowhadler.iterator(); // creating iterator menthod
		String parentWindow = iterator.next();
		System.out.println("this is parent window : " + parentWindow);
		String ChildWindow = iterator.next();
		System.out.println("this is child window :" + ChildWindow);
		driver.switchTo().window(ChildWindow);
		Thread.sleep(2000);
		String childTitle = driver.getTitle();
		System.out.println("Child window title is >>>>>>" + childTitle);

		// how to find attribute
		System.out.println("the attrubute is from user name>>>>");
		WebElement username = driver.findElement(By.id("min"));
		System.out.println("id = " + username.getAttribute("ID"));
		System.out.println("name = " + username.getAttribute("name"));
		System.out.println("type = " + username.getAttribute("type"));

		System.out.println("finding tag name");
		System.out.println("The tag name is " + username.getTagName());

		System.out.println("finding text");
		System.out.println("input box,so no text present   " + username.getText());

		System.out.println("CSS value = " + username.getCssValue("class"));

		driver.quit();

	}

	@AfterTest
	public void destroy() {
		driver.quit();
	}

}
