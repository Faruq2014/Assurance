package pageObjectModelTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModelPages.PageFactoryPage;

public class PagefactoryTest {
	WebDriver driver;
	@BeforeTest (groups= {"functional","regressional","smoke"})
	public void startTest() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=0, groups= {"functional","regressional","smoke"})
 public void homePageValidationTest() {
		PageFactoryPage pfg= new PageFactoryPage(driver);
		pfg.homePageTitleTest();
		pfg.homePgeUrlTest();
 }

	@Test(priority=1, groups= {"functional"})
	public void loginLinkTest() {
		PageFactoryPage pfg= new PageFactoryPage(driver);
		pfg.clickOnLoginLink();  

	}

	@Test(priority=2, groups= {"functional"})
	public void switchToChildWindow() {
		PageFactoryPage pfg= new PageFactoryPage(driver);
		pfg.switchToChildWindow(); 

	}

	@Test(priority=3, groups= {"functional"})
	public void userNameTest() {
		PageFactoryPage pfg= new PageFactoryPage(driver);
		pfg.userNameFunctionaltyTest("Nahida"); 	  
	}

	@Test(priority=4, groups= {"functional"})
	public void passwordTest() {
		PageFactoryPage pfg= new PageFactoryPage(driver);
		pfg.passwordFunctionaltyTest("123456"); 	  
	}

	@Test(priority=5, groups= {"functional"})
	public void ubmitTest() {
		PageFactoryPage pfg= new PageFactoryPage(driver);
		pfg.submitFunctionaltyTest();
	}


	@Test(priority=6, groups= {"regressional","smoke"})
	public void loginRegressionTest() {
		PageFactoryPage pfg= new PageFactoryPage(driver);
		pfg.loginRegrationTest("Yoness", "123456");
	}
	
	@Test(priority=7, groups= {"functional","regressional","smoke"})
	public void landingPageValidationTest() {
		PageFactoryPage pfg= new PageFactoryPage(driver);
		pfg.landingPageValidationTest();
	}

	@AfterTest(groups= {"functional","regressional","smoke"})
	public void closeApp() {
		if(driver!=null) {
			//driver.quit();
		}
	}


}







