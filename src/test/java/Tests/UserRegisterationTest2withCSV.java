package Tests;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import org.testng.AssertJUnit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;

public class UserRegisterationTest2withCSV extends TestBase {
    

	CSVReader reader;
	
	@Test (priority=1,alwaysRun=true)
	public void registerUserSuccessfully() throws IOException {
		String csv_File=System.getProperty("user.dir")+"/src/test/java/Data/UserData.csv";
		reader=new CSVReader(new FileReader(csv_File));
		String [] csvCell;
		
		while((csvCell=reader.readNext()) !=null) {
		String f_name=csvCell[0];	
		String l_name=csvCell[1];	
		String email=csvCell[2];
		String pass=csvCell[3];
	
		
		HomePageobject=new HomePage(driver);
        UserRegisterationPageobject=new UserRegisterationPage(driver);
        HomePageobject.clickonregister();
        UserRegisterationPageobject.btn_register(f_name, l_name, email, "helwan",pass,pass);
        AssertJUnit.assertTrue(UserRegisterationPageobject.sucessMessage.getText().contains("Your registration completed"));
        UserRegisterationPageobject.log_out();
		HomePageobject.clickonlogin();
		UserLoginPageObject=new LoginPage(driver);
		//Assert.assertTrue(UserRegisterationPageobject.Log_outbtn.getText().equals("Log out"));
		UserLoginPageObject.LoginSuccessfully( email, pass);
		UserRegisterationPageobject.log_out();
			
		}
	
	}

}
