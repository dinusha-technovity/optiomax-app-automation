package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateUserRolesPage extends BasePage {
    private WebDriver driver;

    public UpdateUserRolesPage(WebDriver driver) {
        this.driver = driver;
    }
 
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");
    
    private By updateButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[2]/div[2]/div/a[2]");
    private By roleNameInput = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/form/div/div[1]/input[2]");
    private By roleDescriptionInput = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/form/div/div[2]/textarea");
    private By saveButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/form/button");
    private By roleNameError = By.xpath("");
   
       
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    } 

    public void clickUpdateButton(String roleName) {
    	driver.findElement(updateButton).click();
    	//driver.findElement(By.xpath("//h5[text()='" + roleName + "']/../..//button[@title='Edit']")).click();
    }

    public void setRoleName(String roleName) {
        driver.findElement(roleNameInput).clear();
        driver.findElement(roleNameInput).sendKeys(roleName);
    }

    public void setRoleDescription(String roleDescription) {
        driver.findElement(roleDescriptionInput).clear();
        driver.findElement(roleDescriptionInput).sendKeys(roleDescription);
    }
 
    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public boolean isRoleNameErrorDisplayed() {
        return driver.findElement(roleNameError).isDisplayed();
    }

    public String getRoleNameError() {
        return driver.findElement(roleNameError).getText();
    }
} 

