package com.Optiomax.testCases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.AddNewSupplierCompanyPage;
import com.Optiomax.pageObjetcs.BasePage;

public class AddNewSupplierCompanyTest extends BasePage {

	private AddNewSupplierCompanyPage addNewSupplierCompanyPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		addNewSupplierCompanyPage = new AddNewSupplierCompanyPage(driver);
		addNewSupplierCompanyPage.login("chamoddushyantha2017@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/supplier");
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void testFormSubmissionWithValidData() {
		addNewSupplierCompanyPage.clickAddNewSupplierButton();
		addNewSupplierCompanyPage.selectCompanyToggle();
		addNewSupplierCompanyPage.enterName("John Doe");
		addNewSupplierCompanyPage.enterAddress("1234 Elm Street");
		addNewSupplierCompanyPage.selectAssetClass("Tangible Assets");
		addNewSupplierCompanyPage.addSupplierRatings();
		addNewSupplierCompanyPage.enterContactNo("1234567890");
		addNewSupplierCompanyPage.addContactNo();
		addNewSupplierCompanyPage.enterContactNo("1234567891");
		addNewSupplierCompanyPage.enterBusinessName("Witting Inc");
		addNewSupplierCompanyPage.enterBusinessRegistration("02-3102530");
		addNewSupplierCompanyPage.enterPrimaryEmail("wittinginc@gmail.com");
		addNewSupplierCompanyPage.enterSecondaryEmail("wittingincsec@gmail.com");
		addNewSupplierCompanyPage.uploadBRAttachment("");
		addNewSupplierCompanyPage.enterWebsite("http://wittinginc.com/");
		addNewSupplierCompanyPage.enterTelephone("701 258 0312");
		addNewSupplierCompanyPage.enterMobile("701 258 0356");
		addNewSupplierCompanyPage.enterFax("123456799");
		addNewSupplierCompanyPage.enterCity("2400 State St,Bismarck");
		addNewSupplierCompanyPage.enterLatitude("106");
		addNewSupplierCompanyPage.enterLongitude("106");
		addNewSupplierCompanyPage.enterLoginUsername("johndoe");
		addNewSupplierCompanyPage.enterLoginEmail("john.doe@example.com");
		addNewSupplierCompanyPage.clickSubmitButton();

		// Assertion to verify successful form submission
		WebElement successMessage = driver.findElement(By.xpath(""));
		Assert.assertTrue(successMessage.isDisplayed(), "Success message should be displayed");
	}

	@Test(priority = 2)
	public void testErrorMessageForMissingRequiredFields() {

		addNewSupplierCompanyPage.clickAddNewSupplierButton();
		addNewSupplierCompanyPage.selectCompanyToggle();
		addNewSupplierCompanyPage.clickSubmitButton();

		// Assertions to verify error messages for each required field
		WebElement personNameError = driver.findElement(By.xpath(""));
		WebElement addressError = driver.findElement(By.xpath(""));
		WebElement assetClassError = driver.findElement(By.xpath(""));
		WebElement supplierRatingError = driver.findElement(By.xpath(""));
		WebElement contactNoError = driver.findElement(By.xpath(""));
		WebElement businessNameError = driver.findElement(By.xpath(""));
		WebElement businessRegistrationError = driver.findElement(By.xpath(""));
		WebElement primaryEmailError = driver.findElement(By.xpath(""));
		WebElement brAttachmentError = driver.findElement(By.xpath(""));
		WebElement telephoneError = driver.findElement(By.xpath(""));
		WebElement mobileError = driver.findElement(By.xpath(""));
		WebElement cityError = driver.findElement(By.xpath(""));
		WebElement usernameError = driver.findElement(By.xpath(""));
		WebElement passwordError = driver.findElement(By.xpath(""));

		Assert.assertTrue(personNameError.isDisplayed(), "Person Name error message should be displayed");
		Assert.assertTrue(addressError.isDisplayed(), "Address error message should be displayed");
		Assert.assertTrue(assetClassError.isDisplayed(), "Asset Class error message should be displayed");
		Assert.assertTrue(supplierRatingError.isDisplayed(), "Supplier Ratings error should be displayed");
		Assert.assertTrue(contactNoError.isDisplayed(), "Contact Number error should be displayed");
		Assert.assertTrue(businessNameError.isDisplayed(), "Business Name error message should be displayed");
		Assert.assertTrue(businessRegistrationError.isDisplayed(), "Business Registration error message should be displayed");
		Assert.assertTrue(primaryEmailError.isDisplayed(), "Primary Email error message should be displayed");
		Assert.assertTrue(brAttachmentError.isDisplayed(), "BR Attachment error message should be displayed");
		Assert.assertTrue(telephoneError.isDisplayed(), "Telephone error message should be displayed");
		Assert.assertTrue(mobileError.isDisplayed(), "Mobile error message should be displayed");
		Assert.assertTrue(cityError.isDisplayed(), "City error message should be displayed");
		Assert.assertTrue(usernameError.isDisplayed(), "Username error messsage should be displayed");
		Assert.assertTrue(passwordError.isDisplayed(), "Password error message should be displayed");
	}

	@Test(priority = 3)
	public void testMultipleEmailAddresses() {
		addNewSupplierCompanyPage.clickAddNewSupplierButton();
		addNewSupplierCompanyPage.selectCompanyToggle();
		addNewSupplierCompanyPage.enterName("John Doe");
		addNewSupplierCompanyPage.enterAddress("1234 Elm Street");
		addNewSupplierCompanyPage.selectAssetClass("Tangible Assets");
		addNewSupplierCompanyPage.addSupplierRatings();
		addNewSupplierCompanyPage.enterContactNo("1234567890");
		addNewSupplierCompanyPage.addContactNo();
		addNewSupplierCompanyPage.enterContactNo("1234567891");
		addNewSupplierCompanyPage.enterBusinessName("Witting Inc");
		addNewSupplierCompanyPage.enterBusinessRegistration("021 310 2530");
		addNewSupplierCompanyPage.enterPrimaryEmail("primary@example.com");
		addNewSupplierCompanyPage.enterSecondaryEmail("secondary@example.com");
		addNewSupplierCompanyPage.uploadBRAttachment("");
		addNewSupplierCompanyPage.enterWebsite("http://wittinginc.com/");
		addNewSupplierCompanyPage.enterTelephone("701 258 0312");
		addNewSupplierCompanyPage.enterMobile("701 258 0356");
		addNewSupplierCompanyPage.enterFax("123456799");
		addNewSupplierCompanyPage.enterCity("2400 State St,Bismarck");
		addNewSupplierCompanyPage.enterLatitude("106");
		addNewSupplierCompanyPage.enterLongitude("106");
		addNewSupplierCompanyPage.enterLoginUsername("johndoe");
		addNewSupplierCompanyPage.enterLoginEmail("john.doe@example.com");

		// Assertions to verify the entered email addresses
		WebElement primaryEmailField = driver.findElement(By.xpath(""));
		WebElement secondaryEmailField = driver.findElement(By.xpath(""));
		Assert.assertEquals(primaryEmailField.getAttribute("value"), "primary@example.com",
				"Primary Email should be entered correctly");
		Assert.assertEquals(secondaryEmailField.getAttribute("value"), "secondary@example.com",
				"Secondary Email should be entered correctly");
	}

	@Test(priority = 4)
	public void testAddWebsiteLink() {
		addNewSupplierCompanyPage.clickAddNewSupplierButton();
		addNewSupplierCompanyPage.selectCompanyToggle();
		addNewSupplierCompanyPage.enterWebsite("http://www.testwebsite.com");

		// Assertion to verify the entered website link
		WebElement websiteField = driver.findElement(By.name("website"));
		Assert.assertEquals(websiteField.getAttribute("value"), "http://www.testwebsite.com",
				"Website link should be entered correctly");
	}

	@Test(priority = 5)
	public void testAddBRAttachment() {
		addNewSupplierCompanyPage.clickAddNewSupplierButton();
		addNewSupplierCompanyPage.selectCompanyToggle();
		addNewSupplierCompanyPage.uploadBRAttachment("");

		// Assertion to verify that the BR attachment is uploaded
		WebElement brAttachmentUpload = driver.findElement(By.name("brAttachment"));
		Assert.assertNotNull(brAttachmentUpload.getAttribute("value"), "BR Attachment should be uploaded");
	}

	@Test(priority = 6)
	public void testLatitudeField() {
		addNewSupplierCompanyPage.clickAddNewSupplierButton();
		addNewSupplierCompanyPage.selectCompanyToggle();
		addNewSupplierCompanyPage.enterLatitude("10");

		// Assertion to verify the entered latitude
		WebElement latitudeField = driver.findElement(By.name("latitude"));
		Assert.assertEquals(latitudeField.getAttribute("value"), "10", "Latitude should be entered correctly");
	}

	@Test(priority = 7)
	public void testLongitudeField() {
		addNewSupplierCompanyPage.clickAddNewSupplierButton();
		addNewSupplierCompanyPage.selectCompanyToggle();
		addNewSupplierCompanyPage.enterLongitude("106");

		// Assertion to verify the entered longitude
		WebElement longitudeField = driver.findElement(By.name("longitude"));
		Assert.assertEquals(longitudeField.getAttribute("value"), "106", "Longitude should be entered correctly");
	}

	@Test(priority = 8)
	public void testLocation() {
		Map<String, Object> coordinates = new HashMap<>();
		coordinates.put("latitude", 42.1408845);
		coordinates.put("longitude", -72.5033907);
		coordinates.put("accuracy", 100);
	}
	
	@Test(priority = 9)
	public void testbrAttach() {
		addNewSupplierCompanyPage.clickAddNewSupplierButton();
		addNewSupplierCompanyPage.selectCompanyToggle();
		addNewSupplierCompanyPage.selectAssetClass("");
		addNewSupplierCompanyPage.uploadBRAttachment("");
		addNewSupplierCompanyPage.enterLoginEmail("");
		addNewSupplierCompanyPage.enterLoginUsername("");
		addNewSupplierCompanyPage.clickSubmitButton();
		
		WebElement brAttachment = driver.findElement(By.xpath(""));
		Assert.assertEquals(brAttachment.getAttribute("value"), "BR attachment should be uploaded successfully.");
	}
	
}
