package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAssetsPage {
    WebDriver driver;
    
    private By emailField = By.xpath("");
    private By passwordField = By.xpath("");
    private By rememberMeCheckbox = By.xpath("");
    private By signInButton = By.xpath("");

    private By deleteIcon = By.xpath("");
    private By assetNameInputField = By.xpath("");
    private By deleteBtn = By.xpath("");
    private By closeBtn = By.xpath("");
    
    public DeleteAssetsPage(WebDriver driver) {
        this.driver = driver;
    }
  
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }
    
    public void clickDeleteIcon() {
        driver.findElement(deleteIcon).click();
    }

    public void enterAssetName(String assetName) {
        driver.findElement(assetNameInputField).sendKeys(assetName);
    }

    public void clickDelete() {
        driver.findElement(deleteBtn).click();
    }

    public void clickClose() {
        driver.findElement(closeBtn).click();
    }
    
}


