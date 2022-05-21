package Tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import Pages.EmailFriendPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailesPage;
import Pages.SearchPage;
import Pages.UserRegisterationPage;
import Pages.ProductDetailesPage;
import Pages.SearchPage;

public class EmailFriendTest extends TestBase {
	
	//send email
	HomePage HomePageobject;
	EmailFriendPage EmailFriendPageobject;
	UserRegisterationPage UserRegisterationPageobject;
	LoginPage UserLoginPageObject;
	SearchPage SearchPageObject;
	ProductDetailesPage ProductDetailesPageObject;
	EmailFriendPage EmailFriendPageObject;
	
	String productName="Apple MacBook Pro 13-inch";
	String friendEmail="yara50@gmail.com";
	String messageText="this product is very bad ,in my opinion don't buy it";
	
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
	
	//3-send email
	@Test(priority=3)
	public void registerUserCanSendProductToFriend() {
		ProductDetailesPageObject.clickonemailfriendbutton();
		EmailFriendPageObject =new EmailFriendPage(driver);
		EmailFriendPageObject.SendEmailToFriend(friendEmail,messageText );
		Assert.assertTrue(EmailFriendPageObject.emailmsg.getText().contains("Your message has been sent."));
		
	}
	
	    @Test(priority=4)
		public void User_Can_log_out()
		{UserRegisterationPageobject.log_out();}
	
	
}
