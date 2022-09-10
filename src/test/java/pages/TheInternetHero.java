package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TheInternetHero extends Base {
	WebDriver driver;
	@FindBy(xpath ="//div[@class=\"example\"]/p")
	WebElement  SuccessMsg;

	String LoingMsgText = "Congratulations! You must have the proper credentials.";

	public TheInternetHero(WebDriver driver) {
		super(driver);	
	}

	public void AssertLoginMsg() throws InterruptedException {


		Assert.assertEquals(GetText(SuccessMsg), LoingMsgText);
	  }

}
