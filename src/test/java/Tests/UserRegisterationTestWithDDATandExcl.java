package Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;

import org.testng.AssertJUnit;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;

public class UserRegisterationTestWithDDATandExcl extends TestBase {
    
@DataProvider(name="ExcelData")
public Object[][] UserRegisterationData() throws IOException{
	//get data from excel reader class
	ExcelReader ER=new ExcelReader();
	return ER.getExcelData();
}
	
	@Test (priority=1,alwaysRun=true,dataProvider="ExcelData" )
	public void registerUserSuccessfully(String FN,String LN,String email,String company,String password,String ConfirmPassword) {
		
		HomePageobject=new HomePage(driver);
		HomePageobject.clickonregister();
        UserRegisterationPageobject=new UserRegisterationPage(driver);
        UserRegisterationPageobject.btn_register(FN, LN, email,company,password,ConfirmPassword);
        Assert.assertTrue(UserRegisterationPageobject.sucessMessage.getText().contains("Your registration completed"));
        UserRegisterationPageobject.log_out();
        HomePageobject.clickonlogin();
		UserLoginPageObject=new LoginPage(driver);
		//Assert.assertTrue(UserRegisterationPageobject.Log_outbtn.getText().equals("Log out"));
		UserLoginPageObject.LoginSuccessfully( email, password);
		UserRegisterationPageobject.log_out();
	}
	

}
