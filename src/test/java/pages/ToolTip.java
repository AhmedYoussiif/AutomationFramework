package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ToolTip extends Base {
	WebDriver driver;
	@FindBy(id="age")
	WebElement  AgeMsgField;

	@FindBy(className="demo-frame")
	WebElement  ToolTipFrame;

	String AskAgeText = "We ask for your age only for statistical purposes.";

	public ToolTip(WebDriver driver) {
		super(driver);	
	}

	public void AssertAskAgeMessage() throws InterruptedException {

		SwitchtoFrame(ToolTipFrame);
		WaitForElement(AgeMsgField);
		String AgeMsgText = GetAttribute(AgeMsgField,"title");
		Assert.assertEquals(AgeMsgText,AskAgeText);
	}

}
