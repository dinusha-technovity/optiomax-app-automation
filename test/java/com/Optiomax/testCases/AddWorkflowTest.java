package com.Optiomax.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.AddWorkflowPage;
import com.Optiomax.pageObjetcs.BasePage;

public class AddWorkflowTest extends BasePage {

    private AddWorkflowPage addWorkflowPage;

    @BeforeClass 
    public void setUpPage() throws InterruptedException {
        addWorkflowPage = new AddWorkflowPage(driver);
        addWorkflowPage = PageFactory.initElements(driver, AddWorkflowPage.class);
        addWorkflowPage.login("chamoddushyantha2017@gmail.com", "UMwI4u3w");
        Thread.sleep(5000);
        driver.get("http://app.optiomax.com/dashboard/workflow");
        Thread.sleep(5000);
    }
  
    @Test(priority = 1) 
    public void addNewWorkflowWithValidData() throws InterruptedException {
        addWorkflowPage.addNewWorkflow("New Workflow", "New Workflow Description");
        Thread.sleep(3000);
        Assert.assertTrue(addWorkflowPage.isWorkflowPresent("New Workflow"), "The workflow should be present in the list.");
    	Thread.sleep(3000);
    }
 
    @Test(priority = 2)
    public void verifyErrorHandlingForRequiredFields() throws InterruptedException {
        addWorkflowPage.clickAddNewWorkflowButton();
        addWorkflowPage.clickSaveButton();
        Assert.assertTrue(addWorkflowPage.getErrorMessage().contains("required"), "Error message for required fields not displayed.");
        addWorkflowPage.clickCancelButton();
    	Thread.sleep(3000);
    }


    @Test(priority = 3)
    public void verifyAddingWorkflowWithDuplicateData() throws InterruptedException {
        addWorkflowPage.addNewWorkflow("Duplicate Workflow", "Description");
        addWorkflowPage.addNewWorkflow("Duplicate Workflow", "Description");
      //  Assert.assertTrue(addWorkflowPage.getErrorMessage().contains("duplicate"), "Identical data error message not displayed.");
        addWorkflowPage.clickCancelButton();
    	Thread.sleep(3000);
    }
    
    @Test(priority = 4)
    public void verifyAddingWorkflowWithEmptyDescription() throws InterruptedException {
        addWorkflowPage.addNewWorkflow("Workflow", "");
        Assert.assertTrue(addWorkflowPage.getErrorMessage().contains("required"), "Error message for required fields not displayed.");
        addWorkflowPage.clickCancelButton();
    	Thread.sleep(3000);
    }
    
    @Test(priority = 5)
    public void verifyAddingWorkflowWithEmptyWorkflowName() throws InterruptedException {
        addWorkflowPage.addNewWorkflow("", "Description");
        Assert.assertTrue(addWorkflowPage.getErrorMessage().contains("required"), "Error message for required fields not displayed.");
        addWorkflowPage.clickCancelButton();
    	Thread.sleep(3000); 
    }

//    @Test(priority = 6)
//    public void addNewWorkflowWithoutActivatingStatus() throws InterruptedException {
//        addWorkflowPage.addNewWorkflow("Workflow", "Workflow Description");
//        Assert.assertFalse(addWorkflowPage.isWorkflowActive("Inactive Workflow"), "Workflow should be inactive.");
//        Thread.sleep(3000);
//        addWorkflowPage.clickCancelButton();
//    	Thread.sleep(3000);
//    } 
 
//    @Test(priority = 7)
//    public void toggleWorkflowStatus() {
//        addWorkflowPage.addNewWorkflow("Toggle Status Workflow", "Description");
//        addWorkflowPage.toggleWorkflowStatus("Toggle Status Workflow");
//        Assert.assertTrue(addWorkflowPage.isWorkflowActive("Toggle Status Workflow"), "Workflow status should be active.");
//        addWorkflowPage.toggleWorkflowStatus("Toggle Status Workflow");
//        Assert.assertFalse(addWorkflowPage.isWorkflowActive("Toggle Status Workflow"), "Workflow status should be inactive.");
//    }   

    @Test(priority = 8)
    public void addNewWorkflowWithSpecialCharacters() throws InterruptedException {
    	addWorkflowPage.addNewWorkflow("Special@#Work&&flow", "Special@#Descri&&ption");
        Thread.sleep(3000);
        Assert.assertTrue(addWorkflowPage.isWorkflowPresent("Special@#Work&&flow"), "Workflow with special characters should be present.");
    	Thread.sleep(3000);
    }

    @Test(priority = 9)
    public void openAndCloseAddWorkflowModal() {
        addWorkflowPage.clickAddNewWorkflowButton();
        addWorkflowPage.clickCancelButton();
    }
    
}

