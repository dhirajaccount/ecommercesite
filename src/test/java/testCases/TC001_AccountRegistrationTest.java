package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest {//
	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}

	@Test
	public void verify_account_registration() {
		/*
		 * HomePage hp = new HomePage(driver); hp.clickMyAccount();
		 * hp.clickMyRegister();
		 * 
		 * AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		 * 
		 * regpage.setFirstname("jiddi"); 
		 * regpage.setLastname("ladka");
		 * //regpage.setEmail("jiddiladka@gmail.com");
		 * 
		 * regpage.setEmail(randomString()+"@gmail.com"); // randomly generated the
		 * email
		 * 
		 * //regpage.setTelephone("0123456789"); regpage.setTelephone(randomNumber());
		 * 
		 * //regpage.setPassword("abc@123");
		 * 
		 * String password = randomAlphaNumeric(); regpage.setPassword(password);
		 * 
		 * //regpage.setConfirmPassword("abc@123");
		 * regpage.setConfirmPassword(password); regpage.setNewsLetter();
		 * 
		 * regpage.setPolicy(); regpage.clickContinue();
		 * 
		 * String confmsg = regpage.getConfirmationMsg();//2 confirmation msg
		 * Assert.assertEquals(confmsg, "Yout Account Has Been Created!");
		 */
		
		
		
		//-------------------------
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickMyRegister();

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

		regpage.setFirstname(randomString().toUpperCase()); 
		regpage.setLastname(randomString().toUpperCase(null));
		

		regpage.setEmail(randomString()+"@gmail.com"); // randomly generated the email

		
		regpage.setTelephone(randomNumber());
			
		String password = randomAlphaNumeric();
		
		regpage.setPassword(password); 
		regpage.setConfirmPassword(password);
		regpage.setNewsLetter();

		regpage.setPolicy(); 
		regpage.clickContinue();

		String confmsg = regpage.getConfirmationMsg();//2 confirmation msg
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		
		

	}
	public String randomString() { //line no 47 only for email //line no 74 &75
		String generatedstring= RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	public String randomNumber() {//linee no 81
		String generatednumber =RandomStringUtils.randomNumeric(5);
		return generatednumber;
	}
	public String randomAlphaNumeric() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		String generatednumber = RandomStringUtils.randomNumeric(5);
		return(generatedstring+"@"+generatednumber);
	}
}
