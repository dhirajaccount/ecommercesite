package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	@Test(groups= {"Regression","Master"})
	public void verify_login() throws InterruptedException {
		try {
		logger.info("*********Starting TC_002_LoginTest ************");
		//HomePAge
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklogin();
		Thread.sleep(3000);


		//LoginPAge
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(prop.getProperty("email"));     //lp.setEmail(("dhirajdummy@gmail.com"));
		lp.setPassword(prop.getProperty("pwd"));    //lp.setPassword("test@123");
		lp.clicklogin();
		Thread.sleep(3000);

		//MyAccount

		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isAccountPageExists();
		Assert.assertTrue(targetPage);
		//Assert.assertEquals(targetPage, true,"login Failed");
		}
		catch(Exception e) {
			Assert.fail();
			
		}
		logger.info("************Finishes TC_002_LoginTest***********");
	}
}