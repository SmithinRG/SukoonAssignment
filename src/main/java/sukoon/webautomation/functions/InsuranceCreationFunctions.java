package sukoon.webautomation.functions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import sukoon.webautomation.base.DriverSetup;
import sukoon.webautomation.pageObjects.InsurancePage;
import sukoon.webautomation.utility.Helper;

public class InsuranceCreationFunctions extends DriverSetup {

	Helper utilities = new Helper();
	InsurancePage insurancePage;

	public void launchWebPage() throws FileNotFoundException, IOException, InterruptedException {
		driver.get(utilities.getData("url"));
		driver.manage().window().maximize();
		utilities.isPageloadComplete();
	}

	public void yourInformation() throws FileNotFoundException, IOException, InterruptedException {
		insurancePage = new InsurancePage(driver);
		utilities.isElementVisible(insurancePage.pageFieldHeader(), 10);
		utilities.selectDropdown(insurancePage.titleDropDown(), utilities.getData("title"));
		utilities.enterInput(utilities.getData("firstName"), insurancePage.firstNameInput());
		utilities.enterInput(utilities.getData("lastName"), insurancePage.lastNameInput());
		utilities.enterInput(utilities.getData("email"), insurancePage.emailInput());
		utilities.enterInput(utilities.getData("mobileNumber"), insurancePage.mobInput());
		insurancePage.nextClick();
		Assert.assertEquals(insurancePage.destCouTitle().isDisplayed(), insurancePage.destCounIsDisplayed());
	}
	public void tripDetails() throws FileNotFoundException, IOException, InterruptedException {
		insurancePage = new InsurancePage(driver);
		utilities.isElementVisible(insurancePage.destCouTitle(), 10);
		insurancePage.countrySearchValue(utilities.getData("country"));	
		countryList();
		utilities.isElementVisible(insurancePage.radioSelection(), 10);
		insurancePage.radioBtnClick();
		utilities.elementClick(insurancePage.singleTripBtn());
		utilities.elementClick(insurancePage.coverageOption());
		travellersCount();
	}

	public void countryList() throws FileNotFoundException, IOException {
		insurancePage = new InsurancePage(driver);
		List<WebElement> countryList = insurancePage.countrySearchList();
		String searchName = utilities.getData("country");
		for(WebElement searchResult:countryList) {
			System.out.println(searchResult.getText());
			if(searchName.equalsIgnoreCase(searchResult.getText())) {
				searchResult.click();
				break;		
			}				
		}
	}

	public void travellersCount() throws FileNotFoundException, IOException, InterruptedException {
		utilities.scrollUp();
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.id("Travel-TripDetails-Adults-button"));
		element.sendKeys(utilities.getData("adult"));
		Thread.sleep(1000);
		WebElement endDate = driver.findElement(By.id("Travel-TripDetails-EndDate"));
		endDate.sendKeys(utilities.getData("returnDate"));
		utilities.isElementVisible(insurancePage.nextButtonEle(), 10);
		insurancePage.nextButtonClick();
		Assert.assertEquals(insurancePage.selectCoverage().isDisplayed(), insurancePage.selectCoverageIsDisplayed());
	}
	public void selectYourCoverage() throws InterruptedException, FileNotFoundException, IOException {
		utilities.isElementVisible(insurancePage.selectCoverage(), 10);
		insurancePage.proceedButtonClick();
		Thread.sleep(5000);
		utilities.scrollToElement(insurancePage.passengerTitleEle());
		utilities.isElementVisible(insurancePage.passengerTitleEle(), 10);
		Thread.sleep(2000);
		passengerInfo();
		passportUpload();
		payment();
		paymentSuccess();
	}
	public void passengerInfo() throws InterruptedException, FileNotFoundException, IOException {
		utilities.isElementVisible(insurancePage.passengerFirstName(), 10);
		utilities.enterInput(utilities.getData("firstName"), insurancePage.passengerFirstName());
		utilities.enterInput(utilities.getData("lastName"), insurancePage.passengerLastName());
		utilities.enterInput(utilities.getData("dob"), insurancePage.passengerDob());
		utilities.enterInput(utilities.getData("passport"), insurancePage.passengerPassport());
		utilities.elementClick(insurancePage.passengerNationality());
		insurancePage.passengerNationality().sendKeys(utilities.getData("country"));
		Thread.sleep(2000);	
		countryList();
		Thread.sleep(1000);	
	}
	public void passportUpload() throws InterruptedException {
		utilities.scrollUp();
		String projectPath = System.getProperty("user.dir");
		insurancePage.fileUpload().sendKeys(projectPath+"\\src\\main\\java\\sukoon\\webautomation\\resources\\Brochure_Outbound.pdf");
		utilities.isElementClickable(insurancePage.checkBox(), 10);
		utilities.elementClick(insurancePage.checkBox());
		Thread.sleep(2000);
		utilities.isElementClickable(insurancePage.confirmPay(), 10);
		utilities.elementClick(insurancePage.confirmPay());
	}
	public void payment() throws InterruptedException, FileNotFoundException, IOException {
		utilities.isElementVisible(insurancePage.paymentTitle(), 10);
		Thread.sleep(1000);
		driver.switchTo().frame("paymentIFrame");
		utilities.isElementVisible(insurancePage.creditCardNum(), 10);
		Thread.sleep(1000);
		insurancePage.creditCardNum().sendKeys(utilities.getData("creditcardNumber"));
		Thread.sleep(1000);
		utilities.selectOption(insurancePage.creditCardMon(), utilities.getData("month"));
		Thread.sleep(1000);
		utilities.selectOption(insurancePage.creditCardYear(), utilities.getData("year"));
		insurancePage.creditCardCvv().sendKeys(utilities.getData("cvv"));
		insurancePage.makePayment().click();
		driver.switchTo().defaultContent();
	}
	public void paymentSuccess() {
		utilities.isElementVisible(insurancePage.submitBtn(), 10);
		utilities.isElementClickable(insurancePage.submitBtn(), 10);
		insurancePage.submitBtn().click();
		System.out.println(insurancePage.paymentSuccess().getText());
		String message = insurancePage.paymentSuccess().getText();
		String expected = "Thank you.";
		Assert.assertTrue(message.contains(expected));
	}

}
