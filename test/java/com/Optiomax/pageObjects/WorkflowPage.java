package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class WorkflowPage {

    WebDriver driver;

    public WorkflowPage(WebDriver driver) {
        this.driver = driver;
    }

    // Web elements for sign in page
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");
    
    // Web elements for workflow page  
    By addNewWorkflowBtn = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button");
    By updateWorkflowBtn = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div[3]/div[2]/div/a[1]");
    By deleteWorkflowBtn = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div[3]/div[2]/div/a[2]");
    By searchInput = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[1]/div/div/input");
    By exportCSVBtn = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/button[1]");
    By filterBtn = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/button[2]");
    By gridViewBtn = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/div[2]/button[1]");
    By listViewBtn = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/div[2]/button[2]");
    By workflowItems = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div");
    By addNewWorkflowCloseBtn = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button");
    By updateWorkflowCloseBtn = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button");
    By deleteWorkflowCloseBtn = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button");
    By errorMessage = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/p");
  
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    // Methods
    public void clickAddNewWorkflow() {
        driver.findElement(addNewWorkflowBtn).click();
    }

    public void clickUpdateWorkflow() {
        driver.findElement(updateWorkflowBtn).click();
    }

    public void clickDeleteWorkflow() {
        driver.findElement(deleteWorkflowBtn).click();
    }

    public void searchWorkflow(String name) {
        WebElement searchBox = driver.findElement(searchInput);
        searchBox.clear();
        searchBox.sendKeys(name);
    }

    public void clickExportCSV() {
        driver.findElement(exportCSVBtn).click();
    }

    public void clickFilter() {
        driver.findElement(filterBtn).click();
    }

    public void clickGridView() {
        driver.findElement(gridViewBtn).click();
    }

    public void clickListView() {
        driver.findElement(listViewBtn).click();
    }

    public List<WebElement> getWorkflowItems() {
        return driver.findElements(workflowItems);
    }
    
    public void clickAddNewWorkflowCloseBtn() {
    	driver.findElement(addNewWorkflowCloseBtn).click();
    }
    
    public void clickUpdateWorkflowCloseBtn() {
        driver.findElement(updateWorkflowCloseBtn).click();
    }
    
    public void clickDeleteWorkflowCloseBtn() {
    	driver.findElement(deleteWorkflowCloseBtn).click();
    }
    
    
}


