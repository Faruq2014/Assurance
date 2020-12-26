package interfaceMethodChaining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeOutMethodChaining implements Timeouts{

	 WebDriver driver;
		public Timeouts implicitlyWait(long time, TimeUnit unit) {
			
			// Method chaining style

			// getting Option interface’s reference by calling manage() of WebDriver interface

			Options options = driver.manage();

			// getting Timeouts interface’s reference by calling timeouts() of Options interface

			Timeouts timeouts= options.timeouts();

			// calling implicitlyWait() method of timeouts interface’ reference
			// and it takes two arguments. long time and second, hour, minute or so..

			timeouts.implicitlyWait(10, TimeUnit.SECONDS);
		// OR

			// no need getting reference of Options and Timeout interfaces separately
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return this;
		}
		
		
		
		/**
		 * 
		// this is our customize method.
		// as a result, we can link this method with our base test
		// so we do not have to write this method again and we can easily
		// change from one central point. 
		 * @return
		 */
		public Timeouts implicitlyWait1() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return this;
		}

		public Timeouts setScriptTimeout(long time, TimeUnit unit) {
			driver.manage().timeouts().setScriptTimeout(12, TimeUnit.SECONDS);
			return null;
		}
		
		public Timeouts setScriptTimeout1() {
			driver.manage().timeouts().setScriptTimeout(12, TimeUnit.SECONDS);
			return null;
		}

		public Timeouts pageLoadTimeout(long time, TimeUnit unit) {
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			return null;
		}
		
		
		public Timeouts pageLoadTimeout1() {
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			return null;
		}
	@Test
	public void methodTest() {
		  WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get("https://www.assurancewireless.com/");
				driver.manage().window().maximize();
				//implicitlyWait(0, nulllong time, TimeUnit unit);
				//implicitlyWait1();
				//setScriptTimeout1();
				pageLoadTimeout1();
				System.out.println(driver.getCurrentUrl());
				driver.quit();

	}


}
