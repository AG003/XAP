package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import genericClass.WaitStatementLib;

public class BasePage 
{
	private static By username = By.id("username");
	private static By logout = By.xpath("//a[contains(@href,'XAP/logout')]");
	
	public static void logoutApplication(WebDriver driver)
	{
		WebElement mouseHoverElement = driver.findElement(username);
		WaitStatementLib.eWaitForClickable(driver, 30, mouseHoverElement);
		Actions action = new Actions(driver);
		action.moveToElement(mouseHoverElement).perform();
		
		WebElement clickOnLogout = driver.findElement(logout);
		WaitStatementLib.eWaitForClickable(driver, 30, clickOnLogout);
		clickOnLogout.click();
	}
	
	public static String verifyLogout(WebDriver driver)
	{
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://intranet.xavient.com/XAP/Login.aspx?reason=LogOut";
		if(expectedURL.equals(actualURL))
		{
			return "pass";
		}
		else
		{
			return "fail";
		}
	}

}
