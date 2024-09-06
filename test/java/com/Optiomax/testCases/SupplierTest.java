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
		supplierPage.login("chamoddushyantha2017@gmail.com", "chamod1234");
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
	public void testAddNewSupplierButton() {
		supplierPage.clickAddNewSupplier();
		// Verify that the new pop-up window appears
		Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed(),
				"The 'Add New Supplier' popup did not appear.");
	}

	@Test(priority = 4)
	public void testUpdateButtonFunctionality() {
		supplierPage.clickEditButton();
		// Verify that the edit pop-up window appears
		Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed(),
				"The 'Update Supplier' popup did not appear.");
	}

	@Test(priority = 5)
	public void testDeleteButtonFunctionality() {
		supplierPage.clickDeleteButton();
		// Verify that a confirmation message appears
		Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed(), "The confirmation message did not appear.");
		// Confirm the deletion and verify the success message
		driver.findElement(By.xpath("")).click();
		Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed(),
				"The success message did not appear after deletion.");
	}

	@Test(priority = 6)
	public void testSearchFunctionalityWithValidInput() {
		supplierPage.searchStaff("");
		Assert.assertTrue(supplierPage.isStaffPresent(""),
				"The search functionality did not return the expected result.");
	}

	@Test(priority = 7)
	public void testErrorHandlingForNonExistentSupplier() {
		supplierPage.searchStaff("nonexistentsupplier");
		Assert.assertTrue(supplierPage.isNoResultsMessageDisplayed(),
				"The error handling for non-existent supplier is not working as expected.");
	}

	@Test(priority = 8)
	public void testSearchFunctionalityWithPartialNames() {
		supplierPage.searchStaff("");
		Assert.assertTrue(supplierPage.isStaffPresent(""),
				"The search functionality did not return the expected result with partial name.");
	}

	@AfterClass
	public void tearDown() {
		super.teardown();
	}
	
}
