package com.att.cdaAutomation.UMAtest;

import org.testng.annotations.Test;
import com.att.cd.lib.GenExtentReports;
import com.aventstack.extentreports.Status;
import com.att.cd.UMApages.UMA_ChanLine_CRM_pObj;
import com.att.cd.lib.BaseClass;

public class UMA_ChanLine_CRM extends GenExtentReports{

	BaseClass baseClass= new BaseClass();
	UMA_ChanLine_CRM_pObj pObj= new UMA_ChanLine_CRM_pObj();	
	
	@Test(priority = 0)
	public void VerifyTextBelowHeading() throws InterruptedException{
		logger = extent.createTest("VerifyTextBelowHeading");
		baseClass.openULR("https://uma.att.com/uma/RetrieveChannelLineup?ZIP=47302&FORMAT=IFRAME&APPID=CRM");
		Thread.sleep(10000);
		logger.log(Status.PASS, "URL opened successfully");
	
		baseClass.verifyTextEqual(pObj.Text_BelowHeading, "Enter your zip code below. This enables us to give you an accurate channel line-up.");
		logger.log(Status.PASS, "Text content below heading verified successfully");
	}

	@Test(priority = 1)
	public void VerifyZIPCodeInTextBox(){
		logger = extent.createTest("VerifyZIPCodeInTextBox");
		baseClass.verifyAttributeValue(pObj.ZIPtextbox, "47302");
		logger.log(Status.PASS, "Text in ZIP field verified successfully");
	}
	
	@Test(priority = 2)
	public void VerifyTextBelowFields(){
		logger = extent.createTest("VerifyTextBelowFields");
		//verify text below fields	
		baseClass.verifyTextEqual(pObj.Text_BelowFields, "Use the dropdown to filter your view or click on the column header to sort your results.                ");
		logger.log(Status.PASS, "Text content below fields verified successfully");
	}
	
	@Test(priority = 3)
	public void VerifySearchFunctionality() throws InterruptedException{
		logger = extent.createTest("VerifySearchFunctionality");
		//enter text in channel name text box
		baseClass.enterText(pObj.ChannelName_TextBox, "AWE");	
		
		//click Go button
		baseClass.click(pObj.Go_btn_channel);
		logger.log(Status.PASS, "Text entred AWE and button clicked");
		Thread.sleep(5000);
		//verify value in result grid 
		baseClass.SwitchToFrame();
		baseClass.verifyTextContains(pObj.resultgrid_1st, "AWE");
		logger.log(Status.PASS, "content AWE verified in grid");
		
		baseClass.SwitchToDefaultFrame();
		baseClass.ListSelect(pObj.Package_List, "200ALL");
		baseClass.click(pObj.Go_btn_package);
		baseClass.SwitchToFrame();
		Thread.sleep(3000);
		baseClass.verifyTextContains(pObj.resultgrid_1st, "A&E");
		baseClass.SwitchToDefaultFrame();
	}
}

