package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass_normal {
	public WebDriver driver;
	public Logger logger;

	@BeforeClass
	public void setup() {
		
		logger=LogManager.getLogger(this.getClass());
		
		
		
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


