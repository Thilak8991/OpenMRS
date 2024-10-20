package com.baseclass;

import org.openqa.selenium.WebDriver;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public abstract class BaseClass {
	
	 protected WebDriver driver;
	    public static ExtentReports extentReports;
	    public static File file;
	    // browser launch
	    protected WebDriver launchBrowser(String browserName) {
	        try {
	            if (browserName.equalsIgnoreCase("chrome")) {
	                ChromeOptions options = new ChromeOptions();
	                options.addArguments("start-maximized");
	                driver = new ChromeDriver(options);
	            } else if (browserName.equalsIgnoreCase("edge")) {
	                driver = new EdgeDriver();
	            } else if (browserName.equalsIgnoreCase("FireFox")) {
	                driver = new FirefoxDriver();
	            } else if (browserName.equalsIgnoreCase("IE")) {
	                driver = new InternetExplorerDriver();
	            }
	        } catch (Exception e) {
	            throw new RuntimeException("Error launching browser: " + e.getMessage());
	        }
	        return driver;
	    }

	    // get Url
	    protected void launchUrl(String url) {
	        try {
	            driver.get(url);
	        } catch (Exception e) {
	            throw new RuntimeException("Error launching URL: " + e.getMessage());
	        }
	    }

	    protected void inputValue(WebElement element, String value) {
	        try {
	            element.sendKeys(value);
	        } catch (Exception e) {
	            throw new RuntimeException("Error inputting value: " + e.getMessage());
	        }
	    }

	    protected void clickElement(WebElement element) {
	        try {
	            element.click();
	        } catch (Exception e) {
	            throw new RuntimeException("Error clicking element: " + e.getMessage());
	        }
	    }

	    protected boolean isElementEnabled(WebElement element) {
	        try {
	            return element.isEnabled();
	        } catch (Exception e) {
	            throw new RuntimeException("Error checking element enabled: " + e.getMessage());
	        }
	    }

	    protected void framesIndex(int index) {
	        try {
	            driver.switchTo().frame(index);
	        } catch (Exception e) {
	            throw new RuntimeException("Error switching to frame by index: " + e.getMessage());
	        }
	    }
	    
	    protected static void validation(String actual, String excepected) {
			try {
				Assert.assertEquals(actual, excepected);
			} catch (Exception e) {

				Assert.fail("ERROR : OCCUR DURING VALIDATION");
			}
		}


	    protected void frameWebElement(WebElement element) {
	        try {
	            driver.switchTo().frame(element);
	        } catch (Exception e) {
	            throw new RuntimeException("Error switching to frame by element: " + e.getMessage());
	        }
	    }

	    protected void framesID(String IDorName) {
	        try {
	            driver.switchTo().frame(IDorName);
	        } catch (Exception e) {
	            throw new RuntimeException("Error switching to frame by ID or name: " + e.getMessage());
	        }
	    }

	    protected void framesDefaultContent() {
	        try {
	            driver.switchTo().defaultContent();
	        } catch (Exception e) {
	            throw new RuntimeException("Error switching to default content: " + e.getMessage());
	        }
	    }

	    protected void terminateBrowser() {
	        try {
	            driver.quit();
	        } catch (Exception e) {
	            throw new RuntimeException("Error terminating browser: " + e.getMessage());
	            
	        }
	    }
	    public static void extentReportStart(String location) {
			extentReports = new ExtentReports();
			file = new File(location);
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		}

		public static void extentReportTearDown(String location) throws IOException {
			extentReports.flush();
			file = new File(location);
			Desktop.getDesktop().browse((file).toURI());
		}


	    protected void takeScreenshot(String fileName) throws IOException {
	        TakesScreenshot tk = (TakesScreenshot) driver;
	        File src = tk.getScreenshotAs(OutputType.FILE);
	        File Des = new File("screenshots/" + fileName + ".png");
	        FileHandler.copy(src, Des);
	    }
	
	
	}
