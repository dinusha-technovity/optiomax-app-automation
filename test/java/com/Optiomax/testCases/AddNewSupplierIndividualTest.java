package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.AddNewSupplierIndividualPage;
import com.Optiomax.pageObjects.BasePage;

public class AddNewSupplierIndividualTest extends BasePage {

	AddNewSupplierIndividualPage addNewSupplierIndividualPage;

	@BeforeMethod
	public void setupMethod() throws InterruptedException {
		//super.setup();
		addNewSupplierIndividualPage = new AddNewSupplierIndividualPage(driver);
		addNewSupplierIndividualPage.login("ashini@gmail.com", "Ashini1234$");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/supplier");
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void testValidFormSubmission() throws InterruptedException {
		Thread.sleep(3000);
		addNewSupplierIndividualPage.clickAddNewSupplierButton();
		Thread.sleep(3000);
		addNewSupplierIndividualPage.selectIndividualToggle();
		addNewSupplierIndividualPage.enterName("John Doe");
		addNewSupplierIndividualPage.enterAddress("1234 New Street");
		addNewSupplierIndividualPage.clickAssetClasses();
		addNewSupplierIndividualPage.selectAssetClasses();
		addNewSupplierIndividualPage.addSupplierRatings();
		addNewSupplierIndividualPage.enterContactNo("0765489012");
		addNewSupplierIndividualPage.enterLoginUsername("johndoe");
		addNewSupplierIndividualPage.enterLoginEmail("john@gmail.com");
		addNewSupplierIndividualPage.submitForm();
		
		Thread.sleep(3000);
		
		//addNewSupplierIndividualPage.selectWorkflow("Test Workflow");
		addNewSupplierIndividualPage.clickWorkflow();
		addNewSupplierIndividualPage.selectWorkflow();
		addNewSupplierIndividualPage.submitWorkflow();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.get("http://app.optiomax.com/dashboard");
		Thread.sleep(3000);
		driver.get("http://app.optiomax.com/dashboard/users_requisitions_list");
		addNewSupplierIndividualPage.enterReason("Approved");
		addNewSupplierIndividualPage.clickApprove();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		// verify the supplier is approved
		driver.get("http://app.optiomax.com/dashboard/supplier");
		
		// Need to add workflow selection

		// Assertion to verify successful form submission
//		String successMessage = addNewSupplierIndividualPage.getSuccessMessage();
//		Assert.assertEquals(successMessage, "Supplier added successfully.");
	}

	@Test(priority = 2)
	public void testMissingRequiredFields() throws InterruptedException {
		Thread.sleep(3000);
		addNewSupplierIndividualPage.clickAddNewSupplierButton();
		Thread.sleep(3000);
		addNewSupplierIndividualPage.selectIndividualToggle();
		addNewSupplierIndividualPage.enterLoginUsername("");
		addNewSupplierIndividualPage.submitForm();
		Thread.sleep(3000);

		// Assertions for missing required fields
		String nameError = addNewSupplierIndividualPage.getRequiredFieldErrorMessage("name");
		String addressError = addNewSupplierIndividualPage.getRequiredFieldErrorMessage("address");
		String assetClassError = addNewSupplierIndividualPage.getRequiredFieldErrorMessage("assetClass");
		String supplierRatingsError = addNewSupplierIndividualPage.getRequiredFieldErrorMessage("supplierRatings");
		String contactNoError = addNewSupplierIndividualPage.getRequiredFieldErrorMessage("contactNo");
		String loginUsernameError = addNewSupplierIndividualPage.getRequiredFieldErrorMessage("loginUsername");
		String loginEmailError = addNewSupplierIndividualPage.getRequiredFieldErrorMessage("loginEmail");

		Assert.assertEquals(nameError, "'name' is required");
		Assert.assertEquals(addressError, "'address' is required");
		Assert.assertEquals(assetClassError, "'assets_classes' is required");
		Assert.assertEquals(supplierRatingsError, "'supplier_rating' is required");
		Assert.assertEquals(contactNoError, "'contact_no 1' is required");
		Assert.assertEquals(loginUsernameError, "'supplier_username' is required");
		Assert.assertEquals(loginEmailError, "'supplier_email' is required");
		
		driver.navigate().refresh();
		Thread.sleep(3000);
	}


	@Test(priority = 3)
	public void testDuplicateEmail() throws InterruptedException {
		addNewSupplierIndividualPage.clickAddNewSupplierButton();
		Thread.sleep(3000);
		addNewSupplierIndividualPage.selectIndividualToggle();
		addNewSupplierIndividualPage.enterName("Andrew Wilkins");
		addNewSupplierIndividualPage.enterAddress("Station Approach, Chislehurst");
		addNewSupplierIndividualPage.clickAssetClasses();
		addNewSupplierIndividualPage.selectAssetClasses();
		addNewSupplierIndividualPage.addSupplierRatings();
		addNewSupplierIndividualPage.enterContactNo("020 8467 0467");
		addNewSupplierIndividualPage.enterLoginUsername("andrewwilkins");
		addNewSupplierIndividualPage.enterLoginEmail("john.doe@example.com");
		addNewSupplierIndividualPage.submitForm();

		// Assertion for duplicate email error message
//		String emailError = addNewSupplierIndividualPage.getEmailErrorMessage();
//		Assert.assertEquals(emailError, "This email is already registered.");
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 4)
	public void testMultipleAssetClassesSelection() throws InterruptedException {
		addNewSupplierIndividualPage.clickAddNewSupplierButton();
		addNewSupplierIndividualPage.selectIndividualToggle();
		addNewSupplierIndividualPage.enterName("Gavin Hart");
		addNewSupplierIndividualPage.enterAddress("29 Mt Ephraim, Royal Tunbridge Wells");
		addNewSupplierIndividualPage.clickAssetClasses();
		addNewSupplierIndividualPage.selectAssetClasses();
		addNewSupplierIndividualPage.clickNewAssetClasses();
		addNewSupplierIndividualPage.selectNewAssetClasses();
		addNewSupplierIndividualPage.clickAssetClasses();
		addNewSupplierIndividualPage.selectAssetClasses();
		addNewSupplierIndividualPage.addSupplierRatings();
		addNewSupplierIndividualPage.enterContactNo("01892 515949");
		addNewSupplierIndividualPage.enterLoginUsername("gavinhart12");
		addNewSupplierIndividualPage.enterLoginEmail("gavin.hart@gmail.com");
		addNewSupplierIndividualPage.submitForm();

		// Assertions for multiple selection
//		String selectedAssetClasses = addNewSupplierIndividualPage.getSelectedAssetClasses();
//		Assert.assertTrue(selectedAssetClasses.contains("Tangible Assets"));
//		Assert.assertTrue(selectedAssetClasses.contains("Fixed Assets"));
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
	}

	@Test(priority = 5)
	public void testFormSubmissionWithSingleContactNumber() throws InterruptedException {
		addNewSupplierIndividualPage.clickAddNewSupplierButton();
		addNewSupplierIndividualPage.selectIndividualToggle();
		addNewSupplierIndividualPage.enterName("David Chapman");
		addNewSupplierIndividualPage.enterAddress("20 Hempstead Dr, Hamilton");
		addNewSupplierIndividualPage.clickAssetClasses();
		addNewSupplierIndividualPage.selectAssetClasses();
		addNewSupplierIndividualPage.addSupplierRatings();
		addNewSupplierIndividualPage.enterContactNo("905 574 1500");
		addNewSupplierIndividualPage.enterLoginUsername("davidchapman");
		addNewSupplierIndividualPage.enterLoginEmail("david@chapman.gmail.com");
		addNewSupplierIndividualPage.submitForm();

		// Assertion to verify successful form submission with a single contact number
//		String successMessage = addNewSupplierIndividualPage.getSuccessMessage();
//		Assert.assertEquals(successMessage, "Supplier added successfully.");
		
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void testFormSubmissionWithMultipleContactNumbers() throws InterruptedException {
		addNewSupplierIndividualPage.clickAddNewSupplierButton();
		addNewSupplierIndividualPage.selectIndividualToggle();
		addNewSupplierIndividualPage.enterName("Justin Lawrence");
		addNewSupplierIndividualPage.enterAddress("708 Douglas St, Victoria");
		addNewSupplierIndividualPage.clickAssetClasses();
		addNewSupplierIndividualPage.selectAssetClasses();
		addNewSupplierIndividualPage.addSupplierRatings();
		addNewSupplierIndividualPage.enterContactNo("250 383 2213");
		addNewSupplierIndividualPage.addContactNo();
		addNewSupplierIndividualPage.enterContactNo("250 383 2211");
		addNewSupplierIndividualPage.enterLoginUsername("JustinLawrence123");
		addNewSupplierIndividualPage.enterLoginEmail("justin.lawrence@gmail.com");
		addNewSupplierIndividualPage.submitForm();
		
		addNewSupplierIndividualPage.selectNewAssetClasses();
		addNewSupplierIndividualPage.clickAssetClasses();
		addNewSupplierIndividualPage.submitForm();
		
		
		// Assertion to verify successful form submission with multiple contact numbers
//		String successMessage = addNewSupplierIndividualPage.getSuccessMessage();
//		Assert.assertEquals(successMessage, "Supplier added successfully.");
		
		driver.navigate().refresh();
		Thread.sleep(3000);
	
	}

}
