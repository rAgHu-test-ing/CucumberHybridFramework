package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	CommonUtils commonUtils;
	HomePage homePage;
	AccountPage accountPage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	@Given("User navigates to Register Account Page")
	public void user_navigates_to_register_account_page() {
		
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		commonUtils = new CommonUtils();
		
		registerPage.firstNameField().sendKeys(dataMap.get("firstName"));
		registerPage.lastNameField().sendKeys(dataMap.get("lastName"));
		registerPage.emailField().sendKeys(commonUtils.getEmailWithTimeStamp());
		registerPage.telephoneField().sendKeys(dataMap.get("telephone"));
		registerPage.passwordField().sendKeys(dataMap.get("password"));
		registerPage.confirmPasswordField().sendKeys(dataMap.get("password"));		
	}

	@And("User selects privacy policy")
	public void user_selects_privacy_policy() {
	    
		registerPage.selectPrivacyPolicy();
	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		
		accountSuccessPage = registerPage.clickOnContinueButton();
	    
	}
	
	@And("User selects Yes for newsletter")
	public void user_selects_yes_for_newsletter() {
		
		registerPage.subscribeNewsletter();    
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	   
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
	}

	@Then("User account should get a proper warning about duplicate email")
	public void user_account_should_get_a_proper_warning_about_duplicate_email() {
		
		Assert.assertTrue(registerPage.duplicateEmailWarningMessage());
	    
	}
	
	@When("User enters exisiting email along with other below fields")
	public void User_enters_exisiting_email_along_with_other_below_fields(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);

		registerPage.firstNameField().sendKeys(dataMap.get("firstName"));
		registerPage.lastNameField().sendKeys(dataMap.get("lastName"));
		registerPage.emailField().sendKeys(dataMap.get("emailAddress"));
		registerPage.telephoneField().sendKeys(dataMap.get("telephone"));
		registerPage.passwordField().sendKeys(dataMap.get("password"));
		registerPage.confirmPasswordField().sendKeys(dataMap.get("password"));	
	}

	@When("User dont enters any details into fields")
	public void user_dont_enters_any_details_into_fields() {
	    
		//intentionally kept blank
	}

	@Then("User account should get a proper warning messages for every mandatory field")
	public void user_account_should_get_a_proper_warning_messages_for_every_mandatory_field() {
		
		Assert.assertTrue(registerPage.privacyPolicyMandatoryMessageStatus());
		Assert.assertTrue(registerPage.firstNameMandatoryMessageStatus());
		Assert.assertTrue(registerPage.lastNameMandatoryMessageStatus());
		Assert.assertTrue(registerPage.emailMandatoryMessageStatus());
		Assert.assertTrue(registerPage.telephoneMandatoryMessageStatus());
		Assert.assertTrue(registerPage.passwordMandatoryMessageStatus());
	}
}
