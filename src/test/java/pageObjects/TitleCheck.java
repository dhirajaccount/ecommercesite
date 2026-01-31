package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TitleCheck extends BasePage{

	public TitleCheck(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy (xpath="//a[text()='Qafox.com']")
	WebElement checktitle;

	public void verifytitle() {
		/*
		 * try { return (checktitle.getText()); } catch (Exception e) { return
		 * (e.getMessage()); }
		 */
		Assert.assertEquals(driver.getTitle(),"Your Store");
	}
}
