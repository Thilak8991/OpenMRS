package com.testing;



import org.testng.annotations.Test;
import com.setup.BaseClass;

public class CrossBrowserTesting extends BaseClass {
	
	@Test(priority = -1)
	private void chrome() {
		launchBrowser("Chrome");
		launchUrl("https://www.google.co.in/");
		System.out.println("Browser ID : "+ Thread.currentThread().getId());
		quit();
	}
	@Test(priority = 5)
private void edge() {
		launchBrowser("Edge");
		launchUrl("https://www.google.co.in/");
		System.out.println("Browser ID : "+ Thread.currentThread().getId());
		quit();
}
	@Test(priority = -2)
	private void fireFox() {
		launchBrowser("Firefox");
		launchUrl("https://www.google.co.in/");
		System.out.println("Browser ID : "+ Thread.currentThread().getId());
		quit();
	}
}