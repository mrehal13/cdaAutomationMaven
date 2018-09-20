package com.att.cd.UMApages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UMA_ChanLine_OMS_pObj{	

	//text below Heading
	@FindBy(xpath = "//html/body/div[1]/table/tbody/tr/td/table/tbody/tr[3]/td/form/div[1]")
	public WebElement Text_BelowHeading;

	//ZIP text box
	@FindBy(name = "ZIP")
	public WebElement ZIPtextbox;

	//text below fields
	@FindBy(xpath = "html/body/div[1]/table/tbody/tr/td/table/tbody/tr[3]/td/form/div[3]")
	public WebElement Text_BelowFields;

	//text 1 in footer
	@FindBy(xpath = "html/body/div[1]/table/tbody/tr/td/table/tbody/tr[3]/td/div")
	public WebElement Text1_Footer;	

	//text 2 in footer
	@FindBy(xpath = "html/body/div[1]/table/tbody/tr/td/table/tbody/tr[3]/td/div")
	public WebElement Text2_Footer;

	//channel name text box
	@FindBy(xpath = "html/body/div[1]/table/tbody/tr/td/table/tbody/tr[3]/td/form/div[4]/table/tbody/tr/td/input")
	public WebElement ChannelName_TextBox;

	//Go button
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td/table/tbody/tr[3]/td/form/div[4]/table/tbody/tr/td/a[1]/img")
	public WebElement Go_button;

	//1st value in result grid
	@FindBy(xpath = ".//*[@id='channelGuidetBody']/tr[1]/td[1]")
	public WebElement resultgrid_1st;

	WebDriver driver;
	public UMA_ChanLine_OMS_pObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

