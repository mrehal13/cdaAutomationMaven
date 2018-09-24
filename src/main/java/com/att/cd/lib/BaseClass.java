package com.att.cd.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop ;
	FileInputStream fis;
	
	public BaseClass() {	
		
		System.out.println(System.getProperty("user.dir"));
		try {
			prop =new Properties();
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fis);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("chrome")){
			// do this
		}
	}
	
	
	
	public void handleJSalert(String alertAction) {
		Alert alert = driver.switchTo().alert();
		if(alertAction.equals("OK")){
			alert.accept();
		}else if(alertAction.equals("CANCEL")){
			alert.dismiss();
		}
	}
	
	public void handleWindows() {
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String ParentWindow = it.next();
		
		System.out.println("Parent window id: " + it.next());
		System.out.println("Child window id: " + it.next());
	}
	
	public void openULR(String URL_to_Open) {
		driver.get(URL_to_Open);
		driver.manage().window().maximize();
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
			//System.out.println("total iframes found: " + iframes.size());
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
