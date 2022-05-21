package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailesPage;
import Pages.SearchPage;

public class SearchProductUsingAutoSuggestTest extends TestBase{
	String productName="Apple MacBook Pro 13-inch";
	
	@Test
	public void UserCanSearchWithAutoSuggest() {
		try {
			SearchPageObject=new SearchPage(driver);
			SearchPageObject.AutoSuggestProducts("MacB");
			ProductDetailesPageObject=new ProductDetailesPage(driver);
			Assert.assertEquals(ProductDetailesPageObject.productnamebreadcrumb.getText(), productName);
		}
		catch(Exception e){
			System.out.println("error occurred"+e.getMessage());
			
		}
	}
	
}
