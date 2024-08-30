package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.AddUserRolesPage;
import com.Optiomax.pageObjetcs.BasePage;

public class AddUserRolesTest extends BasePage {

    private AddUserRolesPage addUserRolesPage;

    @BeforeClass
    public void setupPage() throws InterruptedException {
        addUserRolesPage = new AddUserRolesPage(driver);
        addUserRolesPage = PageFactory.initElements(driver, AddUserRolesPage.class);
        addUserRolesPage.login("chamoddushyantha2017@gmail.com", "chamod1234");
        Thread.sleep(5000);
        driver.get("http://app.optiomax.com/dashboard/Roles");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void verifyAddNewUserRoleButtonFunctionality() throws InterruptedException {
        addUserRolesPage.clickAddNewUserRoleButton();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]")).isDisplayed(), "Role Name input field is not displayed");
        addUserRolesPage.clickCloseButton();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void testAddingNewUserRoleWithValidInputs() throws InterruptedException {
        addUserRolesPage.clickAddNewUserRoleButton();
        addUserRolesPage.enterRoleName("Test Role");
        addUserRolesPage.enterRoleDescription("Test Description");
        addUserRolesPage.clickCreateButton();
        Thread.sleep(5000);
        //Assert.assertTrue(addUserRolesPage.isRolePresent("Test Role"), "New role was not added successfully");
        addUserRolesPage.clickCloseButton();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void testAddingNewUserRoleWithInvalidInputs() throws InterruptedException {
    	Thread.sleep(3000);
        addUserRolesPage.clickAddNewUserRoleButton();
        addUserRolesPage.enterRoleName("");
        addUserRolesPage.enterRoleDescription("");
        Thread.sleep(3000);
        addUserRolesPage.clickCreateButton();
        Thread.sleep(3000);
        //Assert.assertEquals(addUserRolesPage.getErrorMessage(), "Role name is required", "Error message is not displayed correctly");
        driver.navigate().refresh();
        Thread.sleep(3000);
        
    }

//    @Test(priority = 4)
//    public void verifyErrorHandlingWhenAddingRoleWithoutRequiredFields() throws InterruptedException {
//        addUserRolesPage.clickAddNewUserRoleButton();
//        addUserRolesPage.enterRoleName("");
//        addUserRolesPage.enterRoleDescription("Test Description");
//        addUserRolesPage.clickCreateButton();
//        //Assert.assertEquals(addUserRolesPage.getErrorMessage(), "Role name is required", "Error message is not displayed correctly");
//        driver.navigate().refresh();
//        Thread.sleep(5000);
//    }

//    @Test(priority = 5)
//    public void testAddingNewUserRoleWithDuplicateRoleName() throws InterruptedException {
//        addUserRolesPage.clickAddNewUserRoleButton();
//        addUserRolesPage.enterRoleName("Duplicate Role");
//        addUserRolesPage.enterRoleDescription("Test Description");
//        addUserRolesPage.clickCreateButton();
//        Thread.sleep(5000);
//        driver.navigate().refresh();     
//        Thread.sleep(5000);
//
//        // Attempt to add duplicate role
//        addUserRolesPage.clickAddNewUserRoleButton();
//        addUserRolesPage.enterRoleName("Duplicate Role");
//        addUserRolesPage.enterRoleDescription("Test Description");
//        addUserRolesPage.clickCreateButton();
//        Thread.sleep(5000);        
//        //Assert.assertEquals(addUserRolesPage.getErrorMessage(), "Role name already exists", "Duplicate role name error message is not displayed correctly");
//        driver.navigate().refresh();
//        Thread.sleep(5000);
//    }

//    @Test(priority = 6)
//    public void testAddingNewUserRoleWithoutNecessaryPermissions() {
//        // Assuming the method isRolePresent is modified to check based on user permissions
//        addUserRolesPage.clickAddNewUserRoleButton();
//        addUserRolesPage.enterRoleName("NoPermissionRole");
//        addUserRolesPage.enterRoleDescription("Test Description");
//        addUserRolesPage.clickCreateButton();
//        //Assert.assertEquals(addUserRolesPage.getErrorMessage(), "You do not have permissions to add a new role", "Permission error message is not displayed correctly");
//    }

//    @Test(priority = 7)
//    public void verifyAddingUserRoleWithSpecialCharactersInName() throws InterruptedException {
//        addUserRolesPage.clickAddNewUserRoleButton();
//        addUserRolesPage.enterRoleName("Special@Role#");
//        addUserRolesPage.enterRoleDescription("Test Description");
//        addUserRolesPage.clickCreateButton();
//        addUserRolesPage.clickNextButton();
//        Thread.sleep(5000);
//        Assert.assertTrue(addUserRolesPage.isRolePresent("Special@Role#"), "Role with special characters was not added successfully");
//        
//    }
    
}


