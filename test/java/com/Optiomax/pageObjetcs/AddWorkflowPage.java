package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddWorkflowPage extends BasePage {
	
	// Web elements for sign in page
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    // Web elements for Add Workflow page
    private By addNewWorkflowButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button");
    private By nameField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input");
    private By descriptionField = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[2]/textarea");
    private By saveButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button");
    private By cancelButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button");
    private By errorMessage = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]");
    private By workflowList = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div");
    private By workflowStatus = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[3]/label/label/div");
    private By addWorkflowModal = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]");
    private By statusToggle = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/label/label/div");
    
    public AddWorkflowPage (WebDriver driver) {
        this.driver = driver;
    } 

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click(); 
        driver.findElement(signInButton).click();
    }
    
    public void clickAddNewWorkflowButton() {
        driver.findElement(addNewWorkflowButton).click();
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }
    
    public void clickStausToggle() {
    	driver.findElement(statusToggle).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    
    public void addNewWorkflow(String name, String description) {
        clickAddNewWorkflowButton();
        enterName(name);
        enterDescription(description);
        clickSaveButton();
    }

    public void addNewWorkflowWithoutActivatingStatus(String name, String description) {
        clickAddNewWorkflowButton();
        enterName(name);
        enterDescription(description);
        
        WebElement statusToggle = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/label/label/div"));
        if (statusToggle.isSelected()) {
        	statusToggle.click();
        }
        clickSaveButton();
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

    public boolean isWorkflowActive(String name) {
        List<WebElement> workflows = driver.findElements(workflowList);
        for (WebElement workflow : workflows) {
            if (workflow.getText().contains(name)) {
                WebElement statusElement = workflow.findElement(workflowStatus);
                return statusElement.getText().equalsIgnoreCase("Active");
            }
        }
        return false;
    }
 
    public void toggleWorkflowStatus(String name) {
        List<WebElement> workflows = driver.findElements(workflowList);
        for (WebElement workflow : workflows) {
            if (workflow.getText().contains(name)) {
                WebElement statusElement = workflow.findElement(workflowStatus);
                statusElement.click();
                break;
            }
        }
    }

    public boolean isAddWorkflowModalOpen() {
        return driver.findElement(addWorkflowModal).isDisplayed();
    }
}
