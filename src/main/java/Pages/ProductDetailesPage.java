package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailesPage extends PageBase {

	public ProductDetailesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="strong.current-item")
	public WebElement productnamebreadcrumb;
	
	@FindBy(css="button.button-2.email-a-friend-button")
	public WebElement EmailFriendBtn;
	
	@FindBy(id="price-value-4")
	public WebElement productpricelbl;
	
	@FindBy(linkText="Add your review")
	public WebElement AddyourReviewBtn;
	
	@FindBy (id="add-to-wishlist-button-4")
    public WebElement wishlist_button;
  
	@FindBy(css="button.button-2.add-to-compare-list-button")
	public WebElement comparelistbutton;
	
	
	public void clickonemailfriendbutton() {
		clickButton(EmailFriendBtn) ;
	}
	
	public void  clickonwishlistbutton() {
		clickButton(wishlist_button);
	}
	
	public void  clickonCOMPAREbutton() {
		clickButton(comparelistbutton);
	}
	
	public void clickoneAddyourReviewbutton() {
		clickButton(AddyourReviewBtn) ;
	}
	
	
} 
