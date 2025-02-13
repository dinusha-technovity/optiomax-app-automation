package com.Optiomax.testCases;

import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.DeleteAssetsPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeleteAssetsTest extends BasePage {
	
	DeleteAssetsPage deleteAssetsPage;

    @BeforeClass
    public void setUpTest() throws InterruptedException {
    	deleteAssetsPage = new DeleteAssetsPage(driver);
    	deleteAssetsPage = PageFactory.initElements(driver, DeleteAssetsPage.class);
    	deleteAssetsPage.login("sithum@gmail.com", "chamod1234");
        Thread.sleep(5000);
        driver.get("http://app.optiomax.com/dashboard/assets_management");
        Thread.sleep(5000);
    }
 
    @Test(priority = 6)
    public void deleteAssetWithAssetName() throws InterruptedException {
    	deleteAssetsPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteAssetsPage.enterAssetName("");
    	deleteAssetsPage.clickDelete();
        
        // Add assertions to verify asset deletion       
        String successMessage = driver.findElement(By.xpath("")).getText();
        Assert.assertTrue(successMessage.contains("asset deleted successfully"));
        
        driver.navigate().refresh();
    }    

    @Test(priority = 1)
    public void deleteAssetwithUnmatchedAssetName() throws InterruptedException {
    	deleteAssetsPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteAssetsPage.enterAssetName("abcd");
    	deleteAssetsPage.clickDelete();
        
        // Add assertions to verify asset is not deleted
        String errorMessage = driver.findElement(By.xpath("//div[@role='alert']")).getText(); 
        Assert.assertTrue(errorMessage.contains("Input does not match the asset name"));
     
        deleteAssetsPage.clickClose();
    }

    @Test(priority = 2)
    public void deleteAssetWithoutAssetName() throws InterruptedException {
    	
    	deleteAssetsPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteAssetsPage.clickDelete();
    	
    	// Add assertion to verify asset is not deleted
        String errorMessage = driver.findElement(By.xpath("//div[@role='alert']")).getText(); 
        Assert.assertTrue(errorMessage.contains("name is required"));
        
        deleteAssetsPage.clickClose();    
    }

    @Test(priority = 3)
    public void deleteAssetAndCancel() throws InterruptedException {
    	deleteAssetsPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	
        // Add assertions to verify asset is not deleted
        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed();
        Assert.assertFalse(isPopupDisplayed);
        
    	deleteAssetsPage.clickClose();
    } 

    @Test(priority = 4)
    public void closeDialogAfterCorrectAssetName() throws InterruptedException {
    	deleteAssetsPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteAssetsPage.enterAssetName("");
    	deleteAssetsPage.clickDelete();
        
        // Add assertions to verify dialog behavior
        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
        Assert.assertFalse(isPopupDisplayed);  
    }

    @Test(priority = 5)
    public void closeDialogAfterIncorrectAssetName() throws InterruptedException {
    	deleteAssetsPage.clickDeleteIcon();
    	Thread.sleep(3000);
    	deleteAssetsPage.enterAssetName("test");
    	deleteAssetsPage.clickDelete();
        
        // Add assertions to verify dialog behavior
    	boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
    	Assert.assertFalse(isPopupDisplayed);  

    }  
                
    @AfterClass
    public void tearDownTest() {
        driver.navigate().refresh();
        driver.quit();
    }
    
} 


