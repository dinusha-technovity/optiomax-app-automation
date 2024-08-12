package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteSupplierPage {
    WebDriver driver;
    
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    By deleteIcon = By.xpath(""); 
    By supplierNameInput = By.xpath(""); 
    By deleteButton = By.xpath(""); 
    By closeButton = By.xpath("");
  
    public DeleteSupplierPage(WebDriver driver) {
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

    public void enterSupplierName(String supplierName) {
        driver.findElement(supplierNameInput).sendKeys(supplierName);
    }

    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }
    
}


