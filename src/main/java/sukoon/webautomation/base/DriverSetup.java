package sukoon.webautomation.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import sukoon.webautomation.utility.Helper;

public class DriverSetup {
	public static WebDriver driver;
	public Properties prop;
	
	@Parameters({"browser"})
	@BeforeTest
	public WebDriver driverIntialize(String browser) throws FileNotFoundException, IOException {
		System.out.println("START");
		try {
			if(browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println("Browser: Chrome");

			}else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println("Browser: Edge");
			}			       

		}catch(Exception e) {
			e.printStackTrace();
		}
			System.out.println("WebTTT"+driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@AfterSuite
	public void testComplete() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Test Complete");
		driver.quit();
	}
}
