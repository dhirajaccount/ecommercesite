package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {//5

	public WebDriver driver;
	public Logger logger;//LOG4J
	public Properties prop;//prop
	FileInputStream file;

	@Parameters({"os","browser"})//6
	@BeforeClass (groups= {"Sanity","Regression","Master"}) //grouping.xml
	public void setup(String os, String br) throws IOException {
	

		//file loading config  //7

		String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
		file = new FileInputStream(path);
		prop = new Properties();
		prop.load(file);

		//------------------

		logger=LogManager.getLogger(this.getClass());//TEST CASE011

		//parallel testing 
		switch(br.toLowerCase()) { 
		case "chrome" : driver = new ChromeDriver() ;break; 
		case "edge" : driver = new EdgeDriver() ; break; 
		case "firefox" :driver = new FirefoxDriver(); break; 
		default :System.out.println("Invalid browser name...."); return; 
		}
		//-----------------
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterClass (groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();

	}

	public String randomString() { //line no 47 only for email //line no 74 &75
		String generatedstring= RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	public String randomNumber() {//line no 81
		String generatednumber =RandomStringUtils.randomNumeric(5);
		return generatednumber;
	}
	public String randomAlphaNumeric() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		String generatednumber = RandomStringUtils.randomNumeric(5);
		return(generatedstring+"@"+generatednumber);
	}
	public String captureScreen(String tname)  throws IOException{
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File SourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String targetfilepath = "C:\\Users\\dheeraj\\eclipse-workspace\\OpencartV121\\screenshots\\" + tname + " " + timeStamp
					+ ".png";// = System.getProperty("user.dir")+"\\screenshots\\"
			File targetfile = new File(targetfilepath);

			SourceFile.renameTo(targetfile);
			return targetfilepath;

		}
	}
}