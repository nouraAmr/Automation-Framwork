package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="table.compare-products-table")
	WebElement compareTable;
	
	@FindBy(css="a.clear-list")
	WebElement clearbtn;
	
	@FindBy(tagName="tr")
	List<WebElement> allRows;
	
	@FindBy(tagName="td")
	List<WebElement> allCol;
	
	@FindBy(css="div.no-data")
	WebElement successMgs;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public
	WebElement prod1;
	
	@FindBy(linkText="Asus N551JK-XO076H Laptop")
	public WebElement prod2;
	
	
	public void clickonclearbtn() {
		clickButton(clearbtn);
	}
	public void copmareProduct() {
		//get all rows
		System.out.println(allRows.size());
		System.out.println(allCol.size());
		for(WebElement row:allRows) {
			System.out.println(row.getText()+"\t");
			for(WebElement col:allRows) {
				System.out.println(col.getText()+"\t");
			}
		}
	}
}





