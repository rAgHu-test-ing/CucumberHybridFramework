package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validProductResult;
	
	@FindBy(xpath="//input[@id='button-search']//following::p[1]")
	private WebElement noProductMatchingMessage;
	
	
	public String validProductResult() {
		
		return validProductResult.getText();
	}
	
	public String noProductMatchStatus() {
		
		return noProductMatchingMessage.getText();
	}

}
