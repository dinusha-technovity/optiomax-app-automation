package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.AddNewSupplierCompanyPage;
import com.Optiomax.pageObjects.BasePage;

public class AddNewSupplierCompanyTest extends BasePage {

	private AddNewSupplierCompanyPage addNewSupplierCompanyPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		addNewSupplierCompanyPage = new AddNewSupplierCompanyPage(driver);
		addNewSupplierCompanyPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/supplier");
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void testFormSubmissionWithValidData() throws InterruptedException {
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

		// // Assertion to verify successful form submission
		// WebElement successMessage = driver.findElement(By.xpath(""));
		// Assert.assertTrue(successMessage.isDisplayed(), "Success message should be
		// displayed");

		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void testErrorMessageForMissingRequiredFields() throws InterruptedException {

		addNewSupplierCompanyPage.clickAddNewSupplierButton();
		Thread.sleep(3000);
		addNewSupplierCompanyPage.selectCompanyToggle();
		// addNewSupplierCompanyPage.clickUsername();
		addNewSupplierCompanyPage.enterLoginEmail("");
		// addNewSupplierCompanyPage.scrollToElementAndClick();
		addNewSupplierCompanyPage.clickSubmitButton();

		Thread.sleep(6000);

		// Assertions to verify error messages for each required field
		WebElement personNameError = driver.findElement(By.xpath("//div[@id='name_help']//div[@class='ant-form-item-explain-error']"));
		WebElement addressError = driver.findElement(By.xpath("//div[@id='address_help']//div[@class='ant-form-item-explain-error']"));
		WebElement assetClassError = driver.findElement(By.xpath("//div[@id='assets_classes_help']//div[@class='ant-form-item-explain-error']"));
		WebElement supplierRatingError = driver.findElement(By.xpath("//div[@id='supplier_rating_help']//div[@class='ant-form-item-explain-error']"));
		WebElement contactNoError = driver.findElement(By.xpath("//div[@id='contact_no 1_help']//div[@class='ant-form-item-explain-error']"));
		WebElement businessNameError = driver.findElement(By.xpath("//div[@id='business_name_help']//div[@class='ant-form-item-explain-error']"));
		WebElement businessRegistrationError = driver.findElement(By.xpath("//div[@id='business_registration_help']//div[@class='ant-form-item-explain-error']"));
		WebElement primaryEmailError = driver.findElement(By.xpath("//div[@id='primary_email_help']//div[@class='ant-form-item-explain-error']"));
		WebElement secondaryEmailError = driver.findElement(By.xpath("//div[@id='secondary_email_help']//div[@class='ant-form-item-explain-error']"));
		WebElement brAttachmentError = driver.findElement(By.xpath("//div[@id='br_attachment_help']//div[@class='ant-form-item-explain-error']"));
		WebElement websiteError = driver.findElement(By.xpath("//div[@id='website_help']//div[@class='ant-form-item-explain-error']"));
		WebElement telephoneError = driver.findElement(By.xpath("//div[@id='tel_no_help']//div[@class='ant-form-item-explain-error']"));
		WebElement mobileError = driver.findElement(By.xpath("//div[@id='mobile_help']//div[@class='ant-form-item-explain-error']"));
		WebElement faxError = driver.findElement(By.xpath("//div[@id='fax_help']//div[@class='ant-form-item-explain-error']"));
		WebElement cityError = driver.findElement(By.xpath("//div[@id='city_help']//div[@class='ant-form-item-explain-error']"));
		WebElement usernameError = driver.findElement(By.xpath("//div[@id='supplier_username_help']//div[@class='ant-form-item-explain-error']"));
		WebElement passwordError = driver.findElement(By.xpath("//div[@id='supplier_email_help']//div[@class='ant-form-item-explain-error']"));

		Assert.assertTrue(personNameError.isDisplayed(), "Person Name error message should be displayed");
		Assert.assertTrue(addressError.isDisplayed(), "Address error message should be displayed");
		Assert.assertTrue(assetClassError.isDisplayed(), "Asset Class error message should be displayed");
		Assert.assertTrue(supplierRatingError.isDisplayed(), "Supplier Ratings error should be displayed");
		Assert.assertTrue(contactNoError.isDisplayed(), "Contact Number error should be displayed");
		Assert.assertTrue(businessNameError.isDisplayed(), "Business Name error message should be displayed");
		Assert.assertTrue(businessRegistrationError.isDisplayed(), "Business Registration error message should be displayed");
		Assert.assertTrue(primaryEmailError.isDisplayed(), "Primary Email error message should be displayed");
		Assert.assertTrue(secondaryEmailError.isDisplayed(), "Secondary Email error message should be displayed");
		Assert.assertTrue(brAttachmentError.isDisplayed(), "BR Attachment error message should be displayed");
		Assert.assertTrue(websiteError.isDisplayed(), "Website error message should be displayed");
		Assert.assertTrue(telephoneError.isDisplayed(), "Telephone error message should be displayed");
		Assert.assertTrue(mobileError.isDisplayed(), "Mobile error message should be displayed");
		Assert.assertTrue(faxError.isDisplayed(), "Fax error message should be displayed");
		Assert.assertTrue(cityError.isDisplayed(), "City error message should be displayed");
		Assert.assertTrue(usernameError.isDisplayed(), "Username error messsage should be displayed");
		Assert.assertTrue(passwordError.isDisplayed(), "Password error message should be displayed");

		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void testMultipleEmailAddresses() throws InterruptedException {
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
		addNewSupplierCompanyPage.enterPrimaryEmail("primary@example.com"); // primary email
		addNewSupplierCompanyPage.enterSecondaryEmail("secondary@example.com"); // secondary email
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

		driver.navigate().refresh();
		Thread.sleep(3000);

	}

	@Test(priority = 4)
	public void testAddWebsiteLink() throws InterruptedException {
		addNewSupplierCompanyPage.clickAddNewSupplierButton();
		addNewSupplierCompanyPage.selectCompanyToggle();
		addNewSupplierCompanyPage.enterName("James Peter");
		addNewSupplierCompanyPage.enterAddress("1234 old Street");
		addNewSupplierCompanyPage.selectAssetClass("Tangible Assets");
		addNewSupplierCompanyPage.addSupplierRatings();
		addNewSupplierCompanyPage.enterContactNo("0112356781");
		addNewSupplierCompanyPage.addContactNo();
		addNewSupplierCompanyPage.enterContactNo("0118787881");
		addNewSupplierCompanyPage.enterBusinessName("Initech");
		addNewSupplierCompanyPage.enterBusinessRegistration("100 200 394");
		addNewSupplierCompanyPage.enterWebsite("http://www.testwebsite.com"); // Website
		addNewSupplierCompanyPage.enterTelephone("0117276571");
		addNewSupplierCompanyPage.enterMobile("0775467891");
		addNewSupplierCompanyPage.enterFax("123456799");
		addNewSupplierCompanyPage.enterCity("New York");
		addNewSupplierCompanyPage.enterLatitude("105");
		addNewSupplierCompanyPage.enterLongitude("105");
		addNewSupplierCompanyPage.enterLoginUsername("james");
		addNewSupplierCompanyPage.enterLoginEmail("james.peter@yahoo.com");
		addNewSupplierCompanyPage.clickSubmitButton();

		// Assertion to verify the entered website link
		WebElement websiteField = driver.findElement(By.xpath(""));
		Assert.assertEquals(websiteField.getAttribute("value"), "http://www.testwebsite.com",
				"Website link should be entered correctly");

		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void testAddBRAttachment() throws InterruptedException {
		addNewSupplierCompanyPage.clickAddNewSupplierButton();
		addNewSupplierCompanyPage.selectCompanyToggle();
		addNewSupplierCompanyPage.enterName("Joseph Turner");
		addNewSupplierCompanyPage.enterAddress("234 Bank Street");
		addNewSupplierCompanyPage.selectAssetClass("Tangible Assets");
		addNewSupplierCompanyPage.addSupplierRatings();
		addNewSupplierCompanyPage.enterContactNo("0116628907");
		addNewSupplierCompanyPage.addContactNo();
		addNewSupplierCompanyPage.enterContactNo("0117576748");
		addNewSupplierCompanyPage.enterBusinessName("Soylent Corporation");
		addNewSupplierCompanyPage.enterBusinessRegistration("1323243");
		addNewSupplierCompanyPage.enterPrimaryEmail("soylent@corporation.com");
		addNewSupplierCompanyPage.enterSecondaryEmail("soylent@corp.com");
		addNewSupplierCompanyPage.uploadBRAttachment(""); // BR Attachment
		addNewSupplierCompanyPage.enterWebsite("https://soylent.com");
		addNewSupplierCompanyPage.enterTelephone("0116356375");
		addNewSupplierCompanyPage.enterMobile("0776464656");
		addNewSupplierCompanyPage.enterFax("123456788");
		addNewSupplierCompanyPage.enterCity("amsterdam");
		addNewSupplierCompanyPage.enterLatitude("102");
		addNewSupplierCompanyPage.enterLongitude("87");
		addNewSupplierCompanyPage.enterLoginUsername("soylent");
		addNewSupplierCompanyPage.enterLoginEmail("soylent@gmail.com");
		addNewSupplierCompanyPage.clickSubmitButton();

		// Assertion to verify that the BR attachment is uploaded
		WebElement brAttachmentUpload = driver.findElement(By.xpath(""));
		Assert.assertNotNull(brAttachmentUpload.getAttribute("value"), "BR Attachment should be uploaded");

		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	// @Test(priority = 6)
	// public void testLatitudeField() throws InterruptedException {
	// addNewSupplierCompanyPage.clickAddNewSupplierButton();
	// addNewSupplierCompanyPage.selectCompanyToggle();
	// addNewSupplierCompanyPage.enterLatitude("10");
	//
	// // Assertion to verify the entered latitude
	// WebElement latitudeField = driver.findElement(By.name("latitude"));
	// Assert.assertEquals(latitudeField.getAttribute("value"), "10", "Latitude
	// should be entered correctly");
	//
	// driver.navigate().refresh();
	// Thread.sleep(3000);
	// }
	//
	// @Test(priority = 7)
	// public void testLongitudeField() throws InterruptedException {
	// addNewSupplierCompanyPage.clickAddNewSupplierButton();
	// addNewSupplierCompanyPage.selectCompanyToggle();
	// addNewSupplierCompanyPage.enterLongitude("106");
	//
	// // Assertion to verify the entered longitude
	// WebElement longitudeField = driver.findElement(By.name("longitude"));
	// Assert.assertEquals(longitudeField.getAttribute("value"), "106", "Longitude
	// should be entered correctly");
	//
	// driver.navigate().refresh();
	// Thread.sleep(3000);
	// }
	//
	// @Test(priority = 8)
	// public void testLocation() throws InterruptedException {
	// Map<String, Object> coordinates = new HashMap<>();
	// coordinates.put("latitude", 42.1408845);
	// coordinates.put("longitude", -72.5033907);
	// coordinates.put("accuracy", 100);
	//
	// driver.navigate().refresh();
	// Thread.sleep(3000);
	//
	// }

}
