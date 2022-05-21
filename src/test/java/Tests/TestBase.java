package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Pages.ComparePage;
import Pages.ContectUsPage;
import Pages.EmailFriendPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailesPage;
import Pages.ReviewProductPage;
import Pages.SearchPage;
import Pages.UserRegisterationPage;
import Pages.wishlistPage;
//import Utilities.Helper;
import Utilities.screen_shot;


public class TestBase {
public static WebDriver driver;

HomePage HomePageobject;
UserRegisterationPage UserRegisterationPageobject;
LoginPage UserLoginPageObject;
SearchPage SearchPageObject;
ProductDetailesPage ProductDetailesPageObject;
ReviewProductPage ReviewProductPageobject;
EmailFriendPage EmailFriendPageobject;
ContectUsPage ContectUsPageobject;
wishlistPage wishlistPageobject;
ComparePage ComparePageobject;

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver( @Optional("chrome") String browsername) 
	{
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
			System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
			System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().to("http://demo.nopcommerce.com/");
	}
	
	/*@AfterMethod
	//ITestResult is interface describe the result of test
	public void Failed_screenshot(ITestResult Testcase_resuit) throws IOException {
	if(Testcase_resuit.getStatus()==ITestResult.FAILURE) {
		screen_shot.take_screenshot(driver, ".\\ScreenShot\\"+Testcase_resuit.getName()+".png");
		
		
	}
		}*/
	
	}
	
	
/*	@AfterSuite
	public void EndDriver() 
	{
		driver.quit();
	}
	*/

