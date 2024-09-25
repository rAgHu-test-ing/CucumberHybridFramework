package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	
	WebDriver driver;
	CommonUtils commonUtils;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@Given("User navigates to Login Page")
	public void user_navigates_to_login_page() {
	  
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();

	}
	
	@When("^User enters the valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String username) {
		
		loginPage.emailField().sendKeys(username);
		
	}
	@And("^User enters the valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String password) {
		
		loginPage.passwordField().sendKeys(password);
	}
	
	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
		accountPage = loginPage.clickOnLoginButton();
	   
	}

	@Then("User should get logged in successfully")
	public void user_should_get_logged_in_successfully() {
		
		Assert.assertTrue(accountPage.editYourAccountInformationText());	    
	}
	
	@When("User enters the invalid email address into email field")
	public void user_enters_the_invalid_email_address_into_email_field() {
		
		commonUtils = new CommonUtils();
		loginPage.emailField().sendKeys(commonUtils.getEmailWithTimeStamp());	    
	}

	@When("User enters the invalid password {string} into password field")
	public void user_enters_the_invalid_password_into_password_field(String invalidPassword) {
		
		loginPage.passwordField().sendKeys(invalidPassword);	    
	}

	@Then("User should get a proper warning message")
	public void user_should_get_a_proper_warning_message() {
		
		Assert.assertTrue(loginPage.invalidEmailWarningMessage());
	    
	}

	@When("User dont enter email into email field")
	public void user_dont_enter_email_into_email_field() {
		
		loginPage.emailField().sendKeys("");
	    
	}

	@And("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
	    
		loginPage.passwordField().sendKeys("");
	}
}
