package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUserRolesPage extends BasePage {

    public AddUserRolesPage(WebDriver driver) {
        this.driver = driver;
    }
    
	// Web elements for sign in page
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    // Web elements for add new user role page
    By addNewUserRoleButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button");
    By roleNameInput = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input");
    By roleDescriptionInput = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[2]/textarea");
    By createButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button");
    By closeButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button");
    By successMessage = By.xpath("");
    By errorMessage = By.xpath("");
    By nextButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[2]/nav/ul/li[4]/button");

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click(); 
        driver.findElement(signInButton).click();
    }
    
    public void clickAddNewUserRoleButton() {
        driver.findElement(addNewUserRoleButton).click();
    }

    public void enterRoleName(String roleName) {
        driver.findElement(roleNameInput).sendKeys(roleName);
    }

    public void enterRoleDescription(String roleDescription) {
        driver.findElement(roleDescriptionInput).sendKeys(roleDescription);
    }

    public void clickCreateButton() {
        driver.findElement(createButton).click();
    }
    
    public void clickCloseButton() {
    	driver.findElement(closeButton).click();
    }
    
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
     
    public String getSuccessMessage() {
    	return driver.findElement(successMessage).getText();
    }
    
    public void clickNextButton() {
    	driver.findElement(nextButton).click();
    }

    public boolean isRolePresent(String roleName) {
        return driver.findElements(By.xpath("//div[contains(text(),'" + roleName + "')]")).size() > 0;
    }
}


