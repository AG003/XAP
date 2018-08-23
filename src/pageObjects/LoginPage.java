package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage 
{
	private static By username = By.id("txtLoginName");
	private static By password = By.id("txtPassword");
	private static By loginButton = By.id("btnLogin");
	
	public static void validLogin(WebDriver driver, String uname, String pass)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
	}
	
	public static String verifyLogin(WebDriver driver)
	{
		if(driver.getCurrentUrl().equalsIgnoreCase("https://intranet.xavient.com/XAP/main/"))
			return "pass";
		else
			return "fail";
	}

}
