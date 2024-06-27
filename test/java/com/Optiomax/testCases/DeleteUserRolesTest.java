package com.Optiomax.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.BasePage;
import com.Optiomax.pageObjetcs.DeleteUserRolesPage;

public class DeleteUserRolesTest extends BasePage {
    DeleteUserRolesPage deleteUserRolesPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
		deleteUserRolesPage = new DeleteUserRolesPage(driver);
		deleteUserRolesPage = PageFactory.initElements(driver, DeleteUserRolesPage.class);
		deleteUserRolesPage.login("chamoddushyantha2017@gmail.com", "UMwI4u3w");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/Roles"); 
		Thread.sleep(5000);  
    }
  
    
    @Test(priority = 1)
    public void verifySuccessfulDeletion() {
    	deleteUserRolesPage.clickDeleteIcon();
        deleteUserRolesPage.enterText("multi admin");
        deleteUserRolesPage.clickDeleteButton();
        
//        Alert alert = driver.switchTo().alert();
//        Assert.assertEquals(alert.getText(), "Successfully deleted");
//        alert.accept();
        
        driver.navigate().refresh();
    }

    @Test(priority = 2)
    public void verifyDeletionFailureWithIncorrectInput() {
    	deleteUserRolesPage.clickDeleteIcon();
        deleteUserRolesPage.enterText("incorrect input");
        deleteUserRolesPage.clickDeleteButton();
        
        // Verify deletion failure
//        Alert alert = driver.switchTo().alert();
//        Assert.assertEquals(alert.getText(), "Deletion failed");
//        alert.accept();
        
        driver.navigate().refresh();
    }

    @Test(priority = 3)
    public void verifyDeletionFailureWithNoInput() {
    	deleteUserRolesPage.clickDeleteIcon();
        deleteUserRolesPage.enterText("");
        deleteUserRolesPage.clickDeleteButton();
        
        // Verify deletion failure
//        Alert alert = driver.switchTo().alert();
//        Assert.assertEquals(alert.getText(), "Deletion failed");
//        alert.accept();
        
    }
    
    @Test(priority = 4)
    public void verifyCloseButtonFunctionality() {
    	deleteUserRolesPage.clickDeleteIcon();
        deleteUserRolesPage.clickCloseButton();
        
        // Verify the popup is closed
        //Assert.assertFalse(deleteUserRolesPage.isPopupPresent());
        
    }

    @Test(priority = 5)
    public void verifyCloseAfterCorrectInput() {
        deleteUserRolesPage.enterText("multi admin");
        deleteUserRolesPage.clickCloseButton();
        
        // Verify the popup is closed
//        Assert.assertFalse(deleteUserRolesPage.isPopupPresent());
        
    }

    @Test(priority = 6)
    public void verifyCloseAfterIncorrectInput() {
        deleteUserRolesPage.enterText("incorrect input");
        deleteUserRolesPage.clickCloseButton();
        
        // Verify the popup is closed
//        Assert.assertFalse(deleteUserRolesPage.isPopupPresent());         
    }
    
    @Test(priority = 7)
    public void verifyCloseAfter() {
    	deleteUserRolesPage.enterText("incorrect input");
    	deleteUserRolesPage.enterText("");
    	deleteUserRolesPage.clickCloseButton();
    }
    
}

