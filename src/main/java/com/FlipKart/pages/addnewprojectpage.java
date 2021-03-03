package com.FlipKart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.FlipKart.generic.BaseTest;

public class addnewprojectpage 
{
@FindBy(xpath="//select[@name='customerId']")
private WebElement dropdown;

@FindBy(xpath="//input[@name='name']")
private WebElement projname;

@FindBy(xpath="//input[@name='createProjectSubmit']")
private WebElement submitbtn;

public addnewprojectpage()
{
	PageFactory.initElements(BaseTest.driver, this);
}

public void customerdrop(String text)
{
	Select sel=new Select(dropdown);
	sel.selectByVisibleText(text);
}

public void projectnamebtn(String name)
{
	projname.sendKeys(name);
}

public void clickprojectbtn()
{
	submitbtn.click();
}
}