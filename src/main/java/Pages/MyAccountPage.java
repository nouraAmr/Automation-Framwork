package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText="Change password")
	public WebElement Change_password_link;
	
	@FindBy(id="OldPassword")
	public WebElement OldPasswordTxt;
	
	@FindBy(id="NewPassword")
	public WebElement NewPasswordTxt;
	
	@FindBy(id="ConfirmNewPassword")
	public WebElement ConfirmNewPasswordTxt;
	
	@FindBy(css="button.button-1.change-password-button")
	public WebElement ChangePasswordBtn;
	
	@FindBy(css="p.content")
	public WebElement resultlbl;
	
	@FindBy(css="span.close")
	public WebElement closebtn;
	
	public void OpenChangePasswordPage() {
		clickButton(Change_password_link);
	}
	
	public void CloseChangeMessage() {
		clickButton(closebtn);
	}


	public void ChangePassword(String oldPassword, String newPassword, String confirmNewPassword) {
		sendTextElementText(OldPasswordTxt, oldPassword ) ;
		sendTextElementText(NewPasswordTxt, newPassword ) ;
		sendTextElementText(ConfirmNewPasswordTxt, confirmNewPassword ) ;
		clickButton(ChangePasswordBtn);
		
	}
	
}
