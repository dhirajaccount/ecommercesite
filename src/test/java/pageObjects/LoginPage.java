package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement MailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement Mailpassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement Login;

	
	public void setEmail(String email) {
		MailAddress.sendKeys(email);
	}
	public void setPassword(String pass) {
		Mailpassword.sendKeys(pass);
	}
	public void clicklogin() {
		Login.click();
	}
}
