package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	ElementUtils elementUtils;
	
	@FindBy(id="input-email")
	private WebElement emailTextBox;
	
	@FindBy(id="input-password")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@value = 'Login']")
	private WebElement loginButton;
	
	@FindBy(linkText="Edit your account information")
	private WebElement editAccountInfo;
	
	@FindBy(xpath= "//div[contains(@class,'alert-dismissible')]")
	private WebElement invalidCredentialsWarningMsg;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	//Actions
	public void enterEmailAddress(String email)
	{
		elementUtils.enterTextIntoElement(emailTextBox, email, 10);
		//emailTextBox.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		elementUtils.enterTextIntoElement(passwordTextBox,password,10);
		//passwordTextBox.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		elementUtils.clickOnElement(loginButton, 10);
		//loginButton.click();
	
	}
	
	public boolean editAccountInfoLinkIsDisplayed()
	{
		return editAccountInfo.isDisplayed();
	}
	
	
	public String retrieveInvalidCredentialsWarningMsg()
	{
		return invalidCredentialsWarningMsg.getText();
	}
	
}
