package genericClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Utility 
{
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static WebDriver driver;
	public static String browserName;
	
	public static void getBrowser(String reportName)
	{
		reporter = new ExtentHtmlReporter("./report/"+reportName+".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("DetailReport");
		
		browserName = PropertiesLib.getValue("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			logger.info("Chrome browser launched");
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
			driver = new FirefoxDriver();
			logger.info("Firefox browser launched");
		}
		
		WaitStatementLib.iWaitForSecs(driver, 15);
		driver.navigate().to(PropertiesLib.getValue("url"));
		logger.info("Navigate to the application");
	}

}
