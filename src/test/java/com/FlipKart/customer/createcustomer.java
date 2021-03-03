package com.FlipKart.customer;

import org.testng.annotations.Test;

import com.FlipKart.generic.BaseTest;
import com.FlipKart.generic.FileLib;
import com.FlipKart.generic.WebDriverCommonLib;
import com.FlipKart.pages.activeprojectsandcustomerspage;
import com.FlipKart.pages.addnewcustomerpage;
import com.FlipKart.pages.loginpage;
import com.FlipKart.pages.opentaskpage;

public class createcustomer extends BaseTest
{
@Test
public void createcustomertest() throws Throwable
{
	loginpage lp=new loginpage();
	FileLib flib=new FileLib();
	lp.login(flib.readPropData(PROP_PATH, "username"), flib.readPropData(PROP_PATH, "password"));
	
	WebDriverCommonLib wlib=new WebDriverCommonLib();
	wlib.waitForPageTitle(flib.readPropData(PROP_PATH, "opentaskpage"));
	wlib.verifyPage(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "opentaskpage"), "open task page title");
	
	opentaskpage otp=new opentaskpage();
	otp.clickprojandcust();
	
	wlib.waitForPageTitle(flib.readPropData(PROP_PATH, "activeprojectsandcustomerspage"));
	wlib.verifyPage(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "activeprojectsandcustomerspage"), "active projects and customers page");

	activeprojectsandcustomerspage apcp=new activeprojectsandcustomerspage();
	apcp.addnewcustomerbtn();
	
	wlib.waitForPageTitle(flib.readPropData(PROP_PATH, "addnewcustomerpage"));
	wlib.verifyPage(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "addnewcustomerpage"), "add new customer page");
	
	addnewcustomerpage ancp=new addnewcustomerpage();
	ancp.custnametb(flib.getData(EXCEL_PATH, "Sheet1", 5, 1));
	ancp.createbtn();
	
	if(apcp.getsuccess().isDisplayed())
	{
		System.out.println("customer is created,success msg is displayed ");
	}
	else
	{
		System.out.println("customer is not created, success msg is not displayed");
	}
	apcp.getsuccessmsg();
}
}
