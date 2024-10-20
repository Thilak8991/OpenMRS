package com.testing;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.setup.BaseClass;

public class SwagLabs extends BaseClass {
	
	@Test(groups = "login")
	private void browserLaunch() throws InterruptedException {
		launchBrowser("Chrome");
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods = "browserLaunch",groups = "login")
	private void urlLaunch() {
		launchUrl("https://www.saucedemo.com/v1/index.html");
		
	}
	@Test(dependsOnMethods = "urlLaunch",groups = "login")
	private void loginPage() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		//String currentUrl= driver.getCurrentUrl();
		//System.out.println(currentUrl);
		//Assert.assertEquals(currentUrl,"https://www.saucedemo.com/v1/index.html");
		
	}
	@Test(dependsOnMethods = "loginPage",groups = "Product")
	private void productSearch() {
		driver.findElement(By.xpath("(//div[@class=\"inventory_item_name\"])[1]")).click();
	}
	@Test(dependsOnMethods = "productSearch",groups = "Product")
	private void addToCart() {
		driver.findElement(By.xpath("//button[@class=\"btn_primary btn_inventory\"]")).click();
	}
	@Test(dependsOnMethods = "productSearch",groups = "Product")
	private void checkOut() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class=\"fa-layers-counter shopping_cart_badge\"]")).click();
		driver.findElement(By.xpath("//a[@class=\"btn_action checkout_button\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"first-name\"]")).sendKeys("Thilak");
		driver.findElement(By.xpath("//input[@id=\"last-name\"]")).sendKeys("Chandar");
		driver.findElement(By.xpath("//input[@id=\"postal-code\"]")).sendKeys("600041");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class=\"btn_primary cart_button\"]")).click();
		driver.findElement(By.xpath("//a[@class=\"btn_action cart_button\"]")).click();
	}
	@Test(dependsOnMethods = "checkOut",groups = "Product")
	private void logout() {
		driver.quit();

	}

	
	

	
	
	
}
