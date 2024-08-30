package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.AddProcurementStaffPage;
import com.Optiomax.pageObjetcs.BasePage;

import org.testng.annotations.AfterClass;

public class AddProcurementStaffTest extends BasePage {
	private AddProcurementStaffPage addProcurementStaffPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		addProcurementStaffPage = new AddProcurementStaffPage(driver);
		addProcurementStaffPage.login("chamoddushyantha2017@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/workflow");
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void testAddNewMemberSuccessfully() {
		addProcurementStaffPage.selectUser("User1");
		addProcurementStaffPage.selectAssetClass("Tangible assets");
		addProcurementStaffPage.clickSubmit();
		// Verification step for successful addition
		Assert.assertTrue(addProcurementStaffPage.isSuccessMessageDisplayed(),
				"The member was not added successfully.");
	}

	@Test(priority = 2)
	public void testAddNewMemberWithOneAssetClass() {
		addProcurementStaffPage.selectUser("User2");
		addProcurementStaffPage.selectAssetClass("Intangible assets");
		addProcurementStaffPage.clickSubmit();
		// Verification step for successful addition with one asset class
		Assert.assertTrue(addProcurementStaffPage.isSuccessMessageDisplayed(),
				"The member with one asset class was not added successfully.");
	}

//	@Test(priority = 3)
//	public void testAddNewMemberWithMultipleAssetClasses() {
//		addProcurementStaffPage.selectUser("User3");
//		addProcurementStaffPage.selectAssetClass("Operating assets");
//		addProcurementStaffPage.selectAssetClass("Non-operating assets");
//		addProcurementStaffPage.clickSubmit();
//		// Verification step for successful addition with multiple asset classes
//		Assert.assertTrue(addProcurementStaffPage.isSuccessMessageDisplayed(),
//				"The member with multiple asset classes was not added successfully.");
//	}

	@Test(priority = 3)
	public void addNewMemberWithMultipleAssetClasses() {
		addProcurementStaffPage.selectUser("User");
		addProcurementStaffPage.selectAssetClass("Fixed assets");
		addProcurementStaffPage.clickSubmit();

		addProcurementStaffPage.selectUser("User");
		addProcurementStaffPage.selectAssetClass("Current assets");
		addProcurementStaffPage.clickSubmit();
		// Verify successful addition multiple asset classes
		Assert.assertTrue(addProcurementStaffPage.isSuccessMessageDisplayed(),
				"The new member with multiple asset classes were not added successfully");
	}

	@Test(priority = 4)
	public void testErrorHandlingWithoutSelectingUser() {
		addProcurementStaffPage.selectAssetClass("Tangible assets");
		addProcurementStaffPage.clickSubmit();
		Assert.assertTrue(addProcurementStaffPage.isErrorMessageDisplayed(),
				"Error message was not displayed when user was not selected.");
	}

	@Test(priority = 5)
	public void testErrorHandlingWithoutSelectingAssetClass() {
		addProcurementStaffPage.selectUser("User1");
		addProcurementStaffPage.clickSubmit();
		Assert.assertTrue(addProcurementStaffPage.isErrorMessageDisplayed(),
				"Error message was not displayed when asset class was not selected.");
	}

	@Test(priority = 6)
	public void testErrorHandlingWithoutSelectingUserAndAssetClass() {
		addProcurementStaffPage.clickSubmit();
		Assert.assertTrue(addProcurementStaffPage.isErrorMessageDisplayed(),
				"Error message was not displayed when user and asset class were not selected.");
	}

	@Test(priority = 7)
	public void testErrorHandlingWithDuplicateAssetClasses() {
		addProcurementStaffPage.selectUser("User1");
		addProcurementStaffPage.selectAssetClass("Tangible assets");
		addProcurementStaffPage.selectAssetClass("Tangible assets");
		addProcurementStaffPage.clickSubmit();
		Assert.assertTrue(addProcurementStaffPage.isErrorMessageDisplayed(),
				"Error message was not displayed for duplicate asset classes.");
	}

	@Test(priority = 8)
	public void testErrorHandlingForDuplicateUserAssignment() {
		addProcurementStaffPage.selectUser("ExistingUser");
		addProcurementStaffPage.selectAssetClass("Tangible assets");
		addProcurementStaffPage.clickSubmit();
		Assert.assertTrue(addProcurementStaffPage.isErrorMessageDisplayed(),
				"Error message was not displayed for assigning a user to the same asset class again.");
	}

	@Test(priority = 9)
	public void testClosePopupWithoutAddingMember() {
		addProcurementStaffPage.clickCloseButton();
		Assert.assertTrue(addProcurementStaffPage.isPopupClosed(),
				"The 'Add New Member' popup did not close without adding a member.");
	}

	@Test(priority = 9)
	public void testErrorMessage() {
		addProcurementStaffPage.selectUser("Non-existing User");
		addProcurementStaffPage.selectAssetClass("Intangible assets");
		addProcurementStaffPage.clickSubmit();
		Assert.assertTrue(addProcurementStaffPage.isErrorMessageDisplayed(), "Error message was not displayed.");

		Assert.assertTrue(addProcurementStaffPage.isErrorMessageDisplayed(),
				"Error message was not diaplayed  for assign asset class.");
	}

	@Test(priority = 10)
	public void verifyBothFieldsLeftBlanks() {
		addProcurementStaffPage.selectUser("");
		addProcurementStaffPage.selectAssetClass("");
		addProcurementStaffPage.clickSubmit();
		Assert.assertTrue(addProcurementStaffPage.isErrorMessageDisplayed(),
				"Error message was not displayed for both field left blank.");
	}

	@AfterClass
	public void tearDown() {
		super.teardown();
	}

}
