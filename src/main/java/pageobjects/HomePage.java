package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

WebDriver driver;
	
	@FindBy(css="a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickMyAccountDropMenu()
	{
		myAccountDropMenu.click();
	}
	
	public LoginPage clickLoginOption()
	{
		loginOption.click();
		
		return new LoginPage(driver);
	}
	
	
}
