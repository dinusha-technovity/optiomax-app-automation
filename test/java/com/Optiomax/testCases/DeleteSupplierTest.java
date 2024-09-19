package com.Optiomax.testCases;

import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.DeleteSupplierPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DeleteSupplierTest extends BasePage {
    DeleteSupplierPage deleteSupplierPage;

    @BeforeClass
    public void setUpTest() throws InterruptedException {
        deleteSupplierPage = new DeleteSupplierPage(driver);
        deleteSupplierPage = PageFactory.initElements(driver, DeleteSupplierPage.class);
        deleteSupplierPage.login("sithum@gmail.com", "chamod1234");
        Thread.sleep(5000);
        driver.get("http://app.optiomax.com/dashboard/supplier");
        Thread.sleep(5000);
    }
 
    @Test(priority = 6)
    public void deleteSupplierWithCorrectName() {
        deleteSupplierPage.clickDeleteIcon();
        deleteSupplierPage.enterSupplierName("John Lum");
        deleteSupplierPage.clickDeleteButton();
        
        // Add assertions to verify supplier is deleted
        String successMessage = driver.findElement(By.xpath("")).getText();
        Assert.assertTrue(successMessage.contains(""));
        
        driver.navigate().refresh();
    }    

    @Test(priority = 1)
    public void deleteSupplierWithUnmatchedName() {
        deleteSupplierPage.clickDeleteIcon();
        deleteSupplierPage.enterSupplierName("Unmatched Supplier Name");
        deleteSupplierPage.clickDeleteButton();
        
        // Add assertions to verify supplier is not deleted
        String errorMessage = driver.findElement(By.xpath("")).getText(); 
        Assert.assertTrue(errorMessage.contains("Value does not match"));
        
        deleteSupplierPage.clickCloseButton();
    }

    @Test(priority = 2)
    public void deleteSupplierWithoutName() throws InterruptedException {
    	
    	deleteSupplierPage.clickDeleteIcon();
    	deleteSupplierPage.clickDeleteButton();
    	deleteSupplierPage.clickDeleteButton();
    
        // Add assertions to verify error or supplier is not deleted
        String errorMessage = driver.findElement(By.xpath("")).getText(); 
        Assert.assertTrue(errorMessage.contains("Please enter the supplier name"));
        
        deleteSupplierPage.clickCloseButton();     
    }

    @Test(priority = 3)
    public void deleteSupplierAndCancel() throws InterruptedException {
    	deleteSupplierPage.clickDeleteIcon();
    	
        // Add assertions to verify workflow is not deleted
        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed();
        Assert.assertFalse(isPopupDisplayed);
        
    	deleteSupplierPage.clickCloseButton();

    } 

    @Test(priority = 4)
    public void closeDialogAfterCorrectName() throws InterruptedException {

    	deleteSupplierPage.clickDeleteIcon();
        deleteSupplierPage.enterSupplierName("");
        deleteSupplierPage.clickCloseButton();
    	
        // Add assertions to verify dialog behavior
        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
        Assert.assertFalse(isPopupDisplayed);
        
        deleteSupplierPage.clickCloseButton();
    }

    @Test(priority = 5)
    public void closeDialogAfterIncorrectName() throws InterruptedException {
        deleteSupplierPage.clickDeleteIcon();
        deleteSupplierPage.enterSupplierName("");
        deleteSupplierPage.clickCloseButton();
        
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


