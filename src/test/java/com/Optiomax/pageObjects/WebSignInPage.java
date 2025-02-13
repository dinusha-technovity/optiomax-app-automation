package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebSignInPage extends BasePage {
	
	// Get Started
	private final By getStartedButton = By.xpath("");
	
	// Package Selection
	private final By monthly = By.xpath("");
	private final By yearly = By.xpath("");
	private final By freePackage = By.xpath("");
	private final By starterPackage = By.xpath("");
	private final By scalePackage = By.xpath("");
	private final By proPackage = By.xpath("");
	private final By backBtn = By.xpath("");
	private final By continueBtn = By.xpath("");
	
	// Personal Information
    private final By firstName = By.xpath("");
    private final By lastName = By.xpath("");
    private final By email = By.xpath("");
    private final By reEnterEmail = By.xpath("");
    private final By password = By.xpath("");
    private final By reEnterPassword = By.xpath("");
    private final By address = By.xpath("");
    private final By userName = By.xpath("");
    private final By contactNumber = By.xpath("");
    private final By backButton = By.xpath("");
    private final By continueButton = By.xpath("");

    // Business Information
    private final By companyOption = By.xpath("");
    private final By companyName = By.xpath("");
    private final By companyEmail = By.xpath("");
    private final By companyContactNumber = By.xpath("");
    private final By companyContactPerson = By.xpath("");
    private final By companyAddress = By.xpath("");
    private final By companyWebsite = By.xpath("");

    // Invite Users
    private final By userNameField = By.xpath("");
    private final By emailField = By.xpath("");
    private final By submitButton = By.xpath("");

    // Error messages
    private final By errorMessage = By.xpath("");
    
    public void clickGetStarted() {
    	driver.findElement(getStartedButton).click();
    }
    
    public void monthlySelection() {
    	driver.findElement(monthly).click();
    }
    
    public void yearlySelection() {
    	driver.findElement(yearly).click();
    }
    
    public void freePackageSelection() {
    	driver.findElement(freePackage).click();
    }
    
    public void starterPackageSelection() {
    	driver.findElement(starterPackage).click();
    }
    
    public void scalePackageSelection() {
    	driver.findElement(scalePackage).click();
    }
    
    public void proPackageSelection() {
    	driver.findElement(proPackage).click();
    }
    
    public void clickBack() {
    	driver.findElement(backBtn).click();
    }
    
    public void clickContinue() {
    	driver.findElement(continueBtn).click();
    }
    
    public void enterPersonalInfo(String fName, String lName, String addr, String mail, String reMail, String uName, String pass, String rePass, String contact) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(reEnterEmail).sendKeys(reMail);
        driver.findElement(userName).sendKeys(uName);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(reEnterPassword).sendKeys(rePass);
        driver.findElement(contactNumber).sendKeys(contact);
        driver.findElement(continueButton).click();
    }

    public void enterBusinessInfo(String compName, String compMail, String compNum, String contactPerson, String compAddr, String website) {
        driver.findElement(companyName).sendKeys(compName);
        driver.findElement(companyEmail).sendKeys(compMail);
        driver.findElement(companyContactNumber).sendKeys(compNum);
        driver.findElement(companyContactPerson).sendKeys(contactPerson);
        driver.findElement(companyAddress).sendKeys(compAddr);
        driver.findElement(companyWebsite).sendKeys(website);
        driver.findElement(continueButton).click();
    }

    public void inviteUsers(String uName, String mail) {
        driver.findElement(userNameField).sendKeys(uName);
        driver.findElement(emailField).sendKeys(mail);
        driver.findElement(submitButton).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElements(errorMessage).size() > 0;
    }
    
	public String getRequiredFieldErrorMessage(String fieldName) {
		return driver.findElement(By.id(fieldName + "Error")).getText();
	}
    
	
}

