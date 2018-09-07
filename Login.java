package com.Automationsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login {

	WebDriver driver;

	@FindBy(how=How.CSS,using=".login")
    WebElement Signin;
	
	@FindBy(how=How.ID,using="email")
	WebElement username;
	
	@FindBy(how=How.ID,using="passwd")
	WebElement pwd;
	
	@FindBy(how=How.NAME,using="SubmitLogin")
	WebElement login;
	
	@FindBy(how=How.CSS,using="[class='info-account']")
	WebElement logged; 
	
	public Login(WebDriver driver) {
		
		this.driver= driver;
	}
	
	public void signIn(String email,String pass) {
		Signin.click();
		username.sendKeys(email);
		pwd.sendKeys(pass);
		login.click();
		
		System.out.println(logged.getText());
		
			}
}
