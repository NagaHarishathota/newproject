package com.FlipKart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FlipKart.generic.BaseTest;

public class addnewcustomerpage
{
@FindBy(xpath="//input[@name='name']")
private WebElement custname;

@FindBy(xpath="//input[@type='submit']")
private WebElement createcus;

	public addnewcustomerpage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void custnametb(String name)
	{
		 custname.sendKeys(name);;
	}
		
	public void createbtn()
	{
		 createcus.click();
	}
}
