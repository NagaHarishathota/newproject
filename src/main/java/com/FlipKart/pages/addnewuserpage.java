package com.FlipKart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FlipKart.generic.BaseTest;
public class addnewuserpage
{
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement usr;
	
	@FindBy(name="passwordText")
	private WebElement psd;
	
	@FindBy(name="passwordTextRetype")
	private WebElement repsd;
	
	@FindBy(name="firstName")
	private WebElement frstname;
	
	@FindBy(name="lastName")
	private WebElement lstname;
	
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement createusr;
	
	public addnewuserpage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void details(String user,String password,String Retype,String Firstname,String lastname)
	{
		usr.sendKeys(user);
		psd.sendKeys(password);
		repsd.sendKeys(Retype);
		frstname.sendKeys(Firstname);
		lstname.sendKeys(lastname);
		createusr.click();
	}
	
}
