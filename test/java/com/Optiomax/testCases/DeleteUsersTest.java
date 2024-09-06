package com.Optiomax.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.DeleteUsersPage;

public class DeleteUsersTest extends BasePage {

    DeleteUsersPage deleteUsersPage;

    @BeforeClass
    public void setUpPage() throws InterruptedException {
        deleteUsersPage = new DeleteUsersPage(driver);
        deleteUsersPage = PageFactory.initElements(driver, DeleteUsersPage.class);
        deleteUsersPage.login("chamoddushyantha2017@gmail.com", "chamod1234");
        Thread.sleep(5000);
        driver.get("http://app.optiomax.com/dashboard/users");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void testPositiveConfirmationOfUserDeletion() throws InterruptedException {
        deleteUsersPage.deleteUser("Ruvinya", "Ruvinya");
        // Add an assertion to verify user deletion
        //Assert.assertTrue(driver.findElements(By.xpath("//div[text()='Ruvinya']")).isEmpty(), "User was not deleted successfully.");
        //Assert.assertTrue(driver.findElements(By.xpath("")).isEmpty(), "User was not deleted successfully.");
        
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void testNegativeConfirmationOfUserDeletionIncorrectName() throws InterruptedException {
        deleteUsersPage.deleteUser("Ruvinya", "WrongName");
        // Add an assertion to verify user was not deleted
        //Assert.assertFalse(driver.findElements(By.xpath("//div[text()='Ruvinya']")).isEmpty(), "User was deleted unexpectedly.");
        
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void testNegativeConfirmationOfUserDeletionEmptyName() throws InterruptedException {
        deleteUsersPage.deleteUser("Ruvinya", "");
        // Add an assertion to verify user was not deleted
        //Assert.assertFalse(driver.findElements(By.xpath("//div[text()='Ruvinya']")).isEmpty(), "User was deleted unexpectedly.");
        
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void testNegativeConfirmationOfUserDeletionCancelDeletion() throws InterruptedException {
        deleteUsersPage.cancelDeletion("Ruvinya", "Ruvinya");
        // Add an assertion to verify user was not deleted
        //Assert.assertFalse(driver.findElements(By.xpath("//div[text()='Ruvinya']")).isEmpty(), "User was deleted unexpectedly.");
        
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void testNegativeConfirmationOfUserDeletionCaseSensitivity() throws InterruptedException {
        deleteUsersPage.deleteUser("Ruvinya", "ruvinya");
        // Add an assertion to verify user was not deleted
        //Assert.assertFalse(driver.findElements(By.xpath("//div[text()='Ruvinya']")).isEmpty(), "User was deleted unexpectedly.");
        
        Thread.sleep(5000);
    }

    @Test(priority = 6)
    public void testNegativeConfirmationOfUserDeletionIncorrectNameFormat() throws InterruptedException {
        deleteUsersPage.deleteUser("Ruvinya", "Ruv1nya");
        // Add an assertion to verify user was not deleted
        //Assert.assertFalse(driver.findElements(By.xpath("//div[text()='Ruvinya']")).isEmpty(), "User was deleted unexpectedly.");
        
        Thread.sleep(5000);
    }
}

