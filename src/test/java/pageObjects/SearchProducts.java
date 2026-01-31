package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProducts extends BasePage{

	public SearchProducts(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@name='search']")
	WebElement searchbtn;

	@FindBy(xpath="//button[@type='button' and @class='btn btn-default btn-lg']")
	WebElement clicksearch;

	@FindBy(xpath="//span[text()='Add to Cart']")
	WebElement addtocart;

	@FindBy(xpath="//button[@type='button' and @class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement items;

	@FindBy(xpath="//strong[normalize-space()='View Cart']//parent::a")
	WebElement viewcart;

	@FindBy(xpath="//div[@class='pull-right']")
	WebElement checkout;

	public void searchbtn(String search) {
		searchbtn.click();
		searchbtn.sendKeys(search);
	}
	public void clicksearch() {
		clicksearch.click();
	}
	public void addtocart() {
		addtocart.click();
	}
	public void clickonitem() {
		items.click();
	}
	public void clickonviewbtn() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(viewcart)).click();


	}
	public void clickoncheckout() {
		checkout.click();
	}
}
