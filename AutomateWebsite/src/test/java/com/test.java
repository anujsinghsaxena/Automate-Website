package com;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test {
	WebDriver wd;
	@BeforeMethod
	  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver","E:\\Mphasis\\Phase 5 Programs\\chromedriver.exe");
		wd = new ChromeDriver();
	  }
  @Test(priority =1)
  public void register() {
	wd.get("https://www.amazon.in/");
	wd.findElement(By.id("nav-link-accountList")).click();
	wd.findElement(By.id("createAccountSubmit")).click();
	wd.findElement(By.id("ap_customer_name")).sendKeys("Anuj");
	wd.findElement(By.id("ap_phone_number")).sendKeys("7678852469");
	wd.findElement(By.id("ap_email")).sendKeys("anuj@gmail.com");
	wd.findElement(By.id("ap_password")).sendKeys("1234");
	wd.findElement(By.id("ap_password_check")).sendKeys("1234");
	wd.findElement(By.id("continue")).click();
  }
  
  @Test(priority = 1)
  public void login() {
	wd.get("https://www.amazon.in/");
	wd.findElement(By.id("nav-link-accountList")).click();
	wd.findElement(By.id("ap_email")).sendKeys("anuj@gmail.com");
	wd.findElement(By.id("continue")).click();
	wd.findElement(By.id("ap_password")).sendKeys("1234");
	wd.findElement(By.id("signInSubmit")).click();
  }
  
  @Test(priority = 2)
  public void addToCart() throws InterruptedException{
	  wd.get("https://www.amazon.in/");
	  wd.findElement(By.id("nav-link-accountList")).click();
		wd.findElement(By.id("ap_email")).sendKeys("anuj@gmail.com");
		wd.findElement(By.id("continue")).click();
		wd.findElement(By.id("ap_password")).sendKeys("1234");
		wd.findElement(By.id("signInSubmit")).click();
	  System.out.println(wd.getTitle());
	  System.out.println(wd.getCurrentUrl());
	  wd.findElement(By.id("twotabsearchtextbox")).sendKeys("Realme Lcd");
	  Thread.sleep(10000);
	  wd.findElement(By.id("nav-search-submit-button")).submit();
	  wd.findElement(By.linkText("realme NEO 80 cm (32 inch) HD Ready LED Smart TV (RMV2101)")).click();
	  wd.findElement(By.id("add-to-cart-button")).click();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
