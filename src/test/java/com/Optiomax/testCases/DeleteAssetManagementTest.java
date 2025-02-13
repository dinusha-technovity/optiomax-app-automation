package com.Optiomax.testCases;

import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.DeleteAssetManagementPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeleteAssetManagementTest extends BasePage {
	DeleteAssetManagementPage deleteAssetManagementPage;

    @BeforeClass
    public void setUpTest() throws InterruptedException {
    	deleteAssetManagementPage = new DeleteAssetManagementPage(driver);
    	deleteAssetManagementPage = PageFactory.initElements(driver, DeleteAssetManagementPage.class);
    	deleteAssetManagementPage.login("sithum@gmail.com", "chamod1234");
        Thread.sleep(5000);
        driver.get("http://app.optiomax.com/dashboard/assets_management");
        Thread.sleep(5000);
    }
 
    @Test(priority = 6)
    public void deleteAssetWithSerialNumber() throws InterruptedException {
    	deleteAssetManagementPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteAssetManagementPage.enterSerialNumber("100200ABC");
    	deleteAssetManagementPage.clickDeleteButton();
        
        // Add assertions to verify asset deletion       
//        String successMessage = driver.findElement(By.xpath("")).getText();
//        Assert.assertTrue(successMessage.contains(""));
        
        driver.navigate().refresh();
    }    

    @Test(priority = 1)
    public void deleteAssetWithUnmatchedSerialNumber() throws InterruptedException {
    	deleteAssetManagementPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteAssetManagementPage.enterSerialNumber("abcd1234");
    	deleteAssetManagementPage.clickDeleteButton();
        
        // Add assertions to verify workflow is not deleted
        String errorMessage = driver.findElement(By.xpath("//div[@role='alert']")).getText(); 
        Assert.assertTrue(errorMessage.contains("Input does not match the serial number of the serial number"));
     
        deleteAssetManagementPage.clickCloseButton();
    }

    @Test(priority = 2)
    public void deleteAssetWithoutSerialNumber() throws InterruptedException {
    	
    	deleteAssetManagementPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteAssetManagementPage.clickDeleteButton();
//    	deleteAssetManagementPage.clickDeleteButton();
    
        // Add assertions to verify error or workflow is not deleted
        String errorMessage = driver.findElement(By.xpath("//div[@role='alert']")).getText(); 
        Assert.assertTrue(errorMessage.contains("Input does not match the serial number of the serial number"));
        
        deleteAssetManagementPage.clickCloseButton();     
    }

    @Test(priority = 3)
    public void deleteAssetAndCancel() throws InterruptedException {
    	deleteAssetManagementPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	
        // Add assertions to verify workflow is not deleted
//        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed();
//        Assert.assertFalse(isPopupDisplayed);
        
    	deleteAssetManagementPage.clickCloseButton(); 
    } 

    @Test(priority = 4)
    public void closeDialogAfterCorrectSerialNumber() throws InterruptedException {
    	deleteAssetManagementPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteAssetManagementPage.enterSerialNumber("100200ABC");
    	Thread.sleep(3000);
    	deleteAssetManagementPage.clickCloseButton();
        
        // Add assertions to verify dialog behavior
//        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
//        Assert.assertFalse(isPopupDisplayed);  
    }

    @Test(priority = 5)
    public void closeDialogAfterIncorrectSerialNumber() throws InterruptedException {
    	deleteAssetManagementPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteAssetManagementPage.enterSerialNumber("abcd1234");
    	deleteAssetManagementPage.clickCloseButton();
        
        // Add assertions to verify dialog behavior
//      boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
//      Assert.assertFalse(isPopupDisplayed);  

    }  
                
    @AfterClass
    public void tearDownTest() {
        driver.navigate().refresh();
        driver.quit();
    }
    
} 

