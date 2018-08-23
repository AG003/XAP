package testScripts;

import genericClass.ExcelLib;
import genericClass.ScreenshotLib;
import genericClass.Utility;
import pageObjects.BasePage;
import pageObjects.LoginPage;

public class LoginTest extends Utility{

	public static void main(String[] args) 
	{
		try {
			String result;
			String reportName = new Object(){}.getClass().getName();
			System.out.println(reportName);
			Utility.getBrowser(reportName);
			String uname = ExcelLib.readData("Test Case", 3, 3);
			String pass = ExcelLib.readData("Test Case", 4, 3);
			
			
			LoginPage.validLogin(driver, uname, pass);
			
			result = LoginPage.verifyLogin(driver);
			if(result.equalsIgnoreCase("pass"))
			{
				logger.pass("Login test passed successfully");
				
				BasePage.logoutApplication(driver);
				logger.info("Logged out successfully");
			}
			else
			{
				ScreenshotLib.takesScreenshot(driver, "LoginTest");
				logger.addScreenCaptureFromPath("./screenshots/LoginTest.png");
				logger.fail("Login test failed");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
//		if (browserName.equalsIgnoreCase("chrome")) 
//		{
//			HomePage.skipYourContribution(driver);
//		}
		
//		BasePage.logoutApplication(driver);
//		logger.info("Logged out successfully");
		
//		result = BasePage.verifyLogout(driver);
//		if(result.equalsIgnoreCase("pass"))
//		{
//			logger.pass("Login test passed successfully");
//		}
//		else
//		{
//			ScreenshotLib.takesScreenshot(driver, "LoginTest");
//			logger.addScreenCaptureFromPath("./screenshots/LoginTest.png");
//			logger.fail("Login test failed");
//		}
//		driver.quit();
//		extent.flush();
//		System.out.println("Test case completed");
		
		finally 
		{
			driver.quit();
			extent.flush();
			System.out.println("Test case completed");						
		} 
	}

}
