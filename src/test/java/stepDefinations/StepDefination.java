package stepDefinations;

import static org.testng.Assert.assertTrue;

import Utilities.ExcelUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.*;
import runner.Runner;
import static org.testng.Assert.assertEquals;

public class StepDefination extends Runner {
	ExcelUtil excel = new ExcelUtil ();
	// WebDriver driver = super.Driver;
	Base base = new Base(Driver);
	TwoPlugs Twoplugs = new TwoPlugs(Driver);
	TheInternetHero TheInternetHero = new TheInternetHero(Driver);
	ToolTip ToolTip = new ToolTip(Driver);

	String username = "admin";
	String password = "admin";

	@Given  ("Open Two Plug Portal")
	public void OpenTwoPlugPortal() throws Throwable {
		Driver.get("http://www.twoplugs.com/");

	}

	@Given  ("Open The internet hero portal")
	public void OpenHeroPortalCredentials() throws Throwable {
		Driver.get("https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth");

	}
	@Given  ("Open ToolTip portal")
	public void OpenToolTipPortal() throws Throwable {
		Driver.get("https://jqueryui.com/tooltip/");

	}
	@When("Open Live Posting")
	public void OpenLivePosting() throws Throwable {
		Twoplugs.OpenLivePosting();
	}
	@And("Complete Live Maps Data")
	public void CompleteLiveMaps() throws Throwable {
		Twoplugs.CompleteLiveMaps();
	}
	@And("Select And Sort Domains")
	public void SelectSortDomains() throws Throwable {
		Twoplugs.SelectSortDomains();
	}

	@And("Assert Login Success Message")
	public void AssertLoginMsg() throws Throwable {
		TheInternetHero.AssertLoginMsg();
	}

	@And("Assert Ask for Age Message")
	public void AssertAskAgeMessage() throws Throwable {
		ToolTip.AssertAskAgeMessage();
	}
}