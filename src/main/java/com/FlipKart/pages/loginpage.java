package com.FlipKart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FlipKart.generic.BaseTest;

public class loginpage
{
	@FindBy(name="username")
	private WebElement untb;
	
	@FindBy(name="pwd")
	private WebElement pwtb;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginbtn;
	
	public loginpage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void login(String un,String pwd)
	{
		untb.sendKeys(un);
		pwtb.sendKeys(pwd);
		loginbtn.click();
	}
}
