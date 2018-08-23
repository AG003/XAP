package applicationMultithreading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericClass.PropertiesLib;
import genericClass.WaitStatementLib;

public class FirefoxLoginTest implements Runnable {

	public void run() 
	{
		loginMethod();
	}
	
	public void loginMethod()
	{
		System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		WaitStatementLib.iWaitForSecs(driver, 15);
		driver.navigate().to(PropertiesLib.getValue("url"));
		
		driver.findElement(By.id("txtLoginName")).sendKeys("uname");
		driver.findElement(By.id("txtPassword")).sendKeys("pass");
		driver.findElement(By.id("btnLogin")).click();
		
//		WebElement skipElement = driver.findElement(By.id("skip"));
//		WaitStatementLib.iSleep(3);
//		WaitStatementLib.eWaitForVisibility(driver, 30, skipElement);
//		skipElement.click();
		
		WebElement mouseHoverElement = driver.findElement(By.id("username"));
		WaitStatementLib.eWaitForVisibility(driver, 30, mouseHoverElement);
		Actions action = new Actions(driver);
		action.moveToElement(mouseHoverElement).perform();
		
		WebElement clickOnLogout = driver.findElement(By.xpath("//a[contains(@href,'XAP/logout')]"));
		WaitStatementLib.eWaitForVisibility(driver, 30, clickOnLogout);
		clickOnLogout.click();
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://intranet.xavient.com/XAP/Login.aspx?reason=LogOut";
		if(expectedURL.equals(actualURL))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
	}

}
