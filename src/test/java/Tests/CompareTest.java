package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ComparePage;
import Pages.ProductDetailesPage;
import Pages.SearchPage;

public class CompareTest extends TestBase {
    // 1- search for product number1
	// 2-search for product number2
	// 3-Add to compare
	// 4-clear list
	String product_number1="Apple MacBook Pro 13-inch";
	String product_number2="Asus N551JK-XO076H Laptop";
	
	
	@Test
	public void UserCanSearchWithAutoSuggest() throws InterruptedException {
		
			
			SearchPageObject=new SearchPage(driver);
			ProductDetailesPageObject=new ProductDetailesPage(driver);
			ComparePageobject=new ComparePage(driver);
		
			SearchPageObject.AutoSuggestProducts("MacB");
			Assert.assertEquals(ProductDetailesPageObject.productnamebreadcrumb.getText(), product_number1);
			ProductDetailesPageObject.clickonCOMPAREbutton();
		    SearchPageObject.AutoSuggestProducts("Asus");
			Assert.assertEquals(ProductDetailesPageObject.productnamebreadcrumb.getText(), product_number2);
			ProductDetailesPageObject.clickonCOMPAREbutton();
			Thread.sleep(3000);
			driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
			ComparePageobject.copmareProduct(); 
			Assert.assertTrue(ComparePageobject.prod1.getText().equals("Apple MacBook Pro 13-inch"));
			Assert.assertTrue(ComparePageobject.prod2.getText().equals("Asus N551JK-XO076H Laptop"));
	}
	
	/*public void UserCanCompareProduct() {
		
		
		
	}*/
	
}
