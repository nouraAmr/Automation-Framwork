package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FriendEmail")
    WebElement FriendEmailtxt ;

	/*@FindBy(id="YourEmailAddress")
    WebElement YourEmailAddresstxt ;*/
	
	@FindBy(id="PersonalMessage")
    WebElement PersonalMessagetxt ;
	
	@FindBy(name="send-email")
	 WebElement sendemailbtn ;
	
	@FindBy(css="div.result")
	public WebElement emailmsg ;
	
	public void SendEmailToFriend(String FriendEmail,String PersonalMessage ) {
		sendTextElementText(FriendEmailtxt,FriendEmail ) ;
		sendTextElementText(PersonalMessagetxt,PersonalMessage ) ;
		 clickButton(sendemailbtn );
		 
	}
	
}
