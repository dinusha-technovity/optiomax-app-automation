package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.ProcurementStaffPage;

import org.openqa.selenium.By;

public class ProcurementStaffTest extends BasePage {
    private ProcurementStaffPage procurementStaffPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        super.setup();
        procurementStaffPage = new ProcurementStaffPage(driver);
		procurementStaffPage.login("ruvinya@gmail.com", "ruvinya1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/procurement_initiate");
		Thread.sleep(5000); 
    }

    @Test
    public void testPageLoad() {
        Assert.assertTrue(procurementStaffPage.isPageLoaded(), "The procurement staff page did not load successfully.");
    }

    @Test
    public void testStaffCardsDisplay() {
        Assert.assertTrue(procurementStaffPage.getStaffCardCount() > 0, "The procurement staff cards are not displayed.");
    }

    @Test
    public void testAddNewMemberButton() {
        procurementStaffPage.clickAddNewMember();
        // Verify that the new pop-up window appears
        Assert.assertTrue(driver.findElement(By.id("addMemberPopup")).isDisplayed(), "The 'Add New Member' popup did not appear.");
    }

    @Test
    public void testUpdateButtonFunctionality() {
        procurementStaffPage.clickUpdateButton();
        // Verify that the edit pop-up window appears
        Assert.assertTrue(driver.findElement(By.id("editMemberPopup")).isDisplayed(), "The 'Edit Member' popup did not appear.");
    }

    @Test
    public void testDeleteButtonFunctionality() {
        procurementStaffPage.clickDeleteButton();
        // Verify that a confirmation message appears
        Assert.assertTrue(driver.findElement(By.id("confirmationMessage")).isDisplayed(), "The confirmation message did not appear.");
        // Confirm the deletion and verify the success message
        driver.findElement(By.id("confirmDeleteButton")).click();
        Assert.assertTrue(driver.findElement(By.id("successMessage")).isDisplayed(), "The success message did not appear after deletion.");
    }

    @Test
    public void testSearchFunctionalityWithValidInput() {
        procurementStaffPage.searchStaff("sachintha");
        Assert.assertTrue(procurementStaffPage.isStaffPresent("sachintha"), "The search functionality did not return the expected result.");
    }

    @Test
    public void testErrorHandlingForNonExistentStaff() {
        procurementStaffPage.searchStaff("nonexistentstaff");
        Assert.assertTrue(procurementStaffPage.isNoResultsMessageDisplayed(), "The error handling for non-existent staff is not working as expected.");
    }

    @Test
    public void testSearchFunctionalityWithPartialNames() {
        procurementStaffPage.searchStaff("dush");
        Assert.assertTrue(procurementStaffPage.isStaffPresent("dushyantha"), "The search functionality did not return the expected result with partial name.");
    }

    @AfterClass
    public void tearDown() {
        super.teardown();
    }
}
