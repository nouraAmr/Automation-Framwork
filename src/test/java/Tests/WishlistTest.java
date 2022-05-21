package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailesPage;
import Pages.SearchPage;
import Pages.wishlistPage;


public class WishlistTest extends TestBase{

	
	//wishlistPageobject.
String productName="Apple MacBook Pro 13-inch";



	//1- search
	@Test(priority=1)
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
	
	@Test(priority=2)
	public void AddProductToWishlist() throws InterruptedException {
		
		ProductDetailesPageObject.clickonwishlistbutton();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wishlistPageobject=new wishlistPage(driver);
        Assert.assertTrue(wishlistPageobject.wishlist.isDisplayed());
		Assert.assertTrue(wishlistPageobject.productname.getText().equals(productName));
		wishlistPageobject.RemoveProductFromWishList();
		Assert.assertTrue(wishlistPageobject.emptyMessage.getText().contains("The wishlist is empty!"));
		 
	}

}
