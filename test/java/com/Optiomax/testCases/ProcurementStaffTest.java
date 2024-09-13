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
		procurementStaffPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/staff");
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
    public void testAddNewMemberButton() throws InterruptedException {
        procurementStaffPage.clickAddNewMember();
        Thread.sleep(3000);
        // Verify that the new pop-up window appears
        Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Add New Member']")).isDisplayed(), "The 'Add New Member' popup did not appear.");
    }

    @Test
    public void testUpdateButtonFunctionality() throws InterruptedException {
        procurementStaffPage.clickUpdateButton();
        Thread.sleep(3000);
        // Verify that the edit pop-up window appears
        Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Update Existing Workflow']")).isDisplayed(), "The 'Edit Member' popup did not appear.");
    }

    @Test
    public void testDeleteButtonFunctionality() throws InterruptedException {
        procurementStaffPage.clickDeleteButton();
        Thread.sleep(3000);
        // Verify that a confirmation message appears
        Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Remove Member']")).isDisplayed(), "The confirmation message did not appear.");
        // Confirm the deletion and verify the success message
//        driver.findElement(By.xpath("confirmDeleteButton")).click();
//        Assert.assertTrue(driver.findElement(By.id("successMessage")).isDisplayed(), "The success message did not appear after deletion.");
    }

    @Test
    public void testSearchFunctionalityWithValidInput() throws InterruptedException {
        procurementStaffPage.searchStaff("Anna Tardy");
        Thread.sleep(3000);
        Assert.assertTrue(procurementStaffPage.isStaffPresent("Anna Tardy"), "The search functionality did not return the expected result.");
    }

    @Test
    public void testErrorHandlingForNonExistentStaff() throws InterruptedException {
        procurementStaffPage.searchStaff("nonexistentstaff");
        Thread.sleep(3000);
        Assert.assertTrue(procurementStaffPage.isNoResultsMessageDisplayed(), "The error handling for non-existent staff is not working as expected.");
    }

    @Test
    public void testSearchFunctionalityWithPartialNames() throws InterruptedException {
        procurementStaffPage.searchStaff("Turner");
        Thread.sleep(3000);
        Assert.assertTrue(procurementStaffPage.isStaffPresent("Brenton Turner"), "The search functionality did not return the expected result with partial name.");
    }

    @AfterClass
    public void tearDown() {
        super.teardown();
    }
}
