package com.Optiomax.pageObjetcs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateWorkflowPage {

    WebDriver driver;
    
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    // Define locators
    By updateIcon = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div[2]/div[2]/div/a[1]");
    By workflowNameField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"); 
    By workflowDescriptionField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[2]/textarea"); 
    By workflowStatusToggle = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[3]/label/label/div");
    By updateButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button"); 
    By closeButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button");
    By workflowList = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div");

    // Constructor
    public UpdateWorkflowPage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }
    
    public void clickUpdateIcon() {
    	driver.findElement(updateIcon).click();
    }

    public void setWorkflowName(String workflowName) {
    	driver.findElement(workflowNameField).click();
        driver.findElement(workflowNameField).clear();
        driver.findElement(workflowNameField).sendKeys(workflowName);
    }

    public void setWorkflowDescription(String workflowDescription) {
    	driver.findElement(workflowDescriptionField).click();
        driver.findElement(workflowDescriptionField).clear();
        driver.findElement(workflowDescriptionField).sendKeys(workflowDescription);
    }

    public void toggleWorkflowStatus() {
        driver.findElement(workflowStatusToggle).click();
    }

    public void clickUpdateButton() {
        driver.findElement(updateButton).click();
    }
    
    public void clickCloseButton() {
    	driver.findElement(closeButton).click();
    }

    public String getWorkflowName() {
        return driver.findElement(workflowNameField).getAttribute("value"); 
    }

    public String getErrorMessage() {
        return driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/ul/li")).getText();
    }
    
    public String getValidation() {
    	return driver.findElement(By.xpath("")).getText();
    }
    
    public boolean isWorkflowPresent(String name) {
        List<WebElement> workflows = driver.findElements(workflowList);
        for (WebElement workflow : workflows) {
            if (workflow.getText().contains(name)) {
                return true;
            }
        }
        return false;
    }
}

