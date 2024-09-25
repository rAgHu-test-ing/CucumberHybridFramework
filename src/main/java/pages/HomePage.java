package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchOption;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public void clickOnMyAccount() {
		
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public LoginPage selectLoginOption() {
		
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver); 
	}
	
	public RegisterPage selectRegisterOption() {
		
		elementUtils.clickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	
	public void searchOption(String Product) {
		
		searchOption.sendKeys(Product);
	}
	
	public SearchResultsPage clickOnSearch() {
		
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultsPage(driver);
	}

}
