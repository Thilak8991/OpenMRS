package com.testing;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.setup.BaseClass;

public class ITest extends BaseClass{
	
	@BeforeTest
	private void lauchBrowser() {
		launchBrowser("Chrome");
		launchUrl("https://www.google.co.in/");

	}
	@AfterTest
	private void closeBrowser() {
		driver.quit();
	}
	@Test(retryAnalyzer = Retest.class)
	private void title() {
		
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "google");

	}


}
