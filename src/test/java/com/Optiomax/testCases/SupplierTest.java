package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.SupplierPage;

import org.openqa.selenium.By;

public class SupplierTest extends BasePage {

	private SupplierPage supplierPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		supplierPage = new SupplierPage(driver);
		supplierPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/supplier");
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void testPageLoad() {
		Assert.assertTrue(supplierPage.isPageLoaded(), "The supplier page did not load successfully.");
	}

	@Test(priority = 2)
	public void testSupplierCardsDisplay() {
		Assert.assertTrue(supplierPage.getSupplierCardCount() > 0, "The supplier cards are not displayed.");
	}

	@Test(priority = 3)
	public void testAddNewSupplierButton() throws InterruptedException {
		supplierPage.clickAddNewSupplier();
		Thread.sleep(3000);
		// Verify that the new pop-up window appears
		Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Add New Supplier']")).isDisplayed(),
				"The 'Add New Supplier' popup did not appear.");
		driver.navigate().refresh();
	}

	@Test(priority = 4)
	public void testUpdateButtonFunctionality() throws InterruptedException {
		Thread.sleep(3000);
		supplierPage.clickUpdateButton();
        Thread.sleep(3000);
		// Verify that the edit pop-up window appears
		Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Update Existing Workflow']")).isDisplayed(),
				"The 'Update Supplier' popup did not appear.");
		driver.navigate().refresh();
	}

	@Test(priority = 5)
	public void testDeleteButtonFunctionality() throws InterruptedException {
		Thread.sleep(3000);
		supplierPage.clickDeleteButton();
        Thread.sleep(3000);
		// Verify that a confirmation message appears
		Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Remove Supplier']")).isDisplayed(), "The confirmation message did not appear.");
		// Confirm the deletion and verify the success message
//		driver.findElement(By.xpath("")).click();
//		Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed(),
//				"The success message did not appear after deletion.");
		driver.navigate().refresh();
	}

	@Test(priority = 6)
	public void testSearchFunctionalityWithValidInput() throws InterruptedException {
		supplierPage.searchStaff("Globex Corporation");
        Thread.sleep(3000);
		Assert.assertTrue(supplierPage.isStaffPresent("Globex Corporation"),
				"The search functionality did not return the expected result.");
		driver.navigate().refresh();
	}

	@Test(priority = 7)
	public void testErrorHandlingForNonExistentSupplier() throws InterruptedException {
		supplierPage.searchStaff("nonexistentsupplier");
        Thread.sleep(3000);
		Assert.assertTrue(supplierPage.isNoResultsMessageDisplayed(),
				"The error handling for non-existent supplier is not working as expected.");
		driver.navigate().refresh();
	}

	@Test(priority = 8)
	public void testSearchFunctionalityWithPartialNames() throws InterruptedException {
		supplierPage.searchStaff("Globex");
        Thread.sleep(3000);
		Assert.assertTrue(supplierPage.isStaffPresent("Globex Corporation"),
				"The search functionality did not return the expected result with partial name.");
		driver.navigate().refresh();
	}
	
    @Test(priority = 9)
    public void testToggleGridView() throws InterruptedException {
    	supplierPage.toggleGridView();
        Thread.sleep(3000);
        Assert.assertTrue(supplierPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div")), "Grid view toggle did not work correctly.");
        driver.navigate().refresh();
    }
    
    @Test(priority = 10)
    public void testToggleListView() throws InterruptedException {
    	supplierPage.toggleListView();
        Thread.sleep(3000);
        //Assert.assertTrue(supplierPage.isElementPresent(By.xpath("")), "List view toggle did not work correctly.");
        driver.navigate().refresh();
    }
    
    @Test(priority = 11)
    public void testExportCSV() throws InterruptedException {
    	supplierPage.clickExportCSV();
        Thread.sleep(3000);
        // Add logic to verify CSV file download if possible
        //Assert.assertTrue(isFileDownloaded("supplier.csv"), "Export CSV did not work correctly.");      
        driver.navigate().refresh();
    }
    
    @Test(priority = 12)
    public void testFilterValidCriteria() throws InterruptedException {
    	supplierPage.clickFilterButton();
        Thread.sleep(3000);
        // Add logic to select valid filter criteria
        //Assert.assertTrue(supplierPage.isElementPresent(By.xpath("//div[contains(text(), 'Filtered Result')]")), "Filter functionality with valid criteria did not work correctly.");
        driver.navigate().refresh();
    }

	@AfterClass
	public void tearDown() {
		super.teardown();
	}
	
}
