package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContectUsPage extends PageBase{

	public ContectUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="FullName")
	WebElement FullNametxt;
	
	@FindBy(id="Email")
	WebElement Emailtxt;
	
	@FindBy(id="Enquiry")
	WebElement Enquirytxt; 
	
	@FindBy(name="send-email")
	WebElement submitbtn;
	
	@FindBy(css="div.result")
	public WebElement successmgs;
	
	public void contectus(String FullName,String Email,String Enquiry) {
		sendTextElementText(FullNametxt,FullName) ;
		sendTextElementText(Emailtxt,Email) ;
		sendTextElementText(Enquirytxt,Enquiry) ;
		clickButton(submitbtn) ;
	}

}
