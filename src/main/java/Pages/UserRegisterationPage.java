package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserRegisterationPage extends PageBase{

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="gender-male")
	WebElement malechk;
	
	@FindBy(id="FirstName")
     WebElement fntxtbox;
	
	@FindBy(id="LastName")
    WebElement lntxtbox;
	
	@FindBy(id="Email")
    WebElement email;
	
	@FindBy(id="Password")
    WebElement pasword;
	
	@FindBy(id="ConfirmPassword")
    WebElement confirmpassword;
	
	@FindBy(id="Company")
    WebElement Company_name;
	
	
	@FindBy(id="register-button")
    WebElement register;
	
	@FindBy(css="div.result")
    public WebElement sucessMessage;
	
	@FindBy(linkText="Log out")
	public WebElement Log_outbtn;

	@FindBy(linkText="My account")
	public WebElement My_Accout_link;
	
		
	public void btn_register(String fristname,String lastname,String emailtxt,String Copname,String passwordtxt,String confirmpasswordtxt ) {
		malechk.click();
		fntxtbox.sendKeys(fristname);
		lntxtbox.sendKeys(lastname);
		email.sendKeys(emailtxt);
		Company_name.sendKeys(Copname);
		pasword.sendKeys(passwordtxt);
		sendTextElementText(confirmpassword,confirmpasswordtxt);
		//confirmpassword.sendKeys(confirmpasswordtxt);
		clickButton(register);
		//register.click();
		
	}
	public void log_out() {
		clickButton(Log_outbtn);
	}
	 
	
	public void OpenMy_AccountPage() {
		clickButton(My_Accout_link);
	}
	
}
