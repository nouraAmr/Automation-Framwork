package Tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import Pages.EmailFriendPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailesPage;
import Pages.ReviewProductPage;
import Pages.SearchPage;
import Pages.UserRegisterationPage;

public class ReviewPageTest extends TestBase{
    //user register
	//search
	//add review
	//logout

	
	
	String productName="Apple MacBook Pro 13-inch";
	String friendEmail="yara50@gmail.com";
	String messageText="this product is very bad ,in my opinion don't buy it";
	String Reviewtitle="New Review";
	String Reviewtext="this product is very good";
	
	//1-user register
		@Test (priority=1,alwaysRun=true)
		    public void registerUserSuccessfully() {
			HomePageobject=new HomePage(driver);
	        UserRegisterationPageobject=new UserRegisterationPage(driver);
	        HomePageobject.clickonregister();
	        UserRegisterationPageobject.btn_register("noura", "amr", "noura4444@gmail.com", "Helwan University","54321&,","54321&,");
	        AssertJUnit.assertTrue(UserRegisterationPageobject.sucessMessage.getText().contains("Your registration completed"));
		   }
	
		 //2-search
		@Test(priority=2)
		public void usercansearchforproduct() {
			
			SearchPageObject=new SearchPage(driver);
			ProductDetailesPageObject=new ProductDetailesPage(driver);
			SearchPageObject.productsearch(productName);
			SearchPageObject.openproductdetailes();
			Assert.assertTrue(ProductDetailesPageObject.productnamebreadcrumb.getText().equalsIgnoreCase(productName));
		//Assert.assertEquals(ProductDetailesPageObject.productnamebreadcrumb.getText(), productName);
		} 
		
		//3-add review
		@Test(priority=3)
	   public void RegisterUserCanReviewProduct() {
			ProductDetailesPageObject.clickoneAddyourReviewbutton();
			ReviewProductPageobject=new ReviewProductPage(driver);
			ReviewProductPageobject.AddProductReview(Reviewtitle, Reviewtext);
			Assert.assertTrue(ReviewProductPageobject.successMgs.getText().contains("Product review is successfully added."));
		
}
       //4-logout
	    @Test(priority=4)
		public void User_Can_log_out()
		{UserRegisterationPageobject.log_out();}
}











