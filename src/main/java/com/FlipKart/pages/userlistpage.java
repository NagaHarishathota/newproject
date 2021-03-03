package com.FlipKart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FlipKart.generic.BaseTest;

public class userlistpage 
{
	@FindBy(xpath="//input[@value='Add New User']")
	private WebElement addnewuserbtn;
	
	@FindBy(xpath="//span[@class='successmsg']")
	private WebElement sucmsg;
	
	public userlistpage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void clickaddnewuser()
	{
		addnewuserbtn.click();
	}
	
	public WebElement getsuccessmsg()
	{
		return sucmsg;
	}
	
	public String getTextsuccesmsg()
	{
		return sucmsg.getText();
	}
}
