package com.Optiomax.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Optiomax.pageObjetcs.BasePage;
import com.Optiomax.pageObjetcs.DeleteWorkflowPage;

public class DeleteWorkflowTest extends BasePage {
    DeleteWorkflowPage deleteWorkflowPage;

    @BeforeClass
    public void setUpTest() throws InterruptedException {
        deleteWorkflowPage = new DeleteWorkflowPage(driver);
        deleteWorkflowPage = PageFactory.initElements(driver, DeleteWorkflowPage.class);
        deleteWorkflowPage.login("chamoddushyantha2017@gmail.com", "chamod1234");
        Thread.sleep(5000);
        driver.get("http://app.optiomax.com/dashboard/workflow");
        Thread.sleep(5000);
    }
 
    @Test(priority = 1)
    public void deleteWorkflowWithCorrectName() {
        deleteWorkflowPage.clickDeleteIcon();
        deleteWorkflowPage.enterWorkflowName("Second Workflow");
        deleteWorkflowPage.clickDeleteButton();
        
        // Add assertions to verify workflow deletion
//        Alert alert = driver.switchTo().alert();
//        Assert.assertTrue(alert.getText().contains("Workflow deleted successfully"));
//        alert.accept();
        
//        String successMessage = driver.findElement(By.xpath("")).getText();
//        Assert.assertTrue(successMessage.contains(""));
        
        driver.navigate().refresh();
    }    

    @Test(priority = 2)
    public void deleteWorkflowWithUnmatchedName() {
        deleteWorkflowPage.clickDeleteIcon();
        deleteWorkflowPage.enterWorkflowName("Incorrect Workflow");
        deleteWorkflowPage.clickDeleteButton();
        
        // Add assertions to verify workflow is not deleted
        String errorMessage = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[3]/form/div/div/div")).getText(); 
        Assert.assertTrue(errorMessage.contains("Value does not match"));
        
        deleteWorkflowPage.clickCloseButton();
    }

    @Test(priority = 3)
    public void deleteWorkflowWithoutName() throws InterruptedException {
    	
        deleteWorkflowPage.clickDeleteIcon();
        deleteWorkflowPage.clickDeleteButton();
        deleteWorkflowPage.clickDeleteButton();
              
//        Actions act = new Actions(driver);
//        WebElement element = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[3]/form/button"));
//        act.doubleClick(element).perform();
    
        // Add assertions to verify error or workflow is not deleted
        String errorMessage = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[3]/form/div/div/div")).getText(); 
        Assert.assertTrue(errorMessage.contains("Please enter the workflow name"));
        
        deleteWorkflowPage.clickCloseButton();     
    }

    @Test(priority = 4)
    public void deleteWorkflowAndCancel() throws InterruptedException {
    	deleteWorkflowPage.clickDeleteIcon();
        // Add assertions to verify workflow is not deleted
//        boolean isPopupDisplayed = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]")).isDisplayed();
//        Assert.assertFalse(isPopupDisplayed);
        
        deleteWorkflowPage.clickCloseButton(); 

    } 

    @Test(priority = 5)
    public void closeDialogAfterCorrectName() throws InterruptedException {
        deleteWorkflowPage.clickDeleteIcon();
        deleteWorkflowPage.enterWorkflowName("First Workflow");
        deleteWorkflowPage.clickCloseButton();
        
        // Add assertions to verify dialog behavior
//        boolean isPopupDisplayed = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div[2]")).isDisplayed(); 
//        Assert.assertFalse(isPopupDisplayed);  
    }

    @Test(priority = 6)
    public void closeDialogAfterIncorrectName() throws InterruptedException {
        deleteWorkflowPage.clickDeleteIcon();
        deleteWorkflowPage.enterWorkflowName("Incorrect Workflow");
        deleteWorkflowPage.clickCloseButton();
        
        Thread.sleep(3000);
        
        // Add assertions to verify dialog behavior
//        boolean isPopupDisplayed = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]")).isDisplayed(); 
//        Assert.assertFalse(isPopupDisplayed);
        
        Thread.sleep(3000);
    }  
                
    @AfterClass
    public void tearDownTest() {
        driver.navigate().refresh();
        driver.quit();
    }
} 

