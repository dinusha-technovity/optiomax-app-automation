package com.Optiomax.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.ProfileMenuPage;

public class ProfileMenuTest extends BasePage {
    private WebDriver driver;
    private ProfileMenuPage profileMenuPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        super.setup();
        this.driver = super.driver;
        profileMenuPage = new ProfileMenuPage(driver);
        profileMenuPage.signIn("chamoddushyantha2017@gmail.com", "chamod1234");
        Thread.sleep(5000);
        profileMenuPage.openSidebar();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void testProfileImageFunctionality() {
        Assert.assertTrue(profileMenuPage.isProfileImageDisplayed(), "Profile image is not displayed.");
    }

    @Test(priority = 2)
    public void testAccessMyProfile() {
        profileMenuPage.clickProfileImage();
        profileMenuPage.clickMyProfile();
        // Add assertions to verify navigation to My Profile page
    }

    @Test(priority = 3)
    public void testAccessAccountSettings() {
        profileMenuPage.clickProfileImage();
        profileMenuPage.clickAccountSettings();
        // Add assertions to verify navigation to Account Settings page
    }

    @Test(priority = 4)
    public void testAccessMyLikes() {
        profileMenuPage.clickProfileImage();
        profileMenuPage.clickMyLikes();
        // Add assertions to verify navigation to My Likes page
    }

    @Test(priority = 5)
    public void testAccessCollections() {
        profileMenuPage.clickProfileImage();
        profileMenuPage.clickCollections();
        // Add assertions to verify navigation to Collections page
    }

    @Test(priority = 6)
    public void testSignOut() {
        profileMenuPage.clickProfileImage();
        profileMenuPage.clickSignOut();
        // Add assertions to verify successful sign out
    }

    @Test(priority = 7)
    public void testAccessDropdownMenuWithoutUserInteraction() {
        // Add assertions to verify that the dropdown menu does not open without user interaction
    }

    @Test(priority = 8)
    public void testVisibilityOfUserNameAndEmail() {
        Assert.assertTrue(profileMenuPage.isUserNameDisplayed(), "User name is not displayed.");
        Assert.assertTrue(profileMenuPage.isEmailDisplayed(), "Email address is not displayed.");
    }

    @Test(priority = 9)
    public void testSmoothOperationOfDropdownMenu() {
        profileMenuPage.clickProfileImage();
        Assert.assertTrue(profileMenuPage.isDropdownMenuDisplayed(), "Dropdown menu should be visible");
    }

    @Test(priority = 10)
    public void testNonResponsivenessOfDropdownMenuOnClickingOutside() {
        profileMenuPage.clickProfileImage();
        // Add assertions to verify that the dropdown menu does not close
    } 
}

