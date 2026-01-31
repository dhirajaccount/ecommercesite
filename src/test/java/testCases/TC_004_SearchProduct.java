package testCases;

import org.testng.annotations.Test;

import pageObjects.SearchProducts;
import testBase.BaseClass;

public class TC_004_SearchProduct extends BaseClass{
@Test
public void verify_search_products() throws InterruptedException  {
	
	SearchProducts sp = new SearchProducts(driver);
	sp.searchbtn("iphone");
	sp.clicksearch();
	
	sp.addtocart();
	sp.clickonitem();
	sp.clickonviewbtn();
	
	sp.clickoncheckout();
}
}
