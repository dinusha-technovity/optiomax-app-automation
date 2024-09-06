package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkflowCreationPage {
  
    WebDriver driver;

    public WorkflowCreationPage (WebDriver driver) {
        this.driver = driver;
    }

    // Web elements for sign in page
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");
	 
    private By addNewWorkflowButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/div/div/div[3]/button");
    private By addWorkflowButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/div/div/div[3]/div/ul/li[1]/a");
    private By addConditionButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/div/div/div[3]/div/ul/li[2]/a");
    private By addApprovedButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/div/div/div[3]/div/ul/li[3]/a");
    private By workflowForm = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div/div/div[2]");
    private By conditionForm = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div/div/div[2]");
    private By approvedForm = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/ul/li/ul/li/div");
    private By updateFormUpdateButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div/div[2]/div[2]/form/div/div/div[1]/select");
    private By conditionformSaveButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div/div/div[2]/form/button");
    private By approvedButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div/div/div[2]/form/div/div/div/select");
    private By conditionApply = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/ul/li/ul/li/ul/li[1]/ul/li/div/div[2]/ul");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }
    
    public void clickNewWorkflow() {
    	driver.findElement(addNewWorkflowButton).click();
    }
    
    public void clickAddWorkflowButton() {
    	driver.findElement(addWorkflowButton).click();
    }

    public void clickAddCondition() {
    	driver.findElement(addConditionButton).click();
    }
    
    public void clickWorkflowForm() {
    	driver.findElement(addWorkflowButton).click();
    }
    
    public void clickWorkflowApprove() {
    	driver.findElement(approvedButton).click();
    }
    
    public void clickApproveForm() {
    	driver.findElement(approvedForm).isDisplayed();
    }
    
    public void clickApproveWorkflow() {
    	driver.findElement(conditionApply).click();
    }
    
    public void clickApprve() {
    	driver.findElement(approvedForm).click();
    }
    
    
}
