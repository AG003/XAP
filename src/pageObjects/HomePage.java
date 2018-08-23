package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericClass.WaitStatementLib;

public class HomePage 
{
	private static By skip = By.id("skip");
	private static By toDoList = By.xpath("//span[contains(text(),'To Do List')]");
	private static By addButton = By.id("btnAddTodolist");
	private static By textBox = By.id("txtNewToDo");
	private static By dueDate = By.id("txtToDoTaskDate");
	private static By saveChangesButton = By.id("btnADDNewToDo");
	
	
	public static void skipYourContribution(WebDriver driver)
	{
		WebElement skipElement = driver.findElement(skip);
		WaitStatementLib.iSleep(3);
		WaitStatementLib.eWaitForClickable(driver, 30, skipElement);
		skipElement.click();
	}
	
	public static void addToDoItem(WebDriver driver, String text, String date)
	{
		WaitStatementLib.iSleep(3);
		WebElement toDoListVisible = driver.findElement(toDoList);
		WaitStatementLib.eWaitForVisibility(driver, 30, toDoListVisible);
		
		WebElement addButtonClickable = driver.findElement(addButton);
		WaitStatementLib.eWaitForClickable(driver, 30, toDoListVisible);
		addButtonClickable.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		
		WebElement textBoxButton = driver.findElement(textBox);
		WaitStatementLib.eWaitForVisibility(driver, 30, textBoxButton);
		textBoxButton.sendKeys(text);
		
		driver.findElement(dueDate).sendKeys(date);
		
		driver.findElement(saveChangesButton).click();
	}
	
}
