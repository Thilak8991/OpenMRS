package com.testing;

import org.testng.annotations.Test;

import com.setup.BaseClass;

public class InvocationCount extends BaseClass{
	
	@Test(invocationCount = 4)
	private void launchBrowser() {
        launchBrowser("Chrome");
	}

}
