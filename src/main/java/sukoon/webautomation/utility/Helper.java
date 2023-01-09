package sukoon.webautomation.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import sukoon.webautomation.base.DriverSetup;

public class Helper extends DriverSetup{

	public boolean isElementVisible(WebElement elementName, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait( driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(elementName));
			return true;
		}catch(Exception e){
			//System.out.println("The element is NOT Available");
			return false;
		}
	}
	public boolean isElementClickable(WebElement ele, int timeout) {
		try{
			WebDriverWait wait = new WebDriverWait( driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			return true;
		}catch(Exception e){
			//System.out.println("The element is NOT Clickable");
			return false;
		}
	}
	public void elementClick(WebElement ele) throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	public void fluentWait() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
	}
	public String getData(String dataName) throws FileNotFoundException, IOException {
		String projectPath = System.getProperty("user.dir");
		//System.out.println("ProjectPath"+projectPath);
		prop = new Properties(); 
		prop.load(new FileInputStream(projectPath+"\\src\\main\\java\\sukoon\\webautomation\\resources\\config.properties"));
		String getName = prop.getProperty(dataName);
		//System.out.println(getName);
		return getName;
	}
	public void selectDropdown(WebElement ele, String text) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			Select dropDown = new Select(ele);
			dropDown.selectByValue(text);
		}catch (Exception e) {
			// TODO: handle exception
			//	System.out.println("Not able to select element");
		}
	}
	public void selectOption(WebElement ele, String value) {
		try {
			Select sel = new Select(ele);
			sel.selectByValue(value);
		}catch(Exception e) {
			//System.out.println("Not able to Select");
		}
	}
	public boolean isPageloadComplete()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("loaded")
				|| ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}

	public void enterValue(String value,String id) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById('"+id+"').value='"+value+"'");	
	}
	public void enterInput(String value, WebElement el) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].value='"+value+"'", el);
	}
	public void scrollUp() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void scrollToElement(WebElement ele) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
	}
}