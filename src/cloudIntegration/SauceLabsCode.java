package cloudIntegration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class SauceLabsCode 
{
	public static void main(String[] args) throws MalformedURLException 
	{
		String browser = "chrome-win-sauceLabs";
		
		String USERNAME = "YOUR_USERNAME";
		String ACCESS_KEY = "YOUR_ACCESS_KEY";
		
		String URL = "https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";
		
		DesiredCapabilities caps = null;
		
		switch(browser.toLowerCase())
		{
			case "chrome-win-sauceLabs":
				caps = DesiredCapabilities.chrome();
				caps.setCapability("platform", "Windows 10");
				caps.setCapability("version", "46.0");
				caps.setCapability("screenResolution", "1280x800");
				break;
				
			default:
				System.out.println("Please pass correct sauceLabs browser value");
				break;
		}
		
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		
		driver.get("https://intranet.xavient.com/XAP/");
	    System.out.println("title of page is: " + driver.getTitle());
	 
	    driver.quit();
	}

}
