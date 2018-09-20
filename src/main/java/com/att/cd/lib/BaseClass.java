package com.att.cd.lib;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.google.common.base.Verify;

public class BaseClass {
	private WebDriver driver = null;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	public void openULR(String URL_to_Open) {
		driver.get(URL_to_Open);
	}

	public void verifyTextEqual(WebElement actualTextXpath, String expectedText) {
		Assert.assertEquals(actualTextXpath.getText(), expectedText);
	}

	public void verifyTextContains(WebElement xpathID, String expected) {
		String fieldActual = xpathID.getText();
		Assert.assertTrue(fieldActual.contains(expected));
	}

	public void ListSelect(WebElement xpathID, String value) {
		Select dropdown = new Select(xpathID);
		dropdown.selectByValue(value);
	}

	public void enterText(WebElement xpathID, String textToEnter) {
		xpathID.sendKeys(textToEnter);
	}

	public void verifyAttributeValue(WebElement xpathID, String expectedValue) {
		String attValuetext = xpathID.getAttribute("value");
		Assert.assertEquals(attValuetext, expectedValue);
	}

	public void click(WebElement xpathID) {
		xpathID.click();
	}

	public void verifyHREFLink(WebElement xpathID, String expectedLink) {
		String hrefValue = xpathID.getAttribute("href");
		Assert.assertEquals(hrefValue, expectedLink);
	}

	public void SwitchToFrame() {
		if (driver.findElement(By.tagName("iframe")).getTagName() != null) {
			List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			System.out.println("total iframes foung: " + iframes.size());
			for (int i = 0; i < iframes.size(); i++) {
				if (iframes.get(i).isDisplayed()) {
					String FrameName = iframes.get(i).getAttribute("name");
					if (iframes.get(i).getAttribute("name").equals("")) {
						FrameName = iframes.get(i).getAttribute("id");
					}
					driver.switchTo().frame(FrameName);
					break;
				}
			}
		} else {
			System.out.println("no size/iframe found");
		}
	}

	public void SwitchToDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	public void wait5Sec() throws Throwable {
		Thread.sleep(5000);
	}
}
