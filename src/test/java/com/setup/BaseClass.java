package com.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public abstract class BaseClass {
	
	public static WebDriver driver;
	
	
	protected static WebDriver launchBrowser(String browserName) {
		
		try {
			if(browserName.equalsIgnoreCase("Chrome")) {
				driver=new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("Edge")){
					driver=new EdgeDriver();
				}else if(browserName.equalsIgnoreCase("Firefox")){
					driver=new FirefoxDriver();
				}
			} catch(Exception e) {
				Assert.fail("Problem occured due to improper lauching of the browser");
			}
		driver.manage().window().maximize();
		return driver;
		}
	protected static void  launchUrl(String Url) {
		try {
			driver.get(Url);
		} catch (Exception e) {
			Assert.fail("Error: Occur During URL Launch");
		}
	}
	
	protected static void inoutValues (WebElement element, String Value) {
		try {
			element.sendKeys(Value);
		}catch (Exception e) {
			Assert.fail("Error: occur click the element");
		}
	}
	
	protected static void navigate() {
		try {
			driver.navigate();
		}catch (Exception e) {
			Assert.fail("Error : occur Navigate to next Page");
		}
	}
	protected static void closeOption() {
		try {
			driver.close();
		}catch (Exception e) {
			Assert.fail("Error : occur closing the current page");
		}
	}
	protected static void quit() {
		try {
			driver.quit();
		}catch (Exception e) {
			Assert.fail("Error : occur Quit the entire page");
		}
	}
	
	
	}
	
	
