package com.FlipKart.projandcoust;

import org.testng.annotations.Test;

import com.FlipKart.generic.BaseTest;
import com.FlipKart.generic.FileLib;
import com.FlipKart.generic.WebDriverCommonLib;
import com.FlipKart.pages.activeprojectsandcustomerspage;
import com.FlipKart.pages.addnewprojectpage;
import com.FlipKart.pages.loginpage;
import com.FlipKart.pages.opentaskpage;

public class createprojandcust extends BaseTest
{
	@Test
	public void createprojecttest() throws Throwable
	{
		
		loginpage lp=new loginpage();
		FileLib flib=new FileLib();
		lp.login(flib.readPropData(PROP_PATH, "username"), flib.readPropData(PROP_PATH, "password"));
		
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		wlib.waitForPageTitle(flib.readPropData(PROP_PATH, "opentaskpage"));
		wlib.verifyPage(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "opentaskpage"), "open task page");
		
		opentaskpage otp=new opentaskpage();
		otp.clickprojandcust();
		
		wlib.waitForPageTitle(flib.readPropData(PROP_PATH, "activeprojectsandcustomerspage"));
		wlib.verifyPage(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "activeprojectsandcustomerspage"), "active projects and customers page");
	
		activeprojectsandcustomerspage apcp=new activeprojectsandcustomerspage();
		apcp.addnewprojectbtn();
		
		wlib.waitForPageTitle(flib.readPropData(PROP_PATH, "addnewprojectpage"));
		wlib.verifyPage(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "addnewprojectpage"), "add new project page");
		
		addnewprojectpage anpp=new addnewprojectpage();
		anpp.customerdrop(flib.getData(EXCEL_PATH, "Sheet1", 5, 1));
		anpp.projectnamebtn(flib.getData(EXCEL_PATH, "Sheet1", 6, 1));
		anpp.clickprojectbtn();
		
		if(apcp.getsuccess().isDisplayed())
		{
			System.out.println("project is created ,successmsg is displayed");
		}
		else
		{
			System.out.println("project is not created ,successmsg is not displayed");
		}
		
		apcp.getsuccessmsg();
	}
}
