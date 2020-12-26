	package com.Assurance.Topmost.Iframe;
	
	import java.util.List;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class Iframe_FindAllTheElements {
	
	public WebDriver driver;
		
		@BeforeTest
		public void setup() {
			WebDriverManager.chromedriver().setup();// 87.0.4280.20
			driver = new ChromeDriver();
			driver.get("https://www.assurancewireless.com/");
		} 
		
		@Test
		public void iFrameFindAllTheLinkTest() throws InterruptedException {
				 Thread.sleep(5000); 
		// iframe window takes long time to upload, we are waiting to page load, in future we will use wait command. 
	          System.out.println("====How many I Frame in the page?======");
				 int size = driver.findElements(By.tagName("iframe")).size();
			System.out.println(" I frame in this page is :  " + size);
	
			System.out.println("==== Switching to the I Frame===");
			/*how do i know, whic frame is in my desired element.
			 * you can do it manually, by id, by name, by index.
			 *  
			 */
			System.out.println("====Switching to I frame by index====");
			driver.switchTo().frame(0); 
	   
			System.out.println("====what is the title of the i frame?====");
			/*
			 * iframe is embaded frame in the main frame, so it does not have different title.
			 */
			String iFrameTitle = driver.getTitle();
			System.out.println("i frame title is " + iFrameTitle);
			 System.out.println("====== how many elements do i frame contain ?====");
			 
			List<WebElement> totalLinks= driver.findElements(By.xpath("//*[@id='u_0_0']"));
			System.out.println("i frame contain : "+totalLinks.size()+" elements" );
		                  System.out.println("the element text is>>>> ");
			 for (int i=0; i<totalLinks.size();i++){
			      //System.out.println("Radio button text:" + totalLinks.get(i).getAttribute("value"));
			      System.out.println(totalLinks.get(i).getText());
			    }
			 
			
		
			
			/*
			 * driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click(); 
			 * no idea why click button is not working, or we need to find better locators.
			 * WebElement ele=driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
			 * System.out.println(ele.getText().toString());
			 */
			
			/*
			 * WebElement
			 * ele2=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
			 * System.out.println(ele2.getText().toString());
			 */
			
			driver.findElement(By.xpath("//*[@id='u_0_1']")).click();
			//clicking the links
			WebElement ele3=driver.findElement(By.xpath("//*[@id='u_0_1']"));
			System.out.println(ele3.getText().toString());
			
			//driver.findElement(By.xpath("//*[@id='u_0_2']")).click();
			// clicking the links
			//WebElement ele4=driver.findElement(By.xpath("//*[@id='u_0_2']"));
			//System.out.println(ele4.getText().toString());
			// driver.findElement(By.id("email")).sendKeys("Faruq");
			/*
			 * this is tottaly new browser, it will not work, we have to write different
			 * browser window code for this, usning selenium 4.
			 */
			
			driver.switchTo().defaultContent();
			System.out.println("parent title is "+ driver.getTitle());
			WebElement zip=driver.findElement(By.xpath("//span[contains(text(),'Enter your zip code for your state offer:')]"));
			System.out.println(zip.getText());
			driver.findElement(By.xpath("(//input[@class='main-zip zip'])[1]")).sendKeys("22309");
			//driver.findElement(By.xpath("(//i[@class='fa fa-twitter'])[1]")).click();
			
		 
			
			
		}
		
	}
