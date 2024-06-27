package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddUsersPage extends BasePage {

    // Constructor
    public AddUsersPage(WebDriver driver) {
        this.driver = driver;
    }
    
	// Web elements for sign in page
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    // Locators
    By addNewUserButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button");
    By userNameField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[1]/input");
    By emailsField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[2]/input");
    By fullNameField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[3]/input");
    By phoneNumberField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/input");
    By addressField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input");
    By descriptionField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[4]/textarea");
    By roleDropdown = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/button");
    By uploadImageButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/label/div");
    By saveButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click(); 
        driver.findElement(signInButton).click();
    }

    // Methods
    public void clickAddNewUser() {
        driver.findElement(addNewUserButton).click();
    }

    public void enterUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
    }

    public void enterEmail(String email) {
        driver.findElement(emailsField).sendKeys(email);
    }

    public void enterFullName(String fullName) {
        driver.findElement(fullNameField).sendKeys(fullName);
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void selectRole(String role) {
        Select select = new Select(driver.findElement(roleDropdown));
        select.selectByVisibleText(role);
    }

    public void uploadImage(String imagePath) {
        driver.findElement(uploadImageButton).sendKeys(imagePath);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }
}

