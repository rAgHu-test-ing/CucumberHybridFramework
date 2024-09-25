package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement privacyOption;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newsletterOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailWarningMessage;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyMandatoryWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']//following-sibling::div")
	private WebElement firstNameMandatoryWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']//following-sibling::div")
	private WebElement lastNameMandatoryWarning;
	
	@FindBy(xpath="//input[@id='input-email']//following-sibling::div")
	private WebElement emailMandatoryWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']//following-sibling::div")
	private WebElement telephoneMandatoryWarning;
	
	@FindBy(xpath="//input[@id='input-password']//following-sibling::div")
	private WebElement passwordMandatoryWarning;
	
	public WebElement firstNameField() {
		
		return firstNameField;
	}
	
	public WebElement lastNameField() {
		
		return lastNameField;
	}
	
	public WebElement emailField() {
		
		return emailField;
	}
	
	public WebElement telephoneField() {
		
		return telephoneField;
	}
	
	public WebElement passwordField() {
		
		return passwordField;
	}
	
	public WebElement confirmPasswordField() {
		
		return confirmPasswordField;
	}
	
	public void selectPrivacyPolicy() {
		
		elementUtils.clickOnElement(privacyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void subscribeNewsletter() {
		
		elementUtils.clickOnElement(newsletterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	public AccountSuccessPage clickOnContinueButton() {
		
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}
	
	public boolean duplicateEmailWarningMessage() {
		
		return duplicateEmailWarningMessage.isDisplayed();
	}
	
	public boolean privacyPolicyMandatoryMessageStatus() {
		
		return privacyPolicyMandatoryWarning.getText().contains("Warning: You must agree to the Privacy Policy!");
	}
	
	public boolean firstNameMandatoryMessageStatus() {
		
		return firstNameMandatoryWarning.getText().contains("First Name must be between 1 and 32 characters!");
	}
	
	public boolean lastNameMandatoryMessageStatus() {
		
		return lastNameMandatoryWarning.getText().contains("Last Name must be between 1 and 32 characters!");
	}
	
	public boolean emailMandatoryMessageStatus() {
		
		return emailMandatoryWarning.getText().contains("E-Mail Address does not appear to be valid!");
	}
	
	public boolean telephoneMandatoryMessageStatus() {
		
		return telephoneMandatoryWarning.getText().contains("Telephone must be between 3 and 32 characters!");
	}
	
	public boolean passwordMandatoryMessageStatus() {
		
		return passwordMandatoryWarning.getText().contains("Password must be between 4 and 20 characters!");
	}

}
