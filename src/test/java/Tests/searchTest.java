package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailesPage;
import Pages.SearchPage;

public class searchTest extends TestBase {
	String productName="Apple MacBook Pro 13-inch";
	
	@Test
	public void usercansearchforproduct() {
		
		SearchPageObject=new SearchPage(driver);
		ProductDetailesPageObject=new ProductDetailesPage(driver);
		SearchPageObject.productsearch(productName);
		SearchPageObject.openproductdetailes();
		Assert.assertTrue(ProductDetailesPageObject.productnamebreadcrumb.getText().equalsIgnoreCase(productName));
	//Assert.assertEquals(ProductDetailesPageObject.productnamebreadcrumb.getText(), productName);
	}  
	
}
