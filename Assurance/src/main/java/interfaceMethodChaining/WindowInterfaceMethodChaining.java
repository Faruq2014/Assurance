package interfaceMethodChaining;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowInterfaceMethodChaining {
    public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
	} 
	
	@Test
	public void maximize()  {
		// EITHER

		// getting Option interface’s reference by calling manage() of WebDriver interface

		Options options = driver.manage();

		// getting Window interface’s reference by calling window() of Options interface

		Window window = options.window();

		// calling maximize() method of Window interface’ reference

		window.maximize();

		// OR

		// no need getting reference of Options and Window interfaces separately

		driver.manage().window().maximize();
		
	
	}
	
	//@Test
	public void fullscreen()  {		
		driver.manage().window().fullscreen();	
	}
	
	//@Test
	public void setPosition()  {
		Point newPoint = new Point(300, 500);// new Point (xOffset, yOffset);
		driver.manage().window().setPosition(newPoint);
	}
		
	//@Test
	public void getPosition() {
		//Point newPoint = new Point(30, 50);
		//driver.manage().window().setPosition(newPoint);
		Point point = driver.manage().window().getPosition();
		System.out.println("X offset : "+point.x);
		System.out.println("Y offset : "+ point.y);
	}
	
	//@Test
		public void setsize()  {
		// new Dimension (width, height);
		Dimension newDimension = new Dimension(200, 300);
		driver.manage().window().setSize(newDimension);
		}
	
	//@Test
	public void getsize() {
	// new Dimension (width, height);
	//Dimension newDimension = new Dimension(700, 600);
	//driver.manage().window().setSize(newDimension);
	
	Dimension dimension = driver.manage().window().getSize();
	System.out.println(dimension.height);
	System.out.println(dimension.width);
	}
		

}
