package com.FlipKart.generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

public class WebDriverCommonLib extends BaseTest
{
	public String getPageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public void selectOption(WebElement element,int num)
	{
		Select sel=new Select(element);
		sel.selectByIndex(num);
	}
	
	public void selectOption(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByValue(text);
	}
	
	public void selectOption(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(String text)
	{
		driver.switchTo().frame(text);
	}
	
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void mouseHover(WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();
	}
	
	public void screenshot(String path)
	{
		
		TakesScreenshot tss	=(TakesScreenshot)driver;
		File src=tss.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void verifyPage(String actual,String expected,String pageName)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log(pageName + "is Displayed ",true );
	}
	
	public void waitForPageTitle(String title)
	{
		WebDriverWait wdw=new WebDriverWait(driver,30);
		wdw.until(ExpectedConditions.titleContains(title));
	}
	
	public void waitForElementVisibility(WebElement element)
	{
		WebDriverWait wdw=new WebDriverWait(driver,30);
		wdw.until(ExpectedConditions.visibilityOf(element));
	}
}
