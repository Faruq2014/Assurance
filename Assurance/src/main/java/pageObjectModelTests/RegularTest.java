package pageObjectModelTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjectModelPages.RegularClass;

public class RegularTest {
	WebDriver driver;

	@Test
	public void loginTest()  {
		RegularClass rc = new RegularClass(driver); // lets follow manual test case
		rc.openApp();                // open the application
		rc.homeUrlValidationTest(); // home page will open and validate the home page
		rc.clickOnLonginLink();      // click on my account login button
		rc.switchToChildWindow();    // two page open then go to child page.
		rc.logInUrlValidationTest(); // login page will open validate login page 
		rc.loginFunctionalityTest("kamal", "123456");// enter credential and press enter
		rc.loginValidationTitleTest(); // landing page with user name will open, validate the page.
		rc.closeApp();                   // close the application. 

	}


}
