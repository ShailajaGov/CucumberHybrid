package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import java.time.Duration;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;


public class Login {
	
	WebDriver driver;
	LoginPage loginPage;
	
	@Given( "User has navigated to login page")
	public void User_has_navigated_to_login_page()
	{
		driver=DriverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickMyAccountDropMenu();
		loginPage = homePage.clickLoginOption();
		
		//loginPage = new LoginPage(driver);
		
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.linkText("Login")).click();
	}
	
	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String email)
	{
		loginPage.enterEmailAddress(email);
		//driver.findElement(By.id("input-email")).sendKeys(email);
	}
	
	@When("^User enters valid password (.+) into password field$")
	public void User_enters_valid_password_into_password_field(String password)
	{
		loginPage.enterPassword(password);
		//driver.findElement(By.id("input-password")).sendKeys(password);
	}
	
	
	@When("User clicks on login button")
	public void User_clicks_on_login_button()
	{
		loginPage.clickLoginButton();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	@Then("User should login successfully")
	public void User_should_login_successfully()
	{
		Assert.assertTrue(loginPage.editAccountInfoLinkIsDisplayed());
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	
	@When("User enters invalid email address {string} into email field")
	public void User_enters_invalid_email_address_into_email_field(String email)
	{
		loginPage.enterEmailAddress(email);
		//driver.findElement(By.id("input-email")).sendKeys(email);
	}
	
	@When("User enters invalid password {string} into password field")
	public void User_enters_invalid_password_into_password_field(String password)
	{
		loginPage.enterPassword(password);
		//driver.findElement(By.id("input-password")).sendKeys(password);
	}
	
	@Then("User should not be able to login successfully")
	public void User_should_not_be_able_to_login_successfully()
	{
		
	}
	
	@Then("User get proper warning message")
	public void User_get_proper_warning_message()
	{
		String actualMsg = loginPage.retrieveInvalidCredentialsWarningMsg();
		//driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed();
		Assert.assertEquals(actualMsg, "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@When("User dont enter any credentials")
	public void User_dont_enter_any_credentials()
	{
		
	}
	
	@When("User enters below invalid email address and valid password")
	public void User_enters_below_invalid_email_address_and_valid_password(DataTable dataTable)
	{
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		
		
		loginPage.enterEmailAddress(map.get("email"));
		loginPage.enterPassword(map.get("password"));
		
		//driver.findElement(By.id("input-email")).sendKeys(map.get("email"));
		//driver.findElement(By.id("input-password")).sendKeys(map.get("password"));
	}
	
	
	
}
