package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC0011_AccountRegistrationTest extends BaseClass{//4

	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() {

		logger.info("*********************TC0011_AccountRegistrationTest**********");

		try {

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
			logger.info("click on my account link");

			hp.clickMyRegister();
			logger.info("click on reg Page");
			//---------------




			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("*****client details **************");

			regpage.setFirstname(randomString().toUpperCase()); 
			regpage.setLastname(randomString().toUpperCase());


			regpage.setEmail(randomString()+"@gmail.com"); // randomly generated the email


			regpage.setTelephone(randomNumber());

			String password = randomAlphaNumeric();

			regpage.setPassword(password); 
			regpage.setConfirmPassword(password);
			regpage.setNewsLetter();

			regpage.setPolicy(); 
			regpage.clickContinue();

			logger.info("*********validate msg********");
			String confmsg = regpage.getConfirmationMsg();//2 confirmation msg
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) 
		{

			/*
			 * logger.error("Test failed.."); 
			 * logger.debug("Debug logs....");
			 */
			Assert.fail();
		}

		logger.info(".......finish TC001_AccountRegistrationTest.....");
	}
}
