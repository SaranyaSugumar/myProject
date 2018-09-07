package com.Automationsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {

	WebDriver driver;
	
	Login loginObj;
	OrderDress orderObj;
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Driver\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		
		loginObj=PageFactory.initElements(driver, Login.class);
		orderObj=PageFactory.initElements(driver, OrderDress.class);
			
	    }
	@Test(priority=1)
	public void loginPage() {
		loginObj.signIn("Saranya.r01@gmail.com", "Success1");
			}
	
	@Test(priority=2)
	public void order() throws InterruptedException {
		orderObj.searchItem("T-shirt");
		orderObj.addToCart();
		orderObj.cart();
	}
}
