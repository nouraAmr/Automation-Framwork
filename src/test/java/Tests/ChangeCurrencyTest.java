package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailFriendPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailesPage;
import Pages.SearchPage;
import Pages.UserRegisterationPage;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class ChangeCurrencyTest extends TestBase{
	String productName="Apple MacBook Pro 13-inch";
	
	
  @Test (priority=1)
  public void UserCanChangeCurrency() 
  {
	  HomePageobject=new HomePage(driver);
	  HomePageobject.ChangeCurrency();
  }
  @Test (priority=2)
  public void UserCanSearchWithAutoSuggest() {
	  try {
			SearchPageObject=new SearchPage(driver);
			SearchPageObject.AutoSuggestProducts("MacB");
			ProductDetailesPageObject=new ProductDetailesPage(driver);
			Assert.assertEquals(ProductDetailesPageObject.productnamebreadcrumb.getText(), productName);
			Assert.assertTrue(ProductDetailesPageObject.productpricelbl.getText().contains("€"));
			System.out.println();
		}
		catch(Exception e){
			System.out.println("error occurred"+e.getMessage());
			
		}
	
  }
  
  
}
