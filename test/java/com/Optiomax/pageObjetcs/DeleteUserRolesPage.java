package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteUserRolesPage {
    WebDriver driver; 

    public DeleteUserRolesPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");
    
    By deleteIcon = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[4]/div[2]/div/a[3]");
    By inputField = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[4]/div[2]/div/div/div[2]/form/div/div/input[3]");
    By deleteButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[4]/div[2]/div/div/div[2]/form/button");
    By closeButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[4]/div[2]/div/div/div[2]/div[1]/button");
    
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }
    
    public void clickDeleteIcon() {
    	driver.findElement(deleteIcon).click();
    }
 
    public void enterText(String text) {
        WebElement input = driver.findElement(inputField);
        input.clear();
        input.sendKeys(text);
    }

    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }

    public boolean isPopupPresent() {
       return driver.findElement(deleteButton).isDisplayed();
    } 
    
}

