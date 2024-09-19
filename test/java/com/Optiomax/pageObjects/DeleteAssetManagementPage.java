package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAssetManagementPage {
    WebDriver driver;
    
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    By deleteIcon = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div[3]/div/div[2]/div[1]/div[2]/a[3]"); 
    By serialNumberInput = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/form/div/div/input"); 
    By deleteButton = By.xpath("//button[normalize-space()='Delete']"); 
    By closeButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[1]/a");
  
    public DeleteAssetManagementPage(WebDriver driver) {
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

    public void enterSerialNumber(String serialNumber) {
        driver.findElement(serialNumberInput).sendKeys(serialNumber);
    }

    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }
    
}

