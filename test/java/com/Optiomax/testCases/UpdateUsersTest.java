package com.Optiomax.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.BasePage;
import com.Optiomax.pageObjetcs.UpdateUsersPage;

public class UpdateUsersTest extends BasePage {

    private UpdateUsersPage updateUsersPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        updateUsersPage = new UpdateUsersPage(driver);
        updateUsersPage = PageFactory.initElements(driver, UpdateUsersPage.class);
        updateUsersPage.login("chamoddushyantha2017@gmail.com", "chamod1234");
        Thread.sleep(5000);
        driver.get("http://app.optiomax.com/dashboard/workflow");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void verifyUserInfoCanBeUpdated() {
        updateUsersPage.setUserName("TestUser");
        updateUsersPage.setEmail("testuser@example.com");
        updateUsersPage.setName("Test User");
        updateUsersPage.setPhoneNumber("1234567890");
        updateUsersPage.setAddress("123 Test Street");
        updateUsersPage.setDescription("This is a test user.");
        updateUsersPage.selectRole("new admin");
        updateUsersPage.updateUser();
        Assert.assertTrue(driver.getPageSource().contains("User updated successfully"));
    }

    @Test(priority = 2)
    public void testSubmittingEmptyFields() {
        updateUsersPage.setUserName("");
        updateUsersPage.setEmail("");
        updateUsersPage.setName("");
        updateUsersPage.setPhoneNumber("");
        updateUsersPage.setAddress("");
        updateUsersPage.setDescription("");
        updateUsersPage.updateUser();
        Assert.assertTrue(driver.getPageSource().contains("Please fill out this field"));
    }

    @Test(priority = 3)
    public void testUploadingImage() {
        updateUsersPage.uploadImage("C:\\path\\to\\image.png");
        Assert.assertTrue(driver.getPageSource().contains("Image uploaded successfully"));
    }

    @Test(priority = 4)
    public void verifyRolesCanBeAdded() {
        updateUsersPage.selectRole("new admin");
        updateUsersPage.updateUser();
        Assert.assertTrue(driver.getPageSource().contains("Role added successfully"));
    }

    @Test(priority = 5)
    public void attemptToUpdateInvalidEmail() {
        updateUsersPage.setEmail("invalid-email");
        updateUsersPage.updateUser();
        Assert.assertTrue(driver.getPageSource().contains("Invalid email format"));
    }

    @Test(priority = 6)
    public void attemptToInputSpecialCharactersInPhoneNumber() {
        updateUsersPage.setPhoneNumber("123-abc-7890");
        updateUsersPage.updateUser();
        Assert.assertTrue(driver.getPageSource().contains("Invalid phone number format"));
    }

    @Test(priority = 7)
    public void testAssigningMultipleRoles() {
        updateUsersPage.selectRole("new admin");
        updateUsersPage.selectRole("multi admin");
        updateUsersPage.updateUser();
        Assert.assertTrue(driver.getPageSource().contains("Roles updated successfully"));
    }

    @Test(priority = 8)
    public void attemptToInputLongDescription() {
        String longDescription = new String(new char[501]).replace('\0', 'a'); 
        updateUsersPage.setDescription(longDescription);
        updateUsersPage.updateUser();
        Assert.assertTrue(driver.getPageSource().contains("Description too long"));
    }

    @Test(priority = 9)
    public void attemptToUploadInvalidImageType() {
        updateUsersPage.uploadImage("C:\\path\\to\\image.bmp");
        Assert.assertTrue(driver.getPageSource().contains("Unsupported file type"));
    }

    @Test(priority = 10)
    public void uploadImageWithMaxResolution() {
        updateUsersPage.uploadImage("C:\\path\\to\\high-res-image.png");
        Assert.assertTrue(driver.getPageSource().contains("Image uploaded successfully"));
    }

    @Test(priority = 11)
    public void attemptToUploadExceedingMaxFileSize() {
        updateUsersPage.uploadImage("C:\\path\\to\\large-image.png");
        Assert.assertTrue(driver.getPageSource().contains("File size exceeds limit"));
    }

    @Test(priority = 12)
    public void testDragAndDropImageUpload() {
        updateUsersPage.dragAndDropImage("C:\\path\\to\\image.png");
        Assert.assertTrue(driver.getPageSource().contains("Image uploaded successfully"));
    }
}
