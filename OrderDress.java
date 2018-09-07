package com.Automationsite;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class OrderDress {
	
	WebDriver driver;

	@FindBy(how=How.ID,using="search_query_top")
	WebElement SearchText;
	
	@FindBy(how=How.CSS,using="[name='submit_search']")
	WebElement SearchButton;
	
	@FindBy(how=How.XPATH,using="//a[@class='product_img_link']/img")
	WebElement ImageD;
	
	@FindBy(how=How.XPATH,using="//div[@class='product-image-container']/a[2][@class='quick-view']")
	WebElement Quickview;
	
	@FindBy(how=How.ID,using="thumb_1")
	WebElement View1;
	
	@FindBy(how=How.ID,using="thumb_2")
	WebElement View2;
	
	@FindBy(how=How.ID,using="thumb_3")
	WebElement View3;

	@FindBy(how=How.ID,using="thumb_4")
	WebElement View4;
	
	@FindBy(how=How.CSS,using="[id='quantity_wanted']")
	WebElement Quantity;
	
	@FindBy(how=How.XPATH,using="//p[@id='quantity_wanted_p']/a[2]/span/i")
	WebElement AddQty;
	
	@FindBy(how=How.CSS,using="[id='group_1']")
	WebElement Size;
	
	@FindBy(how=How.XPATH,using="//p[@id='add_to_cart']/button/span[text()='Add to cart']")
	WebElement Addtocart;
	
	@FindBy(how=How.XPATH,using="//div[@id='layer_cart']/div[1]/div[1]/span[@title='Close window']")
	WebElement Close;
	
	@FindBy(how=How.XPATH,using="//div[@id=\"layer_cart\"]/div[1]/div[1]/h2/text()")
	WebElement Successmsg;
	
	
	@FindBy(how=How.XPATH,using="//div[@class='shopping_cart']/a/b")
	WebElement Cart;
	
	@FindBy(how=How.CSS,using="[title='Check out']>span")
	WebElement CheckOut;
	
	@FindBy(how=How.XPATH,using="//p[@class='cart_navigation clearfix']/a/span")
	WebElement Proceedcheck1;
			
	@FindBy(how=How.XPATH,using="//button[@name='processAddress']/span")
	WebElement Proceedcheck2;
	
	@FindBy(how=How.CSS,using="[id='cgv']")
	WebElement checkbox;
	
	@FindBy(how=How.XPATH,using="//button[@name='processCarrier']/span")
	WebElement Proceedcheck3;
	
	@FindBy(how=How.CSS,using="[id='total_price_container']>span")
	WebElement Total;
	
	@FindBy(how=How.ID,using="bigpic")
	WebElement Window;

	
	
	
	public OrderDress(WebDriver driver) {
		this.driver=driver;
	}
	
	public void searchItem(String item) throws InterruptedException {
		SearchText.sendKeys(item);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SearchButton.click();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",ImageD);
		
		Actions action = new Actions(driver);
		action.moveToElement(ImageD).perform();
		Quickview.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(4000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",View1);
		
		action.moveToElement(View1).perform();
		Thread.sleep(2000);
		action.moveToElement(View2).perform();
		Thread.sleep(2000);
		action.moveToElement(View3).perform();
		Thread.sleep(2000);
		action.moveToElement(View4).perform();
		Thread.sleep(2000);
}

	public void addToCart() throws InterruptedException {
		AddQty.click();
		Thread.sleep(2000);
		System.out.println("Quantity ="+ Quantity.getText());
		
		Select select = new Select(Size);
		select.selectByVisibleText("M");
		Addtocart.click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Close.click();
	}
	
	
	public void cart() throws InterruptedException {

		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		action.moveToElement(Cart).perform();
		
		CheckOut.click();
		Thread.sleep(2000);
		Proceedcheck1.click();
		Thread.sleep(2000);
		Proceedcheck2.click();
		Thread.sleep(2000);
		checkbox.click();
		System.out.println(checkbox.isSelected());
		Proceedcheck3.click();
		Thread.sleep(2000);
		System.out.println("Total amount is "+Total.getText());
		
	}
}

