package Tests;

import org.testng.annotations.Test;

import Data.LoadProperties;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;

public class UserRegisterationTestwithDDTAandpropertiesfile extends TestBase {
    
String FN=LoadProperties.userData.getProperty("fristname");
String LN=LoadProperties.userData.getProperty("lastname");
String email=LoadProperties.userData.getProperty("email");
String company=LoadProperties.userData.getProperty("company");
String pass=LoadProperties.userData.getProperty("password");
String passcon=LoadProperties.userData.getProperty("passwordconfirm");



	
	@Test (priority=1,alwaysRun=true)
	public void registerUserSuccessfully() {
		
		System.out.println(LoadProperties.userData);
		HomePageobject=new HomePage(driver);
        UserRegisterationPageobject=new UserRegisterationPage(driver);
        HomePageobject.clickonregister();
        UserRegisterationPageobject.btn_register(FN,LN, email, company,pass,passcon);
        Assert.assertTrue(UserRegisterationPageobject.sucessMessage.getText().contains("Your registration completed"));
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
		UserLoginPageObject.LoginSuccessfully(email,pass);
	}
	
}
