package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;

public class TwoPlugs extends Base {
	WebDriver driver;
	@FindBy(xpath ="//*[contains(text(),'Live')]")
	WebElement  LiveBtn;

	@FindBy(id="autocomplete")
	WebElement  MapsSearchField;

	@FindBy(name="category_id")
	WebElement  DomainDrpDwn;

	@FindBy(xpath="//button[@class = 'btn btn-filter']")
	WebElement  SearchBtn;

	@FindBy(xpath="//div[@class = 'pac-item'][1]")
	WebElement  SelectionResult;

//	pac-item
//	pac-container pac-logo hdpi

	public TwoPlugs(WebDriver driver) {
		super(driver);	
	}

	public void OpenLivePosting() throws InterruptedException {
		Thread.sleep(3000);
		clickButton(LiveBtn);

	  }

	public void CompleteLiveMaps() throws InterruptedException {
		WaitForElement(MapsSearchField);
		clearText(MapsSearchField);
		setTextElementText(MapsSearchField,"Toronto, OH, USA");
		WaitForElement(SelectionResult);
		SelectionResult.click();
		String MapsText = GetAttribute(MapsSearchField,"value");
		Assert.assertEquals(MapsText,"Toronto, OH, USA");

	}

	public void SelectSortDomains() throws InterruptedException {

	selectsortdrpDwn(DomainDrpDwn);

	}
}
