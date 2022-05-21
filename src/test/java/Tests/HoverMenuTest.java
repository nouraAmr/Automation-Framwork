package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class HoverMenuTest 	extends TestBase{

	HomePage HomePageobject;
	
	@Test 
	public void UserCanSelectSubCategoryFromMainCategory () {
		HomePageobject=new HomePage(driver);
		HomePageobject.selectNotebookMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("Notebooks"));
	}
}
