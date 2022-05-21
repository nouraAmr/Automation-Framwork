package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
	@FindBy(id="Email")
	WebElement email_login;
	
	@FindBy(id="Password")
	WebElement Password_login;
	
	@FindBy(css="button.button-1.login-button")
	WebElement btn_login;
	
	
	public void LoginSuccessfully(String email,String password) {
		sendTextElementText(email_login,email);
		sendTextElementText(Password_login,password);
		clickButton(btn_login);
		
	}
}
