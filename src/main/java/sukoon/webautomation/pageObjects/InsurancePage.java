package sukoon.webautomation.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage {

	public WebDriver driver;

	public InsurancePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".sk-uigroup-header")
	private WebElement pageTitle;

	@FindBy(id = "Travel-CustomerDetails-Title-button")
	private WebElement titleBox;

	@FindBy(name = "Travel.CustomerDetails.Title")
	private WebElement titleDrop;

	@FindBy(id = "Travel-CustomerDetails-FirstName")
	private WebElement firstNameField;

	@FindBy(id = "Travel-CustomerDetails-LastName")
	private WebElement lastNameField;

	@FindBy(id = "Travel-CustomerDetails-Email")
	private WebElement emailField;

	@FindBy(id = "Travel-CustomerDetails-PhoneNumber")
	private WebElement mobNumField;

	@FindBy(css = ".sk-button-text")
	private WebElement nextBtn;

	@FindBy(xpath = "//label[normalize-space()='Destination Country']")
	private WebElement destCountry;

	@FindBy(id = "Travel-TripDetails-DestinationFlexdata--label")
	private WebElement country;

	@FindBy(id = "sk-Travel-CustomerDetails-ResidentUAE")
	private WebElement radioArea;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	private WebElement radioOption;

	@FindBy(id = "Travel-TripDetails-CoverType-1")
	private WebElement singleTrip;

	@FindBy(id = "Travel-TripDetails-CoverageOption-1")
	private WebElement coverage;

	@FindBy(id = "Travel-TripDetails-Adults-button")
	private WebElement travellers;

	@FindBy(id = "Travel-TripDetails-EndDate")
	private WebElement date;

	@FindBy(xpath = "//*[contains(@title,'Next')]")
	private WebElement nextButton;
	
	@FindBy(css = ".sk-uigroup-item-header.sk-box-shadow")
	private WebElement slctCoverage;
	
	@FindBy(xpath = "//*[contains(@title,'Proceed')]")
	private WebElement proceedButton;
	
	@FindBy(css = ".sk-uigroup-item-header")
	private WebElement passengerTitle;
	
	@FindBy(id = "Travel-TripDetails-Traveler°1-FirstName")
	private WebElement passFirst;
	
	@FindBy(id = "Travel-TripDetails-Traveler°1-LastName")
	private WebElement passLast;
	
	@FindBy(id = "Travel-TripDetails-Traveler°1-DateOfBirth")
	private WebElement passDob;
	
	@FindBy(xpath = "//input[contains(@title,'Nationality')]")
	private WebElement passNationality;
	
	@FindBy(id = "Travel-TripDetails-Traveler°1-PassportNo")
	private WebElement passPassport;
	
	@FindBy(css = "input[name='files[]']")
	private WebElement fileUp;
	
	@FindBy(id = "Travel-CustomerDetails-ConfirmationReview-1")
	private WebElement check;
	
	@FindBy(xpath = "//button[@title='Confirm & Pay']")
	private WebElement confirm;
	
	@FindBy(xpath = "//a[contains(@title,'Payment')]")
	private WebElement payment;
	
	@FindBy(xpath = "//*[@id='creditCardNumber']")
	private WebElement creditCard;
	
	@FindBy(xpath = "//*[@id='expiryMonthCreditCard']")
	private WebElement creditMonth;
	
	@FindBy(xpath = "//*[@id='expiryYearCreditCard']")
	private WebElement creditYear;
	
	@FindBy(xpath = "//*[@id='CVVNumberCreditCard']")
	private WebElement creditCvv;
	
	@FindBy(xpath = "//*[@id='SubmitBillShip']")
	private WebElement makePayBtn;
	
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submit;
	
	@FindBy(id = "sk-Travel-Confirmation-ConfirmationMessage")
	private WebElement paySuccess;
	
	@FindBy(xpath = "//a[contains(@class,'ui-menu-item-wrapper')]")
	List<WebElement> countryList;

	public WebElement pageFieldHeader() {
		return pageTitle;
	}
	public WebElement titleField() {
		return titleBox;
	}
	public WebElement titleDropDown() {
		return titleDrop;
	}
	public WebElement firstNameInput() {
		return firstNameField;
	}
	public WebElement lastNameInput() {
		return lastNameField;
	}
	public WebElement emailInput() {
		return emailField;
	}
	public WebElement mobInput() {
		return mobNumField;
	}
	public WebElement nextButton() {
		return nextBtn;
	}
	public WebElement destCouTitle() {
		return destCountry;
	}
	public WebElement countrySearch() {
		return country;	
	}
	public WebElement radioSelection() {
		return radioArea;
	}
	public WebElement radioBtn() {
		return radioOption;
	}
	public WebElement singleTripBtn() {
		return singleTrip;
	}
	public WebElement coverageOption() {
		return coverage;
	}
	public WebElement travellersNum() {
		return travellers;
	}
	public WebElement endDate() {
		return date;
	}
	public WebElement nextButtonEle() {
		return nextButton;
	}
	public WebElement selectCoverage() {
		return slctCoverage;
	}
	public WebElement proceedButtonEle() {
		return proceedButton;
	}
	public WebElement passengerTitleEle() {
		return passengerTitle;
	}
	public WebElement passengerFirstName() {
		return passFirst;
	}
	public WebElement passengerLastName() {
		return passLast;
	}
	public WebElement passengerDob() {
		return passDob;
	}
	public WebElement passengerNationality() {
		return passNationality;
	}
	public WebElement passengerPassport() {
		return passPassport;
	}
	public WebElement fileUpload() {
		return fileUp;
	}
	public WebElement checkBox() {
		return check;
	}
	public WebElement confirmPay() {
		return confirm;
	}
	public WebElement paymentTitle() {
		return payment;
	}
	public WebElement creditCardNum() {
		return creditCard;
	}
	public WebElement creditCardMon() {
		return creditMonth;
	}
	public WebElement creditCardYear() {
		return creditYear;
	}
	public WebElement creditCardCvv() {
		return creditCvv;
	}
	public WebElement makePayment() {
		return makePayBtn;
	}
	public WebElement submitBtn() {
		return submit;
	}
	public WebElement paymentSuccess() {
		return paySuccess;
	}
	public List<WebElement> countrySearchList() {
		return countryList;
	}
	public void enterfirstName(String fname) {
		firstNameInput().sendKeys(fname);
	}
	public void enterlastName(String lname) {
		lastNameInput().sendKeys(lname);
	}
	public void enterEmailId(String email) {
		emailInput().sendKeys(email);
	}
	public void enterMobileNum(String mobNum) {
		mobInput().sendKeys(mobNum);
	}
	public void nextClick() {
		nextButton().click();
	}
	public void radioBtnClick() {
		radioBtn().click();
	}
	public boolean destCounIsDisplayed() {
		return destCouTitle().isDisplayed();
	}
	public boolean selectCoverageIsDisplayed() {
		return selectCoverage().isDisplayed();
	}
	public void singleTripBtnClick() {
		singleTripBtn().click();
	}
	public void coverageOptionBtnClick() {
		coverageOption().click();
	}
	public void travelCount(String num) {
		travellersNum().sendKeys(num);
	}
	public void enterDate(String date) {
		endDate().sendKeys(date);	
	}
	public void nextButtonClick() {
		nextButtonEle().click();
	}
	public void proceedButtonClick() {
		proceedButtonEle().click();
	}
	public void countrySearchValue(String value) {
		countrySearch().sendKeys(value);
	}
}
