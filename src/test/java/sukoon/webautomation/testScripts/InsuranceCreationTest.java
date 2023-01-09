package sukoon.webautomation.testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sukoon.webautomation.base.DriverSetup;
import sukoon.webautomation.functions.InsuranceCreationFunctions;

public class InsuranceCreationTest extends DriverSetup {

	InsuranceCreationFunctions insuranceCreationFunctions = new InsuranceCreationFunctions();


	@BeforeMethod(alwaysRun = true)
	public void loadWebPage() throws FileNotFoundException, IOException, InterruptedException {
		insuranceCreationFunctions.launchWebPage ();
	}

	@Test
	public void verifyInsuranceCreation() throws FileNotFoundException, IOException, InterruptedException {
		insuranceCreationFunctions.yourInformation();
		insuranceCreationFunctions.tripDetails();
		insuranceCreationFunctions.selectYourCoverage();
	}

}

