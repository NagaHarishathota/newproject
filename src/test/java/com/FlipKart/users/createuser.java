package com.FlipKart.users;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FlipKart.generic.BaseTest;
import com.FlipKart.generic.FileLib;
import com.FlipKart.generic.WebDriverCommonLib;
import com.FlipKart.pages.addnewuserpage;
import com.FlipKart.pages.loginpage;
import com.FlipKart.pages.opentaskpage;
import com.FlipKart.pages.userlistpage;

@Listeners(com.FlipKart.generic.MyListeners.class)
public class createuser extends BaseTest
{
	@Test
	public void createusertest() throws Throwable
	{
		loginpage lp=new loginpage();
		FileLib flib=new FileLib();
		lp.login(flib.readPropData(PROP_PATH, "username"), flib.readPropData(PROP_PATH, "password"));
		
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		
		wlib.waitForPageTitle(flib.readPropData(PROP_PATH, "opentaskpage"));
		wlib.verifyPage(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "opentaskpage"), " open task page ");
		
		opentaskpage otp=new opentaskpage();
		otp.clickusersTab();
		
		wlib.waitForPageTitle(flib.readPropData(PROP_PATH, "userlistpage"));
		wlib.verifyPage(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "userlistpage"), "user list page");
		Thread.sleep(3000);
		userlistpage ulp=new userlistpage();
		ulp.clickaddnewuser();
		
		wlib.waitForPageTitle(flib.readPropData(PROP_PATH, "addnewuserpage"));
		wlib.verifyPage(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "addnewuserpage"), "add new user page");
		Thread.sleep(3000);
		addnewuserpage anup=new addnewuserpage();
		anup.details(flib.getData(EXCEL_PATH, "Sheet1", 0, 1), 
				flib.getData(EXCEL_PATH, "Sheet1", 1, 1),
				flib.getData(EXCEL_PATH, "Sheet1", 2, 1),
				flib.getData(EXCEL_PATH, "Sheet1", 3, 1),
				flib.getData(EXCEL_PATH, "Sheet1", 4, 1));
		
		if(ulp.getsuccessmsg().isDisplayed())
		{
			Reporter.log("user is created, Success message is Displayed", true);
		}
		else
		{
			Reporter.log("user is not created , Success message is not Displayed");
		}
		
	}
}
