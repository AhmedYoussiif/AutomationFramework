package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import runner.Runner;

public class Hooks extends Runner{

	@io.cucumber.java.Before
	public static void FireFoxNavigateURL() throws InterruptedException {
	
//............
/*		WebDriverManager.firefoxdriver().setup();
		Driver= new FirefoxDriver();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
//		capabilities.setCapability("browser.privatebrowsing.autostart", true);
		firefoxOptions.setCapability("browser.privatebrowsing.autostart", true);
*/

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		options.setCapability(ChromeOptions.CAPABILITY, options);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		Driver = new ChromeDriver(options);

        Driver.manage().window().maximize();     
        
	}

	@io.cucumber.java.After
	public static void After() throws InterruptedException {
		System.out.println("End of test");
		softAssertion.assertAll();
   

	}	

	
}
