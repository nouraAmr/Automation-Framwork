package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse=(JavascriptExecutor)driver;
		action=new Actions(driver);
	}
	
	@FindBy(linkText="Register")
	WebElement registerbtn;
	
	@FindBy(linkText="Log in")
	WebElement loginbtn;
	
	@FindBy(linkText="Contact us")
	WebElement ContactUsLink;
	
	
	@FindBy(id="customerCurrency")
	WebElement Currencydrl;
	
	@FindBy(linkText="Computers")
	WebElement ComputersMenu ;
	
	@FindBy(linkText="Notebooks")
	WebElement NotebooksMenu;

	
	
	
	public void clickonregister() {
		registerbtn.click();
	}
	
	public void clickonlogin() {
		loginbtn.click();
	}
	
	public void openContectUsLink() {
		clickButton(ContactUsLink) ;
	}
	
	public void opencontectuspage() {
		scrollbutton();
		}
	
	public void ChangeCurrency() {
		select=new Select(Currencydrl);//select define in pagebase
		select.selectByVisibleText("Euro");
	}
	
	
	public void selectNotebookMenu() {
		action.moveToElement(ComputersMenu).moveToElement(NotebooksMenu).click().build().perform();
	}
	
	}
  

