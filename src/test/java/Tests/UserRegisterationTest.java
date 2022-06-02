package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {
    

	
	@Test (priority=1,alwaysRun=true)
	public void registerUserSuccessfully() {
		
		HomePageobject=new HomePage(driver);
        UserRegisterationPageobject=new UserRegisterationPage(driver);
        HomePageobject.clickonregister();
        UserRegisterationPageobject.btn_register("Ahmeg", "samy", "Ahmed4100@gmail.com", "Helwan University","54321&,","54321&,");
        AssertJUnit.assertTrue(UserRegisterationPageobject.sucessMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods={"registerUserSuccessfully"})
	public void User_Can_log_out()
	{
		UserRegisterationPageobject.log_out();
	}
	
	@Test(dependsOnMethods={"User_Can_log_out"})
	public void User_Can_log_in()
	{
		HomePageobject.clickonlogin();
		UserLoginPageObject=new LoginPage(driver);
		//Assert.assertTrue(UserRegisterationPageobject.Log_outbtn.getText().equals("Log out"));
		UserLoginPageObject.LoginSuccessfully( "Ahmed4100@gmail.com", "54321&,");
	}
	
}
