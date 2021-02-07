package pageObjectModelTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModelPages.LoginPage;
import pageObjectModelPages.PageFactoryPage;

public class LoginTest {
	WebDriver driver;
	
	@BeforeTest(groups={"functional","regression"})
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);

	}

	@Test(priority=1, groups={"functional"} )
	public void myAccountLoginLinkTest() {
		LoginPage lp = new LoginPage(driver);
		lp.myAccountLoginLink();
	}
	@Test(priority=2, groups={"functional"} )
	public void switchToChildWindowTest(){
		LoginPage lp = new LoginPage(driver);
		lp.switchToChildWindow();
	}

	@Test(priority=3, groups= {"functional"})
	public void userNameTest() {
		LoginPage lp = new LoginPage(driver);
		lp.username("Farid");
	}

	@Test(priority=4, groups= {"functional"})
	public void passwordLinkTest() {
		LoginPage lp = new LoginPage(driver);
		lp.passwordLink("1233444");
	}

	@Test(priority=5, groups= {"functional"})
	public void submitTest() {
		LoginPage lp = new LoginPage(driver);
		lp.submitFunctionalty();
	}

	@Test(priority=6, groups= {"regression"})
	public void loginRegresationTest() {
		LoginPage lp = new LoginPage(driver);
		lp.loginRegresation("Farid", "12345");
	}
	
	@AfterTest(groups={"functional","regression"})
	public void tearDown() {
		if (driver!=null) {
			driver.quit();
		}
	}

}

















