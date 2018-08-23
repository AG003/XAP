package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberLoginTest 
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Given("^open chrome and start application$")
	public void open_chrome_and_start_application() throws Throwable 
	{
	    System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://intranet.xavient.com/XAP/");
	}

	@When("^enter valid \"([^\"]*)\"$")
	public void enter_valid_username(String username) throws Throwable 
	{
	    driver.findElement(By.id("txtLoginName")).sendKeys(username);
	}

	@When("^enter valid password$")
	public void enter_valid_password() throws Throwable 
	{
		driver.findElement(By.id("txtPassword")).sendKeys("123465");	    
	}

	@Then("^user should login successfully$")
	public void user_should_login_successfully() throws Throwable 
	{
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Then("^skip your contribution$")
	public void skip_your_contribution() throws Throwable 
	{
		WebElement skip = driver.findElement(By.id("skip"));
		wait = new WebDriverWait(driver, 30);
		Thread.sleep(3000);
	    wait.until(ExpectedConditions.elementToBeClickable(skip));
	    skip.click();
	}

	@Then("^logout successfully$")
	public void logout_successfully() throws Throwable 
	{
		WebElement username = driver.findElement(By.id("username"));
		wait = new WebDriverWait(driver, 30);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.click();
		
		WebElement logout = driver.findElement(By.xpath("//a[contains(@href,'XAP/logout')]"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		
		logout.click();
	}

}
