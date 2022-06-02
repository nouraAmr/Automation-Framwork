 package Tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;

public class UserRegisterationwithDDTAandDataProvider extends TestBase{
@DataProvider(name="TestData")
public static Object[][] userData(){
	return new Object[][] {
		{"noura","ahmed","nouraahmed115@gmail.com","ain shams","123654","123654"},
		{"noura","ahmed","nouraahmed12919@gmail.com","helwan","123654","123654"}
	};
	
}
	

	@Test (priority=1,alwaysRun=true,dataProvider="TestData")
	public void registerUserSuccessfully(String fn,String ln,String email,String companyName,String password ,String passwordconfirm) {
		
		HomePageobject=new HomePage(driver);
        UserRegisterationPageobject=new UserRegisterationPage(driver);
        HomePageobject.clickonregister();
        UserRegisterationPageobject.btn_register(fn,ln,email,companyName,password,passwordconfirm);
        Assert.assertTrue(UserRegisterationPageobject.sucessMessage.getText().contains("Your registration completed"));
        UserRegisterationPageobject.log_out();
        UserLoginPageObject=new LoginPage(driver);
        HomePageobject.clickonlogin();
		Assert.assertTrue(UserRegisterationPageobject.Log_outbtn.getText().equals("Log out"));
		UserLoginPageObject.LoginSuccessfully( email,password);
	    UserRegisterationPageobject.log_out();
	}

	
}
