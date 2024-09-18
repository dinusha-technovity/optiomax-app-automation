package com.Optiomax.testCases;

import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.DeleteProcurementStaffPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class DeleteProcurementStaffTest extends BasePage {
    DeleteProcurementStaffPage deleteProcurementStaffPage;

    @BeforeClass
    public void setUpTest() throws InterruptedException {
    	
    	deleteProcurementStaffPage = new DeleteProcurementStaffPage(driver);
    	deleteProcurementStaffPage = PageFactory.initElements(driver,DeleteProcurementStaffPage.class);
    	deleteProcurementStaffPage.login("sithum@gmail.com", "chamod1234");
    	Thread.sleep(5000);
    	driver.get("http://app.optiomax.com/dashboard/staff");
    	Thread.sleep(5000);
    }
 
    @Test(priority = 1)
    public void deleteStaffMemberWithCorrectName() {
        deleteProcurementStaffPage.clickDeleteIcon();
        deleteProcurementStaffPage.enterStaffMemberName("");
        deleteProcurementStaffPage.clickDeleteButton();
        
        // Add assertions to verify workflow deletion  
//        String successMessage = driver.findElement(By.xpath("")).getText();
//        Assert.assertTrue(successMessage.contains(""));
        
        driver.navigate().refresh();
    }    

    @Test(priority = 2)
    public void deleteStaffMemberWithUnmatchedName() {
        deleteProcurementStaffPage.clickDeleteIcon();
        deleteProcurementStaffPage.enterStaffMemberName("");
        deleteProcurementStaffPage.clickDeleteButton();
        
        // Add assertions to verify staff member is not deleted
        String errorMessage = driver.findElement(By.xpath("")).getText(); 
        Assert.assertTrue(errorMessage.contains("Value does not match"));
        
        deleteProcurementStaffPage.clickCloseButton();
    }

    @Test(priority = 3)
    public void deleteStaffMemberWithoutName() throws InterruptedException {
    	
        deleteProcurementStaffPage.clickDeleteIcon();
        deleteProcurementStaffPage.clickDeleteButton();
        deleteProcurementStaffPage.clickDeleteButton();
    
        // Add assertions to verify error or staff member is not deleted
        String errorMessage = driver.findElement(By.xpath("")).getText(); 
        Assert.assertTrue(errorMessage.contains("Please enter the staff member name"));
        
        deleteProcurementStaffPage.clickCloseButton();     
    }

    @Test(priority = 4)
    public void deleteStaffMemberAndCancel() throws InterruptedException {
    	deleteProcurementStaffPage.clickDeleteIcon();
    	
        // Add assertions to verify staff member is not deleted
        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed();
        Assert.assertFalse(isPopupDisplayed);
        
        deleteProcurementStaffPage.clickCloseButton();
    } 

    @Test(priority = 5)
    public void closeDialogAfterCorrectStaffMemberName() throws InterruptedException {
        deleteProcurementStaffPage.clickDeleteIcon();
        deleteProcurementStaffPage.enterStaffMemberName("");
        deleteProcurementStaffPage.clickCloseButton();
        
        // Add assertions to verify dialog behavior
        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
        Assert.assertFalse(isPopupDisplayed);  
    }

    @Test(priority = 6)
    public void closeDialogAfterIncorrectStaffMemberName() throws InterruptedException {
        deleteProcurementStaffPage.clickDeleteIcon();
        deleteProcurementStaffPage.enterStaffMemberName("");
        deleteProcurementStaffPage.clickCloseButton();
        
        Thread.sleep(3000);
        
        // Add assertions to verify dialog behavior
        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
        Assert.assertFalse(isPopupDisplayed);
        
        Thread.sleep(3000);
    }  
                
    @AfterClass
    public void tearDownTest() {
        driver.navigate().refresh();
        driver.quit();
    }
} 


