package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewProductPage extends PageBase{

	public ReviewProductPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewtitle;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement Reviewtext;
	
	@FindBy(id="addproductrating_4")
	WebElement rating4Rdobtn;
	
	@FindBy(name="add-review")
	WebElement addreviewbtn;
	
	@FindBy(css="div.result")
	public WebElement successMgs;
	

	public void AddProductReview(String reviewtitlevalue,String Reviewtextvalue) {
		sendTextElementText(reviewtitle,reviewtitlevalue) ;
		sendTextElementText(Reviewtext,Reviewtextvalue) ;
		clickButton(rating4Rdobtn);
		clickButton(addreviewbtn);
		
	}
}
