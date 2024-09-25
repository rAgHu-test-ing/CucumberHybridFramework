package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {
	
	WebDriver driver;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	
	@Before
	@Given("User opens the application")
	public void user_opens_the_application() {
	    
		driver = DriverFactory.getDriver();
	}

	@When("User enters the valid product {string} into Search box field")
	public void user_enters_the_valid_product_into_search_box_field(String validProduct) {
		
		homePage = new HomePage(driver);
		homePage.searchOption(validProduct);
	}

	@And("User clicks on Search button")
	public void user_clicks_on_search_button() {
		
		searchResultsPage = homePage.clickOnSearch();	    
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
		Assert.assertEquals("HP LP3065",searchResultsPage.validProductResult());
		Assert.fail();
	    
	}

	@When("User enters the invalid product {string} into Search box field")
	public void user_enters_the_invalid_product_into_search_box_field(String invalidProduct) {
		
		homePage = new HomePage(driver);
		homePage.searchOption(invalidProduct);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
		Assert.assertEquals("There is no product that matches the search criteria.", searchResultsPage.noProductMatchStatus());	    
	}

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		
		homePage = new HomePage(driver);
		//intentinally kept blank
	    
	}

}
