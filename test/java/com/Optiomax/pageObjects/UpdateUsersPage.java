package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdateUsersPage extends BasePage {
	
	// Web elements for sign in page
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    // Locators    
    private By userNameField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[1]/input");
    private By emailsField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[2]/input");
    private By nameField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[3]/input");
    private By phoneNumberField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/input");
    private By addressField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input");
    private By descriptionField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[4]/textarea");
    private By roleDropdown = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/button");
    private By uploadImageButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/label/div");
    private By updateButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[7]/div[2]/div[2]/div/div[2]/form/button");
    private By dragAndDropArea = By.xpath("");

    public UpdateUsersPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click(); 
        driver.findElement(signInButton).click();
    }

    // Methods
    public void setUserName(String userName) {
        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void setEmail(String email) {
        driver.findElement(emailsField).clear();
        driver.findElement(emailsField).sendKeys(email);
    }

    public void setName(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    public void setDescription(String description) {
        driver.findElement(descriptionField).clear();
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void selectRole(String role) {
        Select dropdown = new Select(driver.findElement(roleDropdown));
        dropdown.selectByVisibleText(role);
    }

    public void uploadImage(String imagePath) {
        driver.findElement(uploadImageButton).sendKeys(imagePath);
    }

    public void updateUser() {
        driver.findElement(updateButton).click();
    }

    public void dragAndDropImage(String imagePath) {
        WebElement uploadArea = driver.findElement(dragAndDropArea);
        uploadArea.sendKeys(imagePath); 
    }
    
}

