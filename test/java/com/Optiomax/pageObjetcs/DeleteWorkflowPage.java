package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteWorkflowPage {
    WebDriver driver;
    
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    // Locators for the elements
    By deleteIcon = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div[2]/div[2]/div/a[2]"); 
    By workflowNameInput = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[3]/form/div/div/input"); 
    By deleteButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[3]/form/button"); 
    By closeButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button");
  
    public DeleteWorkflowPage(WebDriver driver) {
        this.driver = driver;
    }
  
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }
    
    // Methods to interact with elements
    public void clickDeleteIcon() {
        driver.findElement(deleteIcon).click();
    }

    public void enterWorkflowName(String workflowName) {
        driver.findElement(workflowNameInput).sendKeys(workflowName);
    }

    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }
    
}

