package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateOrganizationPage extends BasePage {
    
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    // Locators
    By addButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/ul/li/div/div[3]/button");
    By organizationLevelField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input");  
    By organizationNameField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[2]/input"); 
    By organizationDescriptionField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[3]/input");
    By telephoneNumberField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[4]/input");
    By addressField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[5]/input");
    By emailsField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[6]/input");
    By websiteField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[7]/input");
    By saveButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button");
    By closeButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/button");
    By errorMessage = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[6]/input");

    public UpdateOrganizationPage(WebDriver driver) {
        this.driver = driver;
    } 
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }
    
    public void setAddButton() {
    	driver.findElement(addButton).click();
    }

    public void setOrganizationLevel(String level) {
        driver.findElement(organizationLevelField).clear();
        driver.findElement(organizationLevelField).sendKeys(level);
    }

    public void setOrganizationName(String name) {
        driver.findElement(organizationNameField).clear();
        driver.findElement(organizationNameField).sendKeys(name);
    }

    public void setOrganizationDescription(String description) {
        driver.findElement(organizationDescriptionField).clear();
        driver.findElement(organizationDescriptionField).sendKeys(description);
    }

    public void setTelephoneNumber(String number) {
        driver.findElement(telephoneNumberField).clear();
        driver.findElement(telephoneNumberField).sendKeys(number);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    public void setEmail(String emails) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(emails);
    }

    public void setWebsite(String website) {
        driver.findElement(websiteField).clear();
        driver.findElement(websiteField).sendKeys(website);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }
    
    public void clickClose() {
    	driver.findElement(closeButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    
}

