package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sun.tools.javac.util.Assert;




public class wishlistPage extends PageBase{

	public wishlistPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="p.content")
	public WebElement barMessage;
	
	@FindBy(css="h1")
	public WebElement wishlist;
	
	@FindBy(css="td.product")
	public WebElement productname;
	
	@FindBy(name="updatecart")
	public WebElement remove_btn;
	
	@FindBy(css="no-data")
	public WebElement emptyMessage;
	
	
	public void RemoveProductFromWishList() {
		clickButton(remove_btn);
	
	}

}
