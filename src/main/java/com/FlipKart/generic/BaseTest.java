package com.FlipKart.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest implements IAutoConstants
{
	public static WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser() throws Throwable
	{
		FileLib flib=new FileLib();
		String browser=flib.readPropData(PROP_PATH, "browser");
		if(browser.equals("chrome"))
		{
			System.setProperty(CHROME_PATH, CHROME_VALUE);
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty(GECKO_PATH, GECKO_VALUE);
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("give correct broswer address");
		}
		String url=flib.readPropData(PROP_PATH, "url");
		driver.get(url);
		
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		wlib.verifyPage(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "loginpage"), "login page");
	}
}
