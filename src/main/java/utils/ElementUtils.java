package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {

	WebDriver driver;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnElement(WebElement element,long durationInSeconds)
	{
		
		WebElement webElement = waitForElementToBeClickable(element,durationInSeconds);
		
		webElement.click();
	}
	
	public void enterTextIntoElement(WebElement element,String textTobeEntered,long durationInSeconds)
	{
		WebElement webElement = waitForElementToBeClickable(element,durationInSeconds);
		
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textTobeEntered);
	
	}
	
	public void selectOptionInDropdown(String dropdownOption,WebElement element,long durationInSeconds)
	{
		WebElement webElement = waitForElementToBeClickable( element, durationInSeconds);
		Select dropdown=new Select(webElement);
		dropdown.selectByVisibleText(dropdownOption);
	}
	
	public void acceptAlertwaitForAlert(long durationInSeconds)
	{
		Alert alert=waitForAlert(durationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds)
	{
		Alert alert=waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds)
	{
		WebElement webElement = waitForVisibilityofElement(element, durationInSeconds);
		 
		Actions actions= new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	
	public void javaScriptClick(WebElement element,long durationInSeconds)
	{
		WebElement webElement = waitForVisibilityofElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		
		jse.executeScript("arguments[0].click();",webElement);
	}
	
	public void javaScriptToTypeText(WebElement element,long durationInSeconds,String textToBeTyped)
	{
		WebElement webElement = waitForVisibilityofElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value = '"+textToBeTyped+"'",webElement);
	}
	
	public WebElement waitForVisibilityofElement(WebElement element,long durationInSeconds)
	{
		WebElement webElement = null;
		try
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return webElement;
	}
	
	public Alert waitForAlert(long durationInSeconds)
	{
		Alert alert = null;
		try
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return alert;
	}
	
	public WebElement waitForElementToBeClickable(WebElement element,long durationInSeconds)
	{
		WebElement webElement = null;
		try
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return webElement;
	}
}
