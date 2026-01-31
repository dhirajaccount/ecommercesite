package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TitleCheck;
import testBase.BaseClass;

public class TC_003_Title extends BaseClass {

	@Test
	public void verify_title() throws InterruptedException {
		//HomePAge
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklogin();
		Thread.sleep(3000);


		//LoginPAge
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(("dhirajdummy@gmail.com"));
		lp.setPassword("test@123");
		lp.clicklogin();
		Thread.sleep(3000);

		//title
		TitleCheck tc= new TitleCheck(driver);
		tc.verifytitle();
	}
}