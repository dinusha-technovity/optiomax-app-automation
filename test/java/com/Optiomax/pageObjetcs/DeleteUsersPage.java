package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteUsersPage extends BasePage {

    public DeleteUsersPage(WebDriver driver) {
        this.driver = driver;
    }
    
	// Web elements for sign in page
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    // Locator for the delete button of a specific user
    public WebElement getDeleteButton(String userName) {
        //return driver.findElement(By.xpath("//div[text()='" + userName + "']//following-sibling::div//button[@class='delete-icon']"));
        return driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[7]/div[2]/div[2]/a[3]"));
    }

    // Locator for the delete confirmation input field
    public WebElement getDeleteConfirmationInput() {
        return driver.findElement(By.xpath("//input[@placeholder='Ruvinya']"));
    }

    // Locator for the delete confirmation button
    public WebElement getDeleteConfirmationButton() {
        return driver.findElement(By.xpath("//button[text()='Delete']"));
    }

    // Locator for the cancel button in the delete confirmation pop-up
    public WebElement getCancelButton() {
        return driver.findElement(By.xpath("//button[text()='Cancel']"));
    }

    // Method to delete a user
    public void deleteUser(String userName, String confirmationName) {
        getDeleteButton(userName).click();
        getDeleteConfirmationInput().sendKeys(confirmationName);
        getDeleteConfirmationButton().click();
    }

    // Method to cancel deletion
    public void cancelDeletion(String userName, String confirmationName) {
        getDeleteButton(userName).click();
        getDeleteConfirmationInput().sendKeys(confirmationName);
        getCancelButton().click();
    }
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click(); 
        driver.findElement(signInButton).click();
    }
}

