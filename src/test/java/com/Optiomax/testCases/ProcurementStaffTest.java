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

	@Test(priority = 1)
	public void testPageLoad() throws InterruptedException {
		Assert.assertTrue(procurementStaffPage.isPageLoaded(), "The procurement staff page did not load successfully.");
	}

    @Test(priority = 2)
    public void testStaffCardsDisplay() {
        Assert.assertTrue(procurementStaffPage.getStaffCardCount() > 0, "The procurement staff cards are not displayed.");
    }

    @Test(priority = 3)
    public void testAddNewMemberButton() throws InterruptedException {
        procurementStaffPage.clickAddNewMember();
        Thread.sleep(3000);
        // Verify that the new pop-up window appears
        Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Add New Member']")).isDisplayed(), "The 'Add New Member' popup did not appear.");
        procurementStaffPage.clickAddNewMemberClose();
        
    }

    @Test(priority = 4)
    public void testUpdateButtonFunctionality() throws InterruptedException {
        procurementStaffPage.clickUpdateButton();
        Thread.sleep(3000);
        // Verify that the edit pop-up window appears
        Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Update Existing Workflow']")).isDisplayed(), "The 'Edit Member' popup did not appear.");
        driver.navigate().refresh();      
    }

    @Test(priority = 5)
    public void testDeleteButtonFunctionality() throws InterruptedException {
    	Thread.sleep(3000);
        procurementStaffPage.clickDeleteButton();
        Thread.sleep(3000);
        // Verify that a confirmation message appears
        Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Remove Member']")).isDisplayed(), "The confirmation message did not appear.");
        // Confirm the deletion and verify the success message
//        driver.findElement(By.xpath("confirmDeleteButton")).click();
//        Assert.assertTrue(driver.findElement(By.id("successMessage")).isDisplayed(), "The success message did not appear after deletion.");
        driver.navigate().refresh();
    }

    @Test(priority = 6)
    public void testSearchFunctionalityWithValidInput() throws InterruptedException {
        procurementStaffPage.searchStaff("Anna Tardy");
        Thread.sleep(3000);
        Assert.assertTrue(procurementStaffPage.isStaffPresent("Anna Tardy"), "The search functionality did not return the expected result.");
        driver.navigate().refresh();
    }

    @Test(priority = 7)
    public void testErrorHandlingForNonExistentStaff() throws InterruptedException {
        procurementStaffPage.searchStaff("nonexistentstaff");
        Thread.sleep(3000);
        Assert.assertTrue(procurementStaffPage.isNoResultsMessageDisplayed(), "The error handling for non-existent staff is not working as expected.");
        driver.navigate().refresh();
    }

    @Test(priority = 8)
    public void testSearchFunctionalityWithPartialNames() throws InterruptedException {
        procurementStaffPage.searchStaff("Turner");
        Thread.sleep(3000);
        Assert.assertTrue(procurementStaffPage.isStaffPresent("Brenton Turner"), "The search functionality did not return the expected result with partial name.");
        driver.navigate().refresh();
    }

    @Test(priority = 9)
    public void testToggleGridView() throws InterruptedException {
    	procurementStaffPage.toggleGridView();
        Thread.sleep(3000);
        Assert.assertTrue(procurementStaffPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div")), "Grid view toggle did not work correctly.");
        driver.navigate().refresh();
    }
    
//    @Test(priority = 10)
//    public void testToggleListView() throws InterruptedException {
//    	procurementStaffPage.toggleListView();
//        Thread.sleep(3000);
//        Assert.assertTrue(procurementStaffPage.isElementPresent(By.xpath("")), "List view toggle did not work correctly.");
//        driver.navigate().refresh();
//    }
    
    @Test(priority = 11)
    public void testExportCSV() throws InterruptedException {
    	procurementStaffPage.clickExportCSV();
        Thread.sleep(3000);
        // Add logic to verify CSV file download if possible
        //Assert.assertTrue(isFileDownloaded("staff.csv"), "Export CSV did not work correctly.");      
        driver.navigate().refresh();
    }
    
    @Test(priority = 12)
    public void testFilterValidCriteria() throws InterruptedException {
    	procurementStaffPage.clickFilterButton();
        Thread.sleep(3000);
        // Add logic to select valid filter criteria
        //Assert.assertTrue(procurementStaffPage.isElementPresent(By.xpath("//div[contains(text(), 'Filtered Result')]")), "Filter functionality with valid criteria did not work correctly.");
        driver.navigate().refresh();
    }

    @AfterClass
    public void tearDown() {
        super.teardown();
    }
    
}
