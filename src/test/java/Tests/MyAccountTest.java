package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisterationPage;

public class MyAccountTest extends TestBase {
	HomePage HomePageobject;
	MyAccountPage MyAccountPageObject;
	UserRegisterationPage UserRegisterationPageobject;
	LoginPage UserLoginPageObject;
	//للتسهيل
	String fristName="nada";
	String lastname="samy";
	String email="noura992@gmail.com";
	
	String oldPassword="54321&,";
	String newPassword="123456";
	String confirmPassword="123456";
	
	@Test (priority=1)
	public void registerUserSuccessfully() {
		
		HomePageobject=new HomePage(driver);
        UserRegisterationPageobject=new UserRegisterationPage(driver);
        HomePageobject.clickonregister();
        UserRegisterationPageobject.btn_register(fristName, lastname, email, "Helwan University",oldPassword,oldPassword);
        AssertJUnit.assertTrue(UserRegisterationPageobject.sucessMessage.getText().contains("Your registration completed"));
	}
	
	
	@Test(priority=2)
	public void RegisterUserCanChangePassword() {
		MyAccountPageObject =new MyAccountPage(driver);
		UserRegisterationPageobject.OpenMy_AccountPage();
		MyAccountPageObject.OpenChangePasswordPage();
		MyAccountPageObject.ChangePassword(oldPassword,newPassword,confirmPassword);
		Assert.assertTrue(MyAccountPageObject.resultlbl.getText().contains("Password was changed"));
		MyAccountPageObject.CloseChangeMessage();
		
		
	}
	
	@Test(priority=3)
	public void User_Can_log_out()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UserRegisterationPageobject.log_out();
	}
	
	@Test(priority=4)
	public void User_Can_log_in()
	{
		HomePageobject.clickonlogin();
		UserLoginPageObject=new LoginPage(driver);
		UserLoginPageObject.LoginSuccessfully( email, newPassword);
		Assert.assertTrue(UserRegisterationPageobject.Log_outbtn.getText().equals("Log out"));
	}
}
