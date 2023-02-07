package runner;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.java.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;


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
