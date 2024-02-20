package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
	
WebDriver driver;
	
@Given("User opens application")
public void user_opens_application() {
    driver= DriverFactory.getDriver();
	
}

@When("User enters product {string} in search field")
public void user_enters_product_in_search_field(String searchText) {
    driver.findElement(By.xpath("//input[@name='search']")).sendKeys(searchText);
}

@When("User clicks on search button")
public void user_clicks_on_search_button() {
   
	driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
}

@Then("valid products should be displayed in search results")
public void valid_products_should_be_displayed_in_search_results() {
	
    
}

@Then("Proper text informing the user about no matching products should be displayed")
public void proper_text_informing_the_user_about_no_matching_products_should_be_displayed() {
	
	Assert.assertEquals("There is no product that matches the search criteria.xyz",driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText());
    
}


}
