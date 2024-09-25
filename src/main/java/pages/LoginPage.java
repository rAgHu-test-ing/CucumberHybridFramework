package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[text()='Warning: No match for E-Mail Address and/or Password.']")
	private WebElement invalidEmailWarningMessage;
	
	public WebElement emailField() {
		
		return emailField;
	}
	
	public WebElement passwordField() {
		
		return passwordField;
	}
	
	public AccountPage clickOnLoginButton() {
		
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	
	public boolean invalidEmailWarningMessage() {
		
		return invalidEmailWarningMessage.isDisplayed();
	}

}
