package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContectUsPage;
import Pages.HomePage;

@Test
public class ContectUsTest extends TestBase{

	String fullname="nouraa";
	String email="noura88@gmail.com";
	String Enquiry="no,thanks";
	
	public void usercanusecontectuspage() {
		HomePageobject=new HomePage(driver);
		HomePageobject.opencontectuspage();
		HomePageobject.openContectUsLink();
		ContectUsPageobject=new ContectUsPage(driver);
		ContectUsPageobject.contectus(fullname,email,Enquiry);
		Assert.assertTrue(ContectUsPageobject.successmgs.getText().contains("Your enquiry has been successfully sent to the store owner."));
}
}