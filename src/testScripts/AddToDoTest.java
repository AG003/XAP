package testScripts;

import java.io.IOException;

import genericClass.ExcelLib;
import genericClass.ScreenshotLib;
import genericClass.Utility;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class AddToDoTest extends Utility
{
	public static void main(String[] args) throws IOException 
	{
		try {
			String result;
			String reportName = new Object(){}.getClass().getName();
			System.out.println(reportName);
			Utility.getBrowser(reportName);
			String uname = ExcelLib.readData("Test Case", 12, 3);
			String pass = ExcelLib.readData("Test Case", 13, 3);
			String text = ExcelLib.readData("Test Case", 17, 3);
			String date = "8/23/2018";
			
			LoginPage.validLogin(driver, uname, pass);
			
			result = LoginPage.verifyLogin(driver);
			if(result.equalsIgnoreCase("pass"))
			{
				logger.pass("Login successfully");
			}
			else
			{
				ScreenshotLib.takesScreenshot(driver, "LoginTest");
				logger.addScreenCaptureFromPath("./screenshots/LoginTest.png");
				logger.fail("Login failed");
			}
			
			HomePage.skipYourContribution(driver);
			
			HomePage.addToDoItem(driver, text, date);
			
			BasePage.logoutApplication(driver);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			driver.quit();
			extent.flush();
			System.out.println("Test case completed");						
		} 
	}

}
