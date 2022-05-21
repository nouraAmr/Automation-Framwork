package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id="small-searchterms")
	WebElement searchbar;
	
	@FindBy(css="button.button-1.search-box-button")
	WebElement searchbtn;
	
	
	@FindBy(id="ui-id-1")
	List<WebElement> productlist;
	
	  //@FindBy(css="h2.product-title")
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement producttitle ;
	
	public void productsearch(String productnanme) {
		
		sendTextElementText(searchbar,productnanme);
		clickButton(searchbtn);
	}
    public void openproductdetailes() {
    	clickButton(producttitle);
	
	}
    public void AutoSuggestProducts(String searchtxt) {
    	sendTextElementText(searchbar,searchtxt);
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	productlist.get(0).click(); 
    }
	
	
}
