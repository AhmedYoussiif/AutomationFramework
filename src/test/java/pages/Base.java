package pages;

import java.io.IOException;
import java.sql.Driver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	public Select select = null;
	public Actions action = null;

	public Base(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void MouseHover(WebElement element) {
		// TODO Auto-generated method stub
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public int GetNumberOfWebElement(By elementLocation) {
		List<WebElement> NumWebelemnt = driver.findElements(elementLocation);
		return NumWebelemnt.size();
	}

	protected void clickButton(WebElement button) {
		button.click();
	}

	protected void setTextElementText(WebElement txtElement, String value) {
		txtElement.sendKeys(value);
	}

	public void scrollToButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public String GetText(WebElement element) {
		return element.getText();}

	public String GetAttribute(WebElement element, String value) {
		return element.getAttribute(value);}


	public String generateID() {
		Random rnd = new Random();
		String x = "784";

		char[] digits = new char[12];
		digits[0] = (char) (rnd.nextInt(9) + '1');

		for (int i = 1; i < digits.length; i++) {
			digits[i] = (char) (rnd.nextInt(10) + '0');
		}

		String str = new String(digits);
		str = x + str;

		return str;
	}

	public String getString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public void refreshPage() throws InterruptedException {
		driver.navigate().refresh();
	}

	public boolean isElementPresent(By by) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	protected void WaitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public String reverseIt(String source) {
		System.out.println("base " + source);
		byte[] strAsByteArray = source.getBytes();
		byte[] result = new byte[strAsByteArray.length];
		for (int i = 0; i < strAsByteArray.length; i++)
			result[i] = strAsByteArray[strAsByteArray.length - i - 1];
		return new String(result);
	}

	public String DateFormate(String source) throws ParseException {
		final String OLD_FORMAT = "yyyy/MM/dd";
		final String NEW_FORMAT = "dd/MM/yyyy";
		// August 12, 2010
		String oldDateString = source;
		String newDateString;
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d = sdf.parse(oldDateString);
		sdf.applyPattern(NEW_FORMAT);
		return newDateString = sdf.format(d);
	}



	public String dischargeDatetValue() {
		// return
		// jse.executeScript("document.querySelector(\"[formControlName='dischargeDate']
		// input\").value").toString();

		
		  JavascriptExecutor js = (JavascriptExecutor) driver; 
		  String text = js.
		  executeScript("return document.getElementById('datepicker-2-input').textContent" ).toString();
		  System.out.println("Text written on the login button is- " +
		  text); 
		  return text;
		 

		// return
		// jse.executeScript("document.querySelector(\"[formControlName='dischargeDate']
		// input\").innerText").toString();

	}

	public void MousClick(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public void MoveToTab(int tab) {

		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(availableWindows.get(tab));
	}
	public void SwitchtoFrame(WebElement element) {

		driver.switchTo().frame(element);

	}
	public void selectsortdrpDwn(WebElement element) {

		Select se = new Select(element);
		ArrayList originalList = new ArrayList();

		for (WebElement e : se.getOptions()) {
			originalList.add(e.getText());;
		}

		Collections.sort(originalList);
		System.out.println("Sorted Domains " + "in Ascending order : " + originalList);

		Collections.sort(originalList, Collections.reverseOrder());
		System.out.println("Sorted Domains " + "in Descending order : " + originalList);

	}
}
