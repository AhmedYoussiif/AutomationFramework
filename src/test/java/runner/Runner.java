package runner;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/java/Features"
		,tags = "@TaskSuit"
		, glue = "stepDefinations"
		,plugin = {"json:target/ExtendReport/cucumber.json","html:target/ExtendReport/cucumber-pretty"}
		)
public class Runner extends AbstractTestNGCucumberTests  {
	public static  WebDriver Driver = null;
	public static SoftAssert softAssertion= new SoftAssert();


	


}
