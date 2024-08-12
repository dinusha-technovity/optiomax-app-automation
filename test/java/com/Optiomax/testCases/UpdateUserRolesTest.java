package com.Optiomax.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.BasePage;
import com.Optiomax.pageObjetcs.UpdateUserRolesPage;

public class UpdateUserRolesTest extends BasePage {
    private WebDriver driver;
    private UpdateUserRolesPage updateUserRolesPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        updateUserRolesPage = new UpdateUserRolesPage(driver);
		updateUserRolesPage = PageFactory.initElements(driver, UpdateUserRolesPage.class);
		updateUserRolesPage.login("chamoddushyantha2017@gmail.com", "UMwI4u3w");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/Roles"); 
		Thread.sleep(5000); 
    }
 
    @Test(priority = 1)
    public void verifyUpdatingExistingUserRole() {
        updateUserRolesPage.clickUpdateButton("existingRole");
        updateUserRolesPage.setRoleName("Updated Role Name");
        updateUserRolesPage.setRoleDescription("Updated Role Description");
        updateUserRolesPage.clickSaveButton();
        // Add assertions to verify the role was updated
    } 

//    @Test(priority = 2)
//    public void verifyUpdatingUserRoleWithoutPermission() {
//        // Implement logic to log in with a user without permissions
//    	
//        updateUserRolesPage.clickUpdateButton("restrictedRole");
//        updateUserRolesPage.setRoleName("Unauthorized Update");
//        updateUserRolesPage.clickSaveButton();
//        // Add assertions to verify the update was not allowed
//    }

    @Test(priority = 3)
    public void verifySuccessfulRoleNameUpdate() {
        updateUserRolesPage.clickUpdateButton("RoleToUpdate");
        updateUserRolesPage.setRoleName("New Role Name");
        updateUserRolesPage.clickSaveButton();
        // Add assertions to verify the role name was updated
    }

    @Test(priority = 4)
    public void verifySuccessfulRoleDescriptionUpdate() {
        updateUserRolesPage.clickUpdateButton("roleToUpdate");
        updateUserRolesPage.setRoleDescription("New Role Description");
        updateUserRolesPage.clickSaveButton();
        // Add assertions to verify the role description was updated
    }

    @Test(priority = 5)
    public void verifyEmptyRoleNameUpdate() {
        updateUserRolesPage.clickUpdateButton("roleToUpdate");
        updateUserRolesPage.setRoleName("");
        updateUserRolesPage.clickSaveButton();
        //Assert.assertTrue(updateUserRolesPage.isRoleNameErrorDisplayed());
        Assert.assertEquals(updateUserRolesPage.getRoleNameError(), "Role name cannot be empty");
    }

    @Test(priority = 6)
    public void verifyDuplicateRoleNameUpdate() {
        updateUserRolesPage.clickUpdateButton("roleToUpdate");
        updateUserRolesPage.setRoleName("existingRoleName");
        updateUserRolesPage.clickSaveButton();
        //Assert.assertTrue(updateUserRolesPage.isRoleNameErrorDisplayed());
        
        Assert.assertEquals(updateUserRolesPage.getRoleNameError(), "Role name already exists"); 
    } 
    
    @Test(priority =7)
    public void DuplicateRoleNameUpdate() {
    	updateUserRolesPage.clickUpdateButton("");
    	updateUserRolesPage.setRoleName("Update Role");
    	updateUserRolesPage.clickSaveButton();
    }
    
} 

