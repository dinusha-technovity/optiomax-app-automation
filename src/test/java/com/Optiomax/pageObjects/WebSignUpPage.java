package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebSignUpPage {

    private WebDriver driver;

    private By getStartedBtn = By.xpath("");
    private By monthlySelection = By.xpath("");
    private By yearlySelection = By.xpath("");
    private By freeSelection = By.xpath("");
    private By starterSelection = By.xpath("");
    private By scaleSelection = By.xpath("");
    private By proSelection = By.xpath("");
    private By backBtn = By.xpath("");
    private By continueBtn = By.xpath("");
    private By loginHereLink = By.xpath("");
    
    
    public WebSignUpPage(WebDriver driver) {
        this.driver = driver;
    } 

    public void clickGetStarted() {
    	WebElement getStarted = driver.findElement(getStartedBtn);
    	getStarted.click();
    }
    
    public void clickMonthlySelection() {
    	WebElement monthlySelect = driver.findElement(monthlySelection);
    	monthlySelect.click();
    }
    
    public void clickYearlySelection() {
    	WebElement yearlySelect = driver.findElement(yearlySelection);
    	yearlySelect.click();
    }
    
    public void clickFreePackage() {
    	WebElement freeSelect = driver.findElement(freeSelection);
    	freeSelect.click();
    }
    
    public void clickStarterPackage() {
    	WebElement starterSelect = driver.findElement(starterSelection);
    	starterSelect.click();
    }
    
    public void click

    public void clickRememberMe() {
        WebElement rememberMeElement = driver.findElement(rememberMeCheckbox);
        rememberMeElement.click();
    }

    public void clickSignIn() {
        WebElement signInElement = driver.findElement(signInButton);
        signInElement.click();
    }

    public void signIn(String email, String password, boolean rememberMe) throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        if (rememberMe) {
            clickRememberMe();
        }
        Thread.sleep(3000); 
        clickSignIn();
        Thread.sleep(3000);
    }
    
    public boolean isPageLoaded() {
    	return driver.getPageSource().contains("dashboard");
    }
}



