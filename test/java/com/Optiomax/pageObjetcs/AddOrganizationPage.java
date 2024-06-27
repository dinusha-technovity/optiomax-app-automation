package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOrganizationPage extends BasePage {
	
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    private By organizationLevelField = By.xpath("");
    private By organizationNameField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[2]/input");
    private By organizationDescriptionField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[3]/input");
    private By telephoneNumberField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[4]/input");
    private By addressField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[5]/input");
    private By emailsField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[6]/input");
    private By websiteField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[7]/input");
    private By saveButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button");
    private By closeButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/button");
    private By errorMessage = By.xpath("");
    
    public AddOrganizationPage(WebDriver driver) {
        this.driver = driver; 
    }
 
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public void setOrganizationLevel(String level) {
        driver.findElement(organizationLevelField).sendKeys(level);
    }

    public void setOrganizationName(String name) {
        driver.findElement(organizationNameField).sendKeys(name);
    }

    public void setOrganizationDescription(String description) {
        driver.findElement(organizationDescriptionField).sendKeys(description);
    }

    public void setTelephoneNumber(String number) {
        driver.findElement(telephoneNumberField).sendKeys(number);
    }

    public void setEmail(String emails) {
        driver.findElement(emailsField).sendKeys(emails);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setWebsite(String website) {
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

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
