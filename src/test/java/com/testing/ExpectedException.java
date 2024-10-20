package com.testing;

import org.testng.annotations.Test;

import com.setup.BaseClass;

public class ExpectedException extends BaseClass {
	@Test(expectedExceptions = ArithmeticException.class)
	private void exception() {
		
		launchBrowser("Chrome");
		launchUrl("https://www.google.co.in/");
		int a=10/0;
		System.out.println("Browser launched");
		

	}

}
